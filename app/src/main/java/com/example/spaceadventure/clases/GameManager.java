package com.example.spaceadventure.clases;

import com.example.alex_framework.CollisionDetect;
import com.example.alex_framework.CoreFW;
import com.example.alex_framework.GraphicFW;
import com.example.spaceadventure.generator.GeneratorBackground;
import com.example.spaceadventure.generator.GeneratorEnemy;
import com.example.spaceadventure.generator.GeneratorGifts;
import com.example.spaceadventure.objects.Hood;
import com.example.spaceadventure.objects.MainPlayer;
import com.example.spaceadventure.utilits.UtilResource;

public class GameManager {
    public final static double SPEED_ANIMATION = 3;
    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    private int passedDistance;
    private int currentSpeedPlayer;
    private int shieldsPlayer;

    public static boolean gameOver;

    public int getPassedDistance(){
        return passedDistance;
    };

    MainPlayer mainPlayer;
    GeneratorBackground generatorBackground;
    GeneratorEnemy generatorEnemy;
    GeneratorGifts generatorGifts;
    Hood hood;


    public GameManager(CoreFW coreFW, int sceneWidth, int sceneHeight) {
        hood = new Hood(coreFW);
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        minScreenY = hood.getHEIGHT_HOOD();
        minScreenX = 0;
        mainPlayer = new MainPlayer(coreFW,maxScreenX, maxScreenY, minScreenY);
        generatorBackground = new GeneratorBackground(sceneWidth, sceneHeight, minScreenY);
        generatorGifts = new GeneratorGifts(sceneWidth, sceneHeight, minScreenY);
        generatorEnemy = new GeneratorEnemy(sceneWidth, sceneHeight, minScreenY);
        gameOver = false;
    }

    public void update (){
        generatorBackground.update(mainPlayer.getSpeedPlayer());
        mainPlayer.update();
        generatorEnemy.update(mainPlayer.getSpeedPlayer());
        generatorGifts.update(mainPlayer.getSpeedPlayer());

        passedDistance+=mainPlayer.getSpeedPlayer();
        currentSpeedPlayer = (int) mainPlayer.getSpeedPlayer()*60;
        shieldsPlayer = mainPlayer.getShieldsPlayer();
        hood.update(passedDistance, currentSpeedPlayer, shieldsPlayer);

        checkHit();

    }

    private void checkHit() {
        for (int i = 0; i < generatorEnemy.enemyArrayList.size(); i++) {
            if (CollisionDetect.collisionDetect(mainPlayer, generatorEnemy.enemyArrayList.get(i))){
                UtilResource.hit.play(1);
                mainPlayer.hitEnemy();
                generatorEnemy.hitPlayer(generatorEnemy.enemyArrayList.get(i));
            }
        }
        if (CollisionDetect.collisionDetect(mainPlayer, generatorGifts.getProtector())){
            hitPlayerWithProtector();
        }
    }

    private void hitPlayerWithProtector() {
        mainPlayer.hitProtector();
        generatorGifts.hitProtectorWithPlayer();
    }

    public void drawing(CoreFW coreFW, GraphicFW graphicFW){
        mainPlayer.drawing(graphicFW);
        generatorBackground.drawing(graphicFW);
        generatorGifts.drawing(graphicFW);
        generatorEnemy.drawing(graphicFW);
        hood.drawing(graphicFW);
    }
}

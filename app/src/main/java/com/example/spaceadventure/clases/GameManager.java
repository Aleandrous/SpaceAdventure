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
    private int mPassedDistance;
    public static boolean gameOver;
    private MainPlayer mMainPlayer;
    private GeneratorBackground mGeneratorBackground;
    private GeneratorEnemy mGeneratorEnemy;
    private GeneratorGifts mGeneratorGifts;
    private Hood mHood;
    public GameManager(CoreFW coreFW, int sceneWidth, int sceneHeight) {
        init(coreFW, sceneWidth, sceneHeight);
    }
    private void init(CoreFW coreFW, int sceneWidth, int sceneHeight) {
        mHood = new Hood(coreFW);
        int mMinScreenY = mHood.getHEIGHT_HOOD();
        mMainPlayer = new MainPlayer(coreFW, sceneWidth, sceneHeight, mMinScreenY);
        mGeneratorBackground = new GeneratorBackground(sceneWidth, sceneHeight, mMinScreenY);
        mGeneratorGifts = new GeneratorGifts(sceneWidth, sceneHeight, mMinScreenY);
        mGeneratorEnemy = new GeneratorEnemy(sceneWidth, sceneHeight, mMinScreenY);
        gameOver = false;
    }
    public void update() {
        mGeneratorBackground.update(mMainPlayer.getSpeedPlayer());
        mMainPlayer.update();
        mGeneratorEnemy.update(mMainPlayer.getSpeedPlayer());
        mGeneratorGifts.update(mMainPlayer.getSpeedPlayer());
        mPassedDistance += mMainPlayer.getSpeedPlayer();
        int mCurrentSpeedPlayer = (int) mMainPlayer.getSpeedPlayer() * 60;
        int mShieldsPlayer = mMainPlayer.getShieldsPlayer();
        mHood.update(mPassedDistance, mCurrentSpeedPlayer, mShieldsPlayer);
        checkHit();
    }
    private void checkHit() {
        for (int i = 0; i < mGeneratorEnemy.enemyArrayList.size(); i++) {
            if (CollisionDetect.collisionDetect(mMainPlayer, mGeneratorEnemy.enemyArrayList.get(i))) {
                UtilResource.mHit.play(1);
                mMainPlayer.hitEnemy();
                mGeneratorEnemy.hitPlayer(mGeneratorEnemy.enemyArrayList.get(i));
            }
        }
        if (CollisionDetect.collisionDetect(mMainPlayer, mGeneratorGifts.getProtector())) {
            hitPlayerWithProtector();
        }
    }
    private void hitPlayerWithProtector() {
        mMainPlayer.hitProtector();
        mGeneratorGifts.hitProtectorWithPlayer();
    }
    public void drawing(GraphicFW graphicFW) {
        mMainPlayer.drawing(graphicFW);
        mGeneratorBackground.drawing(graphicFW);
        mGeneratorGifts.drawing(graphicFW);
        mGeneratorEnemy.drawing(graphicFW);
        mHood.drawing(graphicFW);
    }
    public int getPassedDistance() {
        return mPassedDistance;
    }
}

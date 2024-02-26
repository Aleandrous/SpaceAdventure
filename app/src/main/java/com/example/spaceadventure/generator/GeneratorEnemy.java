package com.example.spaceadventure.generator;

import com.example.alex_framework.GraphicFW;
import com.example.spaceadventure.objects.Enemy;
import java.util.ArrayList;
public class GeneratorEnemy {
    private final int mMaxScreenY;
    private final int mMaxScreenX;
    private final int mMinScreenY;
    public ArrayList<Enemy> enemyArrayList;
    public GeneratorEnemy(int sceneWidth, int sceneHeight, int minScreenY) {
        this.mMaxScreenX = sceneWidth;
        this.mMaxScreenY = sceneHeight;
        this.mMinScreenY = minScreenY;
        enemyArrayList = new ArrayList<>();
    }
    public void update(double speedPlayer) {
        if (enemyArrayList.size()<3){
            addEnemy(3);
        }
        for (int i = 0; i < enemyArrayList.size() ; i++) {
            enemyArrayList.get(i).update(speedPlayer);
                    }
    }
    private void addEnemy(int amountEnemy) {
        for (int i = 0; i < amountEnemy; i++) {
            enemyArrayList.add(new Enemy(mMaxScreenX, mMaxScreenY, mMinScreenY, 1));
        }
    }
    public void drawing(GraphicFW graphicFW){
        for (int i = 0; i < enemyArrayList.size() ; i++) {
            enemyArrayList.get(i).drawing(graphicFW);
        }
    }
    public void hitPlayer(Enemy enemy) {
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.remove(enemy);
        }
    }
}

package com.example.spaceadventure.objects;

import android.graphics.Rect;

import com.example.alex_framework.AnimationFW;
import com.example.alex_framework.GraphicFW;
import com.example.alex_framework.ObjectFW;
import com.example.alex_framework.utilits.UtilRandomFW;
import com.example.spaceadventure.utilits.UtilResource;

public class Enemy extends ObjectFW{
    private AnimationFW mAnimEnemy;
    public Enemy( int maxScreenX, int maxScreenY, int minScreenY, int enemyType) {
        init(maxScreenX, maxScreenY, minScreenY);
        initTypeEnemy(enemyType);
    }
    private void initTypeEnemy(int enemyType) {
        switch (enemyType){
            case 1 :
                speed = UtilRandomFW.getGap(1, 6);
                mAnimEnemy = new AnimationFW(3,
                        UtilResource.mSpriteEnemy.get(0),
                        UtilResource.mSpriteEnemy.get(1),
                        UtilResource.mSpriteEnemy.get(2),
                        UtilResource.mSpriteEnemy.get(3));
                break;
            case 2 :
                speed = UtilRandomFW.getGap(4, 9);
                break;
        }
    }
    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    private void init(int maxScreenX, int maxScreenY, int minScreenY) {
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.mSpriteEnemy.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;
        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        radius = UtilResource.mSpriteEnemy.get(0).getHeight()/4;
    }
    public void update(double speedPlayer){
        x-=speed;
        x-=speedPlayer;
        if (x<minScreenX){
            x = maxScreenX;
            y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        }
        mAnimEnemy.runAnimation();

        hitBox = new Rect(x,y,
                UtilResource.mSpriteEnemy.get(0).getWidth(),
                UtilResource.mSpriteEnemy.get(0).getHeight());
    }
    public void drawing(GraphicFW graphicFW){
        mAnimEnemy.drawingAnimation(graphicFW, x, y);
    }
}

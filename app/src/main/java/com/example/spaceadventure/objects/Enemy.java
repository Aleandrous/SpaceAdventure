package com.example.spaceadventure.objects;

import android.graphics.Rect;

import com.example.alex_framework.AnimationFW;
import com.example.alex_framework.GraphicFW;
import com.example.alex_framework.ObjectFW;
import com.example.alex_framework.utilits.UtilRandomFW;
import com.example.spaceadventure.utilits.UtilResource;

public class Enemy extends ObjectFW{
    AnimationFW animEnemy;
    public Enemy( int maxScreenX, int maxScreenY, int minScreenY, int enemyType) {
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spriteEnemy.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;
        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        radius = UtilResource.spriteEnemy.get(0).getHeight()/4;
        switch (enemyType){
            case 1 :
                speed = UtilRandomFW.getGap(1, 6);
                animEnemy = new AnimationFW(3,
                        UtilResource.spriteEnemy.get(0),
                        UtilResource.spriteEnemy.get(1),
                        UtilResource.spriteEnemy.get(2),
                        UtilResource.spriteEnemy.get(3));
                break;
            case 2 :
                speed = UtilRandomFW.getGap(4, 9);
                break;
        }
    }
    public void update(double speedPlayer){
        x-=speed;
        x-=speedPlayer;
        if (x<minScreenX){
            x = maxScreenX;
            y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        }
        animEnemy.runAnimation();

        hitBox = new Rect(x,y,
                UtilResource.spriteEnemy.get(0).getWidth(),
                UtilResource.spriteEnemy.get(0).getHeight());
    }
    public void drawing(GraphicFW graphicFW){

        animEnemy.drawingAnimation(graphicFW, x, y);
    }
}

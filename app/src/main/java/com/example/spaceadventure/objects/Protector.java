package com.example.spaceadventure.objects;

import android.graphics.Rect;
import com.example.alex_framework.AnimationFW;
import com.example.alex_framework.GraphicFW;
import com.example.alex_framework.ObjectFW;
import com.example.alex_framework.utilits.UtilRandomFW;
import com.example.spaceadventure.clases.GameManager;
import com.example.spaceadventure.utilits.UtilResource;

public class Protector extends ObjectFW {
    AnimationFW animProtector;
        public Protector( int maxScreenX, int maxScreenY, int minScreenY) {
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spriteProtector.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;
        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        radius = UtilResource.spriteProtector.get(0).getHeight()/2;
        hitBox = new Rect(x,y,
                    UtilResource.spriteProtector.get(0).getWidth(),
                    UtilResource.spriteProtector.get(0).getHeight());
        animProtector = new AnimationFW(GameManager.SPEED_ANIMATION,
                UtilResource.spriteProtector.get(0),
                UtilResource.spriteProtector.get(1),
                UtilResource.spriteProtector.get(2),
                UtilResource.spriteProtector.get(3));

    }
    public void update(double speedPlayer){
            x-=speed;
            x-=speedPlayer;
            if (x<minScreenX){
            y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        }
        animProtector.runAnimation();
        hitBox = new Rect(x,y,
                UtilResource.spriteProtector.get(0).getWidth(),
                UtilResource.spriteProtector.get(0).getHeight());
    }
    public void drawing(GraphicFW graphicFW){

        animProtector.drawingAnimation(graphicFW, x, y);
    }

}

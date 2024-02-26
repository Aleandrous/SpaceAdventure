package com.example.spaceadventure.objects;

import android.graphics.Rect;
import com.example.alex_framework.AnimationFW;
import com.example.alex_framework.GraphicFW;
import com.example.alex_framework.ObjectFW;
import com.example.alex_framework.utilits.UtilRandomFW;
import com.example.spaceadventure.clases.GameManager;
import com.example.spaceadventure.utilits.UtilResource;

public class Protector extends ObjectFW {
    @SuppressWarnings("FieldMayBeFinal")
    private AnimationFW mAnimProtector;
        @SuppressWarnings("IntegerDivisionInFloatingPointContext")
        public Protector(int maxScreenX, int maxScreenY, int minScreenY) {
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.mSpriteProtector.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;
        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        radius = UtilResource.mSpriteProtector.get(0).getHeight()/2;
        hitBox = new Rect(x,y,
                    UtilResource.mSpriteProtector.get(0).getWidth(),
                    UtilResource.mSpriteProtector.get(0).getHeight());
        mAnimProtector = new AnimationFW(GameManager.SPEED_ANIMATION,
                UtilResource.mSpriteProtector.get(0),
                UtilResource.mSpriteProtector.get(1),
                UtilResource.mSpriteProtector.get(2),
                UtilResource.mSpriteProtector.get(3));

    }
    public void update(double speedPlayer){
            x-=speed;
            x-=speedPlayer;
            if (x<minScreenX){
            y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        }
        mAnimProtector.runAnimation();
        hitBox = new Rect(x,y,
                UtilResource.mSpriteProtector.get(0).getWidth(),
                UtilResource.mSpriteProtector.get(0).getHeight());
    }
    public void drawing(GraphicFW graphicFW){

        mAnimProtector.drawingAnimation(graphicFW, x, y);
    }

}

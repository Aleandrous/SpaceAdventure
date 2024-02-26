package com.example.spaceadventure.generator;

import com.example.alex_framework.GraphicFW;
import com.example.alex_framework.utilits.UtilTimerDelay;
import com.example.spaceadventure.objects.MainPlayer;
import com.example.spaceadventure.objects.Protector;
public class GeneratorGifts {
    private Protector mProtector;
    private UtilTimerDelay mTimerProtector;
    private int mMaxScreenY;
    private int mMaxScreenX;
    private int mMinScreenY;
    private int mMinScreenX;

    public GeneratorGifts(int sceneWidth, int sceneHeight, int minScreenY) {
        init(sceneWidth, sceneHeight, minScreenY);
    }
    private void init(int sceneWidth, int sceneHeight, int minScreenY) {
        this.mMaxScreenX = sceneWidth;
        this.mMaxScreenY = sceneHeight;
        this.mMinScreenY = minScreenY;
        this.mMinScreenX = 0;
        mProtector = new Protector(mMaxScreenX, mMaxScreenY, minScreenY);
        mTimerProtector = new UtilTimerDelay();
        mTimerProtector.startTimer();
    }
    public void update(double speedPlayer) {
        if (mTimerProtector.timerDelay(8)&&(!MainPlayer.isShieldsOn())){
            mProtector.update(speedPlayer);
            if (mProtector.getX()< mMinScreenX){
                mProtector = null;
                mProtector = new Protector(mMaxScreenX, mMaxScreenY, mMinScreenY);
                mTimerProtector.startTimer();
            }
        }
    }
    public void drawing(GraphicFW graphicFW) {
        mProtector.drawing(graphicFW);
    }
    public Protector getProtector() {
        return mProtector;
    }
    public void hitProtectorWithPlayer() {
        mProtector = null;
        mProtector = new Protector(mMaxScreenX, mMaxScreenY, mMinScreenY);
        mTimerProtector.startTimer();
    }
}

package com.example.spaceadventure.generator;

import com.example.alex_framework.GraphicFW;
import com.example.alex_framework.utilits.UtilTimerDelay;
import com.example.spaceadventure.objects.MainPlayer;
import com.example.spaceadventure.objects.Protector;

import java.util.ArrayList;

public class GeneratorGifts {
    Protector protector;
    UtilTimerDelay timerProtector;
    private int maxScreenY;
    private int maxScreenX;
    private int minScreenY;
    private int minScreenX;

    public GeneratorGifts(int sceneWidth, int sceneHeight, int minScreenY) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        this.minScreenY = minScreenY;
        this.minScreenX = 0;
        protector = new Protector(maxScreenX, maxScreenY,minScreenY);
        timerProtector = new UtilTimerDelay();
        timerProtector.startTimer();
    }
    public void update(double speedPlayer) {
        if (timerProtector.timerDelay(8)&&(!MainPlayer.isShieldsOn())){
            protector.update(speedPlayer);
            if (protector.getX()<minScreenX){
                protector = null;
                protector = new Protector(maxScreenX, maxScreenY,minScreenY);
                timerProtector.startTimer();
            }
        }
    }
    public void drawing(GraphicFW graphicFW) {
        protector.drawing(graphicFW);
    }

    public Protector getProtector() {
        return protector;
    }

    public void hitProtectorWithPlayer() {
        protector = null;
        protector = new Protector(maxScreenX, maxScreenY,minScreenY);
        timerProtector.startTimer();
    }
}

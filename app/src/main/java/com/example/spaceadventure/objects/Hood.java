package com.example.spaceadventure.objects;

import android.graphics.Color;

import com.example.alex_framework.CoreFW;
import com.example.alex_framework.GraphicFW;
import com.example.spaceadventure.R;

public class Hood {
    private int passedDistance;
    private int currentSpeedPlayer;
    private int currentShieldsPlayer;

    CoreFW coreFW;

    private final int HEIGHT_HOOD = 50;

    public Hood(CoreFW coreFW){
        this.coreFW = coreFW;
    }
    public void update(int passedDistance, int currentSpeedPlayer,int currentShieldsPlayer){
        this.passedDistance = passedDistance;
        this.currentSpeedPlayer = currentSpeedPlayer;
        this.currentShieldsPlayer = currentShieldsPlayer;
    }
    public void drawing(GraphicFW graphicFW){
        graphicFW.drawLine(0, HEIGHT_HOOD,graphicFW.getWithFrameBuffer(),HEIGHT_HOOD, Color.WHITE);
        graphicFW.drawText(coreFW.getString(R.string.txt_hood_passedDistance)+ ":" + passedDistance,
                10, 30, Color.GREEN, 25, null);
        graphicFW.drawText(coreFW.getString(R.string.txt_hood_currentSpeedPlayer) + ":" + currentSpeedPlayer,
                350, 30, Color.GREEN, 25, null);
        graphicFW.drawText(coreFW.getString(R.string.txt_hood_currentShields) + ":" + currentShieldsPlayer,
                650, 30, Color.GREEN, 25, null);
    }
    public int getHEIGHT_HOOD() {
        return HEIGHT_HOOD;
    }
}

package com.example.spaceadventure.objects;

import android.graphics.Color;
import com.example.alex_framework.CoreFW;
import com.example.alex_framework.GraphicFW;
import com.example.spaceadventure.R;
public class Hood {
    private int mPassedDistance;
    private int mCurrentSpeedPlayer;
    private int mCurrentShieldsPlayer;
    private final CoreFW mCoreFW;
    private final int HEIGHT_HOOD = 50;
    public Hood(CoreFW coreFW){
        this.mCoreFW = coreFW;
    }
    public void update(int passedDistance, int currentSpeedPlayer,int currentShieldsPlayer){
        this.mPassedDistance = passedDistance;
        this.mCurrentSpeedPlayer = currentSpeedPlayer;
        this.mCurrentShieldsPlayer = currentShieldsPlayer;
    }
    public void drawing(GraphicFW graphicFW){
        graphicFW.drawLine(0, HEIGHT_HOOD,graphicFW.getWithFrameBuffer(),HEIGHT_HOOD, Color.WHITE);
        graphicFW.drawText(mCoreFW.getString(R.string.txt_hood_passedDistance)+ ":" + mPassedDistance,
                10, 30, Color.GREEN, 25, null);
        graphicFW.drawText(mCoreFW.getString(R.string.txt_hood_currentSpeedPlayer) + ":" + mCurrentSpeedPlayer,
                350, 30, Color.GREEN, 25, null);
        graphicFW.drawText(mCoreFW.getString(R.string.txt_hood_currentShields) + ":" + mCurrentShieldsPlayer,
                650, 30, Color.GREEN, 25, null);
    }
    public int getHEIGHT_HOOD() {
        return HEIGHT_HOOD;
    }
}

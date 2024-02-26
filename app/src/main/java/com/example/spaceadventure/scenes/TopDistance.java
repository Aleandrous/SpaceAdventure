package com.example.spaceadventure.scenes;

import android.graphics.Color;
import com.example.alex_framework.CoreFW;
import com.example.alex_framework.SceneFW;
import com.example.spaceadventure.R;
import com.example.spaceadventure.utilits.SettingsGame;
public class TopDistance extends SceneFW {
    @SuppressWarnings("FieldMayBeFinal")
    private String[] mNumbers = new String[5];
    public TopDistance(CoreFW coreFW) {
        super(coreFW);
        for (int i = 0; i < 5; i++) {
            this.mNumbers[i] = " "+(i+1) + "." + SettingsGame.distance[i];
        }
    }
    @Override
    public void update() {
        if (coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)){
            coreFW.setScene(new MainMenuScene(coreFW));
        }
    }
    @Override
    public void drawing() {
        graphicFW.drawText(coreFW.getString(R.string.txt_top_distance),120, 200, Color.BLUE, 40, null);
        graphicFW.drawText(String.valueOf(mNumbers[0]), 120, 250, Color.GREEN, 35,null);
        graphicFW.drawText(String.valueOf(mNumbers[1]), 120, 300, Color.GREEN, 35,null);
        graphicFW.drawText(String.valueOf(mNumbers[2]), 120, 350, Color.GREEN, 35,null);
        graphicFW.drawText(String.valueOf(mNumbers[3]), 120, 400, Color.GREEN, 35,null);
        graphicFW.drawText(String.valueOf(mNumbers[4]), 120, 450, Color.GREEN, 35,null);
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
        graphicFW.clearScene(Color.BLACK);
    }
    @Override
    public void dispose() {
    }
}

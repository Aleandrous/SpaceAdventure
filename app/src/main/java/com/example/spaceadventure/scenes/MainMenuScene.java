package com.example.spaceadventure.scenes;

import android.graphics.Color;
import com.example.alex_framework.CoreFW;
import com.example.alex_framework.SceneFW;
import com.example.spaceadventure.R;
import com.example.spaceadventure.utilits.UtilResource;
public class MainMenuScene extends SceneFW {
    public MainMenuScene(CoreFW coreFW) {
        super(coreFW);
    }
    @Override
    public void update() {
        if(coreFW.getTouchListenerFW().getTouchUp(20, 300, 100, 50)){
            coreFW.setScene(new GameScene(coreFW));
            UtilResource.mTouch.play(1);
        }
        if(coreFW.getTouchListenerFW().getTouchUp(20, 400, 100, 50)){
            coreFW.setScene(new TopDistance(coreFW));
            UtilResource.mTouch.play(1);
        }
    }
    @Override
    public void drawing() {
        graphicFW.clearScene(Color.BLACK);
        graphicFW.drawText(coreFW.getString(R.string.txt_mainMenu_nameGame), 100, 100, Color.BLUE, 60, null);
        graphicFW.drawText(coreFW.getString(R.string.txt_mainMenu_newGame), 20, 300, Color.BLUE, 40, null);
        graphicFW.drawText(coreFW.getString(R.string.txt_mainMenu_settings), 20, 350, Color.BLUE, 40, null);
        graphicFW.drawText(coreFW.getString(R.string.txt_mainMenu_results), 20, 400, Color.BLUE, 40, null);
        graphicFW.drawText(coreFW.getString(R.string.txt_mainMenu_exitGame), 20, 450, Color.BLUE, 40, null);
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
    @Override
    public void dispose() {
    }
}

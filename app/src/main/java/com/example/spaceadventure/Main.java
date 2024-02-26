package com.example.spaceadventure;

import com.example.alex_framework.CoreFW;
import com.example.alex_framework.SceneFW;
import com.example.spaceadventure.clases.LoaderAssets;
import com.example.spaceadventure.scenes.MainMenuScene;
public class Main extends CoreFW {
    public SceneFW getStartScene(){
        //TODO сделать отдельный поток для LoaderAssets AsyncTask
        LoaderAssets LoaderAssets = new LoaderAssets(this, this.getGraphicFW());
        return new MainMenuScene(this);
    }
}
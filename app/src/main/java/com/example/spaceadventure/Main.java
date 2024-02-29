package com.example.spaceadventure;

import com.example.alex_framework.CoreFW;
import com.example.alex_framework.SceneFW;
import com.example.spaceadventure.scenes.LoaderResourceScene;
public class Main extends CoreFW {
    public SceneFW getStartScene(){
        return new LoaderResourceScene(this);
    }
}
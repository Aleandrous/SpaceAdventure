package com.example.spaceadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.alex_framework.CoreFW;
import com.example.alex_framework.LoopFW;
import com.example.alex_framework.SceneFW;
import com.example.spaceadventure.scenes.MainMenuScene;

public class Main extends CoreFW {
    public SceneFW getStartScene(){
        return new MainMenuScene(this);
    }

}
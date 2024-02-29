package com.example.spaceadventure.scenes;

import android.graphics.Color;

import com.example.alex_framework.CoreFW;
import com.example.alex_framework.SceneFW;
import com.example.spaceadventure.R;

import interfaces.TaskCompleteListener;
import tasks.LoaderTask;

public class LoaderResourceScene extends SceneFW implements TaskCompleteListener {
    private static int mProgressLoader;
    public LoaderResourceScene(CoreFW coreFW) {
        super(coreFW);
        mProgressLoader = 0;
        LoaderTask loaderTask = new LoaderTask(coreFW,this);
        loaderTask.execute();

    }

    @Override
    public void update() {
            }

    @Override
    public void drawing() {
        coreFW.getGraphicFW().clearScene(Color.BLACK);
        coreFW.getGraphicFW().drawText(coreFW.getString(R.string.loading),
                100, 100, Color.GREEN, 50, null);
        coreFW.getGraphicFW().drawLine(0, 500, mProgressLoader, 500, Color.GREEN);



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

    @Override
    public void onComplete() {

        coreFW.setScene(new MainMenuScene(coreFW));
    }

    public static void setProgressLoader(int progressLoader) {
        LoaderResourceScene.mProgressLoader = progressLoader;
    }
}

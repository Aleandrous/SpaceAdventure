package com.example.alex_framework;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CoreFW extends AppCompatActivity {
    private final float frame_buffer_width = 800;
    private final float frame_buffer_height = 600;
    private LoopFW loopFW;
    private GraphicFW graphicFW;
    private TouchListenerFW touchListenerFW;
    private Display display;
    private Point sizeDisplay;
    private Bitmap frameBuffer;
    private SceneFW sceneFW;
    private float sceneWidth;
    private float sceneHeight;

    private boolean stateOnPause;
    private boolean stateOnResume;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        sizeDisplay = new Point();
        display = getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);

        frameBuffer = Bitmap.createBitmap((int) frame_buffer_width, (int) frame_buffer_height, Bitmap.Config.ARGB_8888);
        sceneWidth = frame_buffer_width / sizeDisplay.x;
        sceneHeight = frame_buffer_height / sizeDisplay.y;

        loopFW = new LoopFW (this, frameBuffer);
        graphicFW = new GraphicFW(getAssets(), frameBuffer);
        touchListenerFW = new TouchListenerFW(loopFW, sceneWidth, sceneHeight);



        sceneFW = getStartScene();

        stateOnPause = false;
        stateOnResume = false;

        setContentView(loopFW);

    }

    public CoreFW() {

    }
    public void onResume(){
        super.onResume();
        sceneFW.resume();
        loopFW.Start_game();
    }
    public void onPause(){
        super.onPause();
        sceneFW.pause();
        loopFW.Stop_game();
        stateOnPause = true;
        if (isFinishing()){
            sceneFW.dispose();
        }
    }
    public GraphicFW getGraphicFW(){
        return graphicFW;
    }
    public TouchListenerFW getTouchListenerFW(){
        return touchListenerFW;
    }
    public void setScene(SceneFW sceneFW){
        if(sceneFW == null){
            throw new IllegalArgumentException("Невозможно загрузить сцену!");
        }
        this.sceneFW.pause();
        this.sceneFW.dispose();
        sceneFW.resume();
        sceneFW.update();
        this.sceneFW = sceneFW;
    }
    public SceneFW getCurrentScene() {return sceneFW;}
    public SceneFW getStartScene(){return sceneFW;}
}

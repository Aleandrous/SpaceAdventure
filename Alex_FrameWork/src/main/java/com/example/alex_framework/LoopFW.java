package com.example.alex_framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Date;

public class LoopFW extends SurfaceView implements Runnable {
    private final float FPS=60;
    private final float Second=1000000000;
    private final float Update_time=Second/FPS;
    private boolean Running=false;
    Thread Game_thread = null;
    CoreFW coreFW;
    Bitmap frameBuffer;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Rect rect;

    public LoopFW(CoreFW coreFW, Bitmap frameBuffer) {
        super(coreFW);
        this.frameBuffer = frameBuffer;
        this.coreFW = coreFW;
        this.surfaceHolder = getHolder();
        rect = new Rect();
        canvas = new Canvas();
    }



//Temp
    float Updates = 0;
    float Drawing = 0;
    long Timer = 0;
//Temp







    @Override
    public void run() {


        float Last_time=System.nanoTime();
        float Delta = 0;
        Timer = System.currentTimeMillis();


        while (Running){
            float Now_time=System.nanoTime();
            float Elapced_time = Now_time - Last_time;
            Last_time = Now_time;
            Delta += Elapced_time/Update_time;
            if (Delta > 1){
                Update_game();
                Drawing_game();
                Delta--;
            }
            if (System.currentTimeMillis() - Timer > 1000){
                Date Current_date = new Date();
                System.out.println("Updates = " + Updates + "Drawing" + Drawing + " " + Current_date.toString());
                Updates = 0;
                Drawing = 0;
                Timer += 1000;
            }
        }
    }
    public void Update_game(){
        Updates ++;
        coreFW.getCurrentScene().update();
    }
    public void Drawing_game(){
        Drawing ++;
        if(surfaceHolder.getSurface().isValid()){
            canvas = surfaceHolder.lockCanvas();
            canvas.getClipBounds(rect);
            canvas.drawBitmap(frameBuffer, null, rect, null);
            coreFW.getCurrentScene().drawing();
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
    public void Start_game(){
        if (Running){
            return;
        }
        Running=true;
        Game_thread=new Thread(this);
        Game_thread.start();
    }
    public void Stop_game(){
        if (!Running) {
            return;
        }
        Running=false;
        try {
            Game_thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);//Код отличается от представленного в уроке.
        }

    }


}

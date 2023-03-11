package com.example.alex_framework;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;

public class GraphicFW {
    private AssetManager asset_manager_game;
    private Bitmap frame_buffer_game;
    private Canvas canvas_game;
    private Paint paint_game;
    private Bitmap texture_game;

    public GraphicFW(AssetManager asset_manager_game, Bitmap frame_buffer_game) {
        this.asset_manager_game = asset_manager_game;
        this.frame_buffer_game = frame_buffer_game;
        this.canvas_game = new Canvas(frame_buffer_game);
        this.paint_game = new Paint();
    }
    public void clearScene(int colorRGB){
        canvas_game.drawRGB(colorRGB, colorRGB, colorRGB);
    }
    public void drawPixel(int x, int y, int color){
        paint_game.setColor(color);
        canvas_game.drawPoint(x,y,paint_game);
    }
    public void drawLine(int start_x, int start_y, int stop_x, int stop_y, int color){
        paint_game.setColor(color);
        canvas_game.drawLine(start_x,start_y,stop_x, stop_y, paint_game);
    }
    public void drawText(String text, int x, int y, int color, int size_text, Typeface font){
        paint_game.setColor(color);
        paint_game.setTextSize(size_text);
        paint_game.setTypeface(font);
        canvas_game.drawText(text, x, y, paint_game);
    }
    public void drawTexture(Bitmap texture_game, int x, int y){
        canvas_game.drawBitmap(texture_game, x, y, null);
    }
    public int getWithFrameBuffer(){
        return frame_buffer_game.getWidth();
    }
    public int getHeightFrameBuffer(){
        return frame_buffer_game.getHeight();
    }
    public Bitmap newTexture(String file_name){
        InputStream inputStream = null;
        try {
            inputStream = asset_manager_game.open(file_name);
            texture_game = BitmapFactory.decodeStream(inputStream);
            if (texture_game == null){
                throw new RuntimeException("Невозмно загрузить файл" + file_name);
            }
        } catch (IOException e) {
            throw new RuntimeException("Невозмно загрузить файл" + file_name);
        }
        if (inputStream != null){
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return texture_game;
    }
    public Bitmap newSprite(Bitmap textureAtlas, int x, int y, int widthSprite, int heightSprite){
        Bitmap newSprite = Bitmap.createBitmap(textureAtlas, x, y, widthSprite, heightSprite);
        return newSprite;
    }
}

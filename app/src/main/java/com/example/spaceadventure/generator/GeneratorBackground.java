package com.example.spaceadventure.generator;

import android.graphics.Color;
import com.example.alex_framework.GraphicFW;
import com.example.spaceadventure.objects.Star;
import java.util.ArrayList;
public class GeneratorBackground {
    private final ArrayList<Star> mStarArrayList = new ArrayList<>();
    public GeneratorBackground (int sceneWidth, int sceneHeight, int minScreenY){
        int starsSpeak = 50;
        for (int i = 0; i < starsSpeak; i++) {
            Star star = new Star(sceneWidth, sceneHeight, minScreenY);
            mStarArrayList.add(star);
        }
    }
    public void update(double speedPlayer){
        for (int i = 0; i < mStarArrayList.size(); i++) {
            mStarArrayList.get(i).update(speedPlayer);
        }
    }
    public void drawing(GraphicFW graphicFW){
        for (int i = 0; i < mStarArrayList.size(); i++) {
            graphicFW.drawPixel(mStarArrayList.get(i).getX(), mStarArrayList.get(i).getY(), Color.WHITE);
        }
    }
}

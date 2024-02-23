package com.example.spaceadventure.generator;

import android.graphics.Color;

import com.example.alex_framework.GraphicFW;
import com.example.spaceadventure.objects.Star;

import java.util.ArrayList;

public class GeneratorBackground {
    public ArrayList<Star> starArrayList = new ArrayList<Star>();
    public GeneratorBackground (int sceneWidth, int sceneHeight, int minScreenY){
        int starsSpeak = 50;
        for (int i = 0; i < starsSpeak; i++) {
            Star star = new Star(sceneWidth, sceneHeight, minScreenY);
            starArrayList.add(star);
        }
    }
    public void update(double speedPlayer){
        for (int i = 0; i < starArrayList.size(); i++) {
            starArrayList.get(i).update(speedPlayer);
        }
    }
    public void drawing(GraphicFW graphicFW){
        for (int i = 0; i < starArrayList.size(); i++) {
            graphicFW.drawPixel(starArrayList.get(i).getX(),starArrayList.get(i).getY(), Color.WHITE);
        }

    }
}

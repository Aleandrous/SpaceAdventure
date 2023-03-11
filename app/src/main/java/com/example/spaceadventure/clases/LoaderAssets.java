package com.example.spaceadventure.clases;

import com.example.alex_framework.CoreFW;
import com.example.alex_framework.GraphicFW;
import com.example.alex_framework.utilits.UtilResource;

public class LoaderAssets {
    public LoaderAssets(CoreFW coreFW, GraphicFW graphicFW) {
        loadTexture(graphicFW);
        loadSpritePlayer(graphicFW);
    }

    private void loadSpritePlayer(GraphicFW graphicFW) {
        UtilResource.spritePlayer.add(graphicFW.newSprite(UtilResource.textureAtlas, 0,0,64,64));
        UtilResource.spritePlayer.add(graphicFW.newSprite(UtilResource.textureAtlas, 64,0,64,64));
        UtilResource.spritePlayer.add(graphicFW.newSprite(UtilResource.textureAtlas, 128,0,64,64));
        UtilResource.spritePlayer.add(graphicFW.newSprite(UtilResource.textureAtlas, 192,0,64,64));
    }
//6 lesson 13.30
    private void loadTexture(GraphicFW graphicFW) {
        UtilResource.textureAtlas = graphicFW.newTexture("texture_atlas.png");

    }
}

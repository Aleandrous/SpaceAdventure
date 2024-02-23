package com.example.spaceadventure.clases;

import com.example.alex_framework.CoreFW;
import com.example.alex_framework.GraphicFW;
import com.example.spaceadventure.utilits.UtilResource;

import java.util.ArrayList;

public class LoaderAssets{
    public LoaderAssets(CoreFW coreFW, GraphicFW graphicFW) {
        loadTexture(graphicFW);
        loadSpritePlayer(graphicFW);
        loadSpriteEnemy(graphicFW);
        loadOther(graphicFW);
        loadAudio(coreFW);
        loadSpritePlayerShieldsOn(graphicFW);
        loadGifts(graphicFW);

    }

    private void loadSpritePlayerShieldsOn(GraphicFW graphicFW) {
        UtilResource.spritePlayerShieldsOn = new ArrayList<>();
        UtilResource.spritePlayerShieldsOnBoost=new ArrayList<>();

        UtilResource.spritePlayerShieldsOn.add(graphicFW.newSprite(UtilResource.textureAtlas,
                0,128, 64,64));
        UtilResource.spritePlayerShieldsOn.add(graphicFW.newSprite(UtilResource.textureAtlas,
                64,128, 64,64));
        UtilResource.spritePlayerShieldsOn.add(graphicFW.newSprite(UtilResource.textureAtlas,
                128,128, 64,64));
        UtilResource.spritePlayerShieldsOn.add(graphicFW.newSprite(UtilResource.textureAtlas,
                192,128, 64,64));

        UtilResource.spritePlayerShieldsOnBoost.add(graphicFW.newSprite(UtilResource.textureAtlas,
                0,192, 64,64));
        UtilResource.spritePlayerShieldsOnBoost.add(graphicFW.newSprite(UtilResource.textureAtlas,
                64,192, 64,64));
        UtilResource.spritePlayerShieldsOnBoost.add(graphicFW.newSprite(UtilResource.textureAtlas,
                128,192, 64,64));
        UtilResource.spritePlayerShieldsOnBoost.add(graphicFW.newSprite(UtilResource.textureAtlas,
                192,192, 64,64));
    }


    private void loadGifts(GraphicFW graphicFW) {
        UtilResource.spriteProtector = new ArrayList<>();
        UtilResource.spriteProtector.add(graphicFW.newSprite(UtilResource.textureAtlas,
                256,192, 32,32));
        UtilResource.spriteProtector.add(graphicFW.newSprite(UtilResource.textureAtlas,
                288,192, 32,32));
        UtilResource.spriteProtector.add(graphicFW.newSprite(UtilResource.textureAtlas,
                320,192, 32,32));
        UtilResource.spriteProtector.add(graphicFW.newSprite(UtilResource.textureAtlas,
                352,192, 32,32));
    }

    private void loadAudio(CoreFW coreFW) {
        UtilResource.gameMusic = coreFW.getAudioFW().newMusic("music.mp3");
        UtilResource.hit=coreFW.getAudioFW().newSound("hit.ogg");
        UtilResource.explode=coreFW.getAudioFW().newSound("explode.ogg");
        UtilResource.touch=coreFW.getAudioFW().newSound("touch.ogg");
    }


    private void loadSpriteEnemy(GraphicFW graphicFW) {
        UtilResource.spriteEnemy = new ArrayList<>();
        UtilResource.spriteEnemy.add(graphicFW.newSprite(UtilResource.textureAtlas,256,0,
                64,64));
        UtilResource.spriteEnemy.add(graphicFW.newSprite(UtilResource.textureAtlas,320,0,
                64,64));
        UtilResource.spriteEnemy.add(graphicFW.newSprite(UtilResource.textureAtlas,384,0,
                64,64));
        UtilResource.spriteEnemy.add(graphicFW.newSprite(UtilResource.textureAtlas,448,0,
                64,64));
    }


    private void loadOther(GraphicFW graphicsFW) {
        UtilResource.shieldHitEnemy = graphicsFW.newSprite(UtilResource.textureAtlas,
                0,128,64,64);

    }


    private void loadSpritePlayer(GraphicFW graphicFW) {
        UtilResource.spritePlayer=new ArrayList<>();
        UtilResource.spritePlayerBoost=new ArrayList<>();
        UtilResource.spriteExplosionPlayer =new ArrayList<>();

        UtilResource.spriteExplosionPlayer.add(graphicFW.newSprite(UtilResource.textureAtlas,
                256,256, 64,64));
        UtilResource.spriteExplosionPlayer.add(graphicFW.newSprite(UtilResource.textureAtlas,
                320,256, 64,64));
        UtilResource.spriteExplosionPlayer.add(graphicFW.newSprite(UtilResource.textureAtlas,
                384,256, 64,64));
        UtilResource.spriteExplosionPlayer.add(graphicFW.newSprite(UtilResource.textureAtlas,
                448,256, 64,64));


        UtilResource.spritePlayer.add(graphicFW.newSprite(UtilResource.textureAtlas,0,0,
                64,64));
        UtilResource.spritePlayer.add(graphicFW.newSprite(UtilResource.textureAtlas,64,0,
                64,64));
        UtilResource.spritePlayer.add(graphicFW.newSprite(UtilResource.textureAtlas,128,0,
                64,64));
        UtilResource.spritePlayer.add(graphicFW.newSprite(UtilResource.textureAtlas,192,0,
                64,64));

        UtilResource.spritePlayerBoost.add(graphicFW.newSprite(UtilResource.textureAtlas,0,64,
                64,64));
        UtilResource.spritePlayerBoost.add(graphicFW.newSprite(UtilResource.textureAtlas,64,64,
                64,64));
        UtilResource.spritePlayerBoost.add(graphicFW.newSprite(UtilResource.textureAtlas,128,64,
                64,64));
        UtilResource.spritePlayerBoost.add(graphicFW.newSprite(UtilResource.textureAtlas,192,64,
                64,64));

    }


    private void loadTexture(GraphicFW graphicFW) {
        UtilResource.textureAtlas = graphicFW.newTexture("texture_atlas.png");
    }
}

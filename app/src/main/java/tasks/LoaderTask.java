package tasks;

import android.os.AsyncTask;

import com.example.alex_framework.CoreFW;
import com.example.alex_framework.GraphicFW;
import com.example.spaceadventure.scenes.LoaderResourceScene;
import com.example.spaceadventure.utilits.UtilResource;

import java.util.ArrayList;

import interfaces.TaskCompleteListener;

public class LoaderTask extends AsyncTask <Void, Integer, Void > {
    private CoreFW mCoreFW;
    private TaskCompleteListener mTaskCompleteListener;
    public LoaderTask(CoreFW coreFW, TaskCompleteListener taskCompleteListener) {
        mCoreFW = coreFW;
        mTaskCompleteListener = taskCompleteListener;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        LoaderResourceScene.setProgressLoader(values[0]);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        loaderAssets();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mTaskCompleteListener.onComplete();
    }

    private void loaderAssets() {

        loadTexture(mCoreFW.getGraphicFW());
        publishProgress(100);
        loadSpritePlayer(mCoreFW.getGraphicFW());
        publishProgress(300);
        loadSpriteEnemy(mCoreFW.getGraphicFW());
        publishProgress(500);
        loadOther(mCoreFW.getGraphicFW());
        publishProgress(600);
        loadAudio(mCoreFW);
        // TODO: 29.02.2024 Удалить блок замедления вместе с циклом try catch!
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loadSpritePlayerShieldsOn(mCoreFW.getGraphicFW());
        publishProgress(700);
        loadGifts(mCoreFW.getGraphicFW());
        publishProgress(800);
    }
    private void loadSpritePlayerShieldsOn(GraphicFW graphicFW) {
        UtilResource.mSpritePlayerShieldsOn = new ArrayList<>();
        UtilResource.mSpritePlayerShieldsOnBoost =new ArrayList<>();

        UtilResource.mSpritePlayerShieldsOn.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                0,128, 64,64));
        UtilResource.mSpritePlayerShieldsOn.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                64,128, 64,64));
        UtilResource.mSpritePlayerShieldsOn.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                128,128, 64,64));
        UtilResource.mSpritePlayerShieldsOn.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                192,128, 64,64));

        UtilResource.mSpritePlayerShieldsOnBoost.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                0,192, 64,64));
        UtilResource.mSpritePlayerShieldsOnBoost.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                64,192, 64,64));
        UtilResource.mSpritePlayerShieldsOnBoost.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                128,192, 64,64));
        UtilResource.mSpritePlayerShieldsOnBoost.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                192,192, 64,64));
    }
    private void loadGifts(GraphicFW graphicFW) {
        // Метод загружает подарки.
        UtilResource.mSpriteProtector = new ArrayList<>();
        UtilResource.mSpriteProtector.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                256,192, 32,32));
        UtilResource.mSpriteProtector.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                288,192, 32,32));
        UtilResource.mSpriteProtector.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                320,192, 32,32));
        UtilResource.mSpriteProtector.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                352,192, 32,32));
    }
    private void loadAudio(CoreFW coreFW) {
        UtilResource.mGameMusic = coreFW.getAudioFW().newMusic("music.mp3");
        UtilResource.mHit =coreFW.getAudioFW().newSound("hit.ogg");
        UtilResource.mExplode =coreFW.getAudioFW().newSound("explode.ogg");
        UtilResource.mTouch =coreFW.getAudioFW().newSound("touch.ogg");
    }
    private void loadSpriteEnemy(GraphicFW graphicFW) {
        UtilResource.mSpriteEnemy = new ArrayList<>();
        UtilResource.mSpriteEnemy.add(graphicFW.newSprite(UtilResource.mTextureAtlas,256,0,
                64,64));
        UtilResource.mSpriteEnemy.add(graphicFW.newSprite(UtilResource.mTextureAtlas,320,0,
                64,64));
        UtilResource.mSpriteEnemy.add(graphicFW.newSprite(UtilResource.mTextureAtlas,384,0,
                64,64));
        UtilResource.mSpriteEnemy.add(graphicFW.newSprite(UtilResource.mTextureAtlas,448,0,
                64,64));
    }
    private void loadOther(GraphicFW graphicsFW) {
        UtilResource.mShieldHitEnemy = graphicsFW.newSprite(UtilResource.mTextureAtlas,
                0,128,64,64);
    }
    private void loadSpritePlayer(GraphicFW graphicFW) {
        UtilResource.mSpritePlayer =new ArrayList<>();
        UtilResource.mSpritePlayerBoost =new ArrayList<>();
        UtilResource.mSpriteExplosionPlayer =new ArrayList<>();

        UtilResource.mSpriteExplosionPlayer.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                256,256, 64,64));
        UtilResource.mSpriteExplosionPlayer.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                320,256, 64,64));
        UtilResource.mSpriteExplosionPlayer.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                384,256, 64,64));
        UtilResource.mSpriteExplosionPlayer.add(graphicFW.newSprite(UtilResource.mTextureAtlas,
                448,256, 64,64));

        UtilResource.mSpritePlayer.add(graphicFW.newSprite(UtilResource.mTextureAtlas,0,0,
                64,64));
        UtilResource.mSpritePlayer.add(graphicFW.newSprite(UtilResource.mTextureAtlas,64,0,
                64,64));
        UtilResource.mSpritePlayer.add(graphicFW.newSprite(UtilResource.mTextureAtlas,128,0,
                64,64));
        UtilResource.mSpritePlayer.add(graphicFW.newSprite(UtilResource.mTextureAtlas,192,0,
                64,64));

        UtilResource.mSpritePlayerBoost.add(graphicFW.newSprite(UtilResource.mTextureAtlas,0,64,
                64,64));
        UtilResource.mSpritePlayerBoost.add(graphicFW.newSprite(UtilResource.mTextureAtlas,64,64,
                64,64));
        UtilResource.mSpritePlayerBoost.add(graphicFW.newSprite(UtilResource.mTextureAtlas,128,64,
                64,64));
        UtilResource.mSpritePlayerBoost.add(graphicFW.newSprite(UtilResource.mTextureAtlas,192,64,
                64,64));
    }
    private void loadTexture(GraphicFW graphicFW) {
        UtilResource.mTextureAtlas = graphicFW.newTexture("texture_atlas.png");
    }
}

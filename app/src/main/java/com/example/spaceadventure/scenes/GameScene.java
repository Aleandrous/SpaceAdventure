package com.example.spaceadventure.scenes;

import android.graphics.Color;
import com.example.alex_framework.CoreFW;
import com.example.alex_framework.SceneFW;
import com.example.spaceadventure.R;
import com.example.spaceadventure.clases.GameManager;
import com.example.spaceadventure.utilits.SettingsGame;
import com.example.spaceadventure.utilits.UtilResource;

public class GameScene extends SceneFW {

    enum GameState{
        READY, RUNNING, PAUSE, GAME_OVER
    }
    private GameState mGameState;
    @SuppressWarnings("FieldMayBeFinal")
    private GameManager mGameManager;
    public GameScene(CoreFW coreFW) {
        super(coreFW);
        mGameState = GameState.READY;
        mGameManager = new GameManager(coreFW,sceneWidth, sceneHeight);
        UtilResource.mGameMusic.play(true, 1f);
    }
    @Override
    public void update() {
        if (mGameState ==GameState.READY){
            updateStateReady();
        }
        if (mGameState ==GameState.RUNNING){
            updateStateRunning();
        }
        if (mGameState ==GameState.PAUSE){
            updateStatePause();
        }
        if (mGameState ==GameState.GAME_OVER){
            updateStateGameOver();
        }
    }
    @Override
    public void drawing() {
        graphicFW.clearScene(Color.BLACK);
        if (mGameState ==GameState.READY){
            drawingStateReady();
        }
        if (mGameState ==GameState.RUNNING){
            drawingStateRunning();
        }
        if (mGameState ==GameState.PAUSE){
            drawingStatePause();
        }
        if (mGameState ==GameState.GAME_OVER){
            drawingStateGameOver();
        }
    }
    private void drawingStateGameOver() {
        graphicFW.clearScene(Color.BLACK);
        graphicFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_gameOver),
                250, 300, Color.WHITE, 60, null);
        graphicFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_restart),
                250, 360, Color.WHITE, 30, null);
        graphicFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_exit),
                250, 420, Color.WHITE, 30, null);
        graphicFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_distance) + ":" + mGameManager.getPassedDistance(),
                250, 200, Color.WHITE, 30, null);
    }
    private void updateStateGameOver() {
        SettingsGame.addDistance(mGameManager.getPassedDistance());
        if (coreFW.getTouchListenerFW().getTouchUp(250, 360, 100, 35)){
            coreFW.setScene(new GameScene(coreFW));
        }
        if (coreFW.getTouchListenerFW().getTouchUp(250, 420, 100, 35)){
            coreFW.setScene(new MainMenuScene(coreFW));
        }
    }
    private void drawingStatePause() {
    }
    private void updateStatePause() {
    }
    private void drawingStateRunning() {
        graphicFW.clearScene(Color.BLACK);
        mGameManager.drawing(graphicFW);
    }
    private void updateStateRunning() {
        mGameManager.update();
        if (GameManager.gameOver){
            mGameState = GameState.GAME_OVER;
        }
    }
    private void drawingStateReady() {
        graphicFW.clearScene(Color.BLACK);
        graphicFW.drawText(coreFW.getString(R.string.txt_gameScene_stateReady_ready), 250, 300, Color.WHITE, 60 , null);
    }
    private void updateStateReady() {
        if (coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)){
            mGameState = GameState.RUNNING;
        }
    }
    @Override
    public void pause() {
        UtilResource.mGameMusic.stop();
    }
    @Override
    public void resume() {
        UtilResource.mGameMusic.play(true, 1f);
    }
    @Override
    public void dispose() {
        UtilResource.mExplode.dispose();
        UtilResource.mHit.dispose();
        UtilResource.mTouch.dispose();
        UtilResource.mGameMusic.dispose();
    }
}

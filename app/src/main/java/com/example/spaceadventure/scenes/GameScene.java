package com.example.spaceadventure.scenes;

import android.graphics.Color;

import com.example.alex_framework.CoreFW;
import com.example.alex_framework.SceneFW;
import com.example.spaceadventure.R;
import com.example.spaceadventure.generator.GeneratorBackground;

public class GameScene extends SceneFW {

    enum GameState{
        READY, RUNNING, PAUSE, GAMEOVER
    }
    GameState gameState;
    GeneratorBackground generatorBackground;
    public GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState = GameState.READY;
        generatorBackground = new GeneratorBackground(sceneWidth, sceneHeight);
    }

    @Override
    public void update() {
        if (gameState==GameState.READY){
            updateStateReady();
        }
        if (gameState==GameState.RUNNING){
            updateStateRunning();
        }
        if (gameState==GameState.PAUSE){
            updateStatePause();
        }
        if (gameState==GameState.GAMEOVER){
            updateStateGameOver();
        }

    }
    @Override
    public void drawing() {
        graphicFW.clearScene(Color.BLACK);

        if (gameState==GameState.READY){
            drawingStateReady();
        }
        if (gameState==GameState.RUNNING){
            drawingStateRunning();
        }
        if (gameState==GameState.PAUSE){
            drawingStatePause();
        }
        if (gameState==GameState.GAMEOVER){
            drawingStateGameOver();
        }
    }

    private void drawingStateGameOver() {

    }
    private void updateStateGameOver() {

    }

    private void drawingStatePause() {

    }
    private void updateStatePause() {

    }

    private void drawingStateRunning() {
        graphicFW.clearScene(Color.BLACK);
        graphicFW.drawText("Game Scene", 250, 300, Color.WHITE, 60, null);
        generatorBackground.drawing(graphicFW);
    }
    private void updateStateRunning() {
        generatorBackground.update();

    }

    private void drawingStateReady() {
        graphicFW.clearScene(Color.BLACK);
        graphicFW.drawText(coreFW.getString(R.string.txt_gameScene_stateReady_ready), 250, 300, Color.WHITE, 60 , null);
    }
    private void updateStateReady() {
        if (coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)){
            gameState = GameState.RUNNING;
        }

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
}

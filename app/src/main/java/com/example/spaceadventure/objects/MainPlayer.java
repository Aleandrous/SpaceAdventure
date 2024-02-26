package com.example.spaceadventure.objects;

import android.graphics.Rect;

import com.example.alex_framework.CoreFW;
import com.example.alex_framework.GraphicFW;
import com.example.alex_framework.ObjectFW;
import com.example.alex_framework.AnimationFW;
import com.example.alex_framework.utilits.UtilTimerDelay;
import com.example.spaceadventure.clases.GameManager;
import com.example.spaceadventure.utilits.UtilResource;
public class MainPlayer extends ObjectFW {
    final int GRAVITY = -3;
    final int MAX_SPEED = 15;
    final int MIN_SPEED = 1;
    AnimationFW animMainPlayer;
    AnimationFW animMainPlayerBoost;
    AnimationFW animExplosionPlayer;
    AnimationFW animPlayerShieldsOn;
    AnimationFW animPlayerShieldsOnBoost;
    CoreFW coreFW;
    UtilTimerDelay timerOnShieldHit;
    UtilTimerDelay timerOnGameOver;
    UtilTimerDelay timerShieldsOn;

    boolean boosting;
    private int shieldsPlayer;
    boolean hitEnemy;
    boolean isGameOver;
    static boolean shieldsOn;

    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    public MainPlayer(CoreFW coreFW, int maxScreenX, int maxScreenY, int minScreenY) {
        shieldsOn = false;
        x = 20;
        y = 200;
        speed = GameManager.SPEED_ANIMATION;
        shieldsPlayer = 3;
        boosting = false;
        hitEnemy = false;
        isGameOver = false;


        radius = UtilResource.mSpritePlayer.get(0).getWidth() / 4;

        timerOnShieldHit = new UtilTimerDelay();
        timerOnGameOver = new UtilTimerDelay();
        timerShieldsOn = new UtilTimerDelay();

        this.coreFW = coreFW;
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.mSpritePlayer.get(0).getHeight();
        this.minScreenY = minScreenY;
        initAnimation();
    }

    private void initAnimation() {
        animMainPlayer = new AnimationFW(speed, UtilResource.mSpritePlayer.get(0),
                UtilResource.mSpritePlayer.get(1),
                UtilResource.mSpritePlayer.get(2),
                UtilResource.mSpritePlayer.get(3));
        animMainPlayerBoost = new AnimationFW(speed, UtilResource.mSpritePlayerBoost.get(0),
                UtilResource.mSpritePlayerBoost.get(1),
                UtilResource.mSpritePlayerBoost.get(2),
                UtilResource.mSpritePlayerBoost.get(3));
        animExplosionPlayer = new AnimationFW(speed,
                UtilResource.mSpriteExplosionPlayer.get(0),
                UtilResource.mSpriteExplosionPlayer.get(1),
                UtilResource.mSpriteExplosionPlayer.get(2),
                UtilResource.mSpriteExplosionPlayer.get(3));
        animPlayerShieldsOn = new AnimationFW(speed,
                UtilResource.mSpritePlayerShieldsOn.get(0),
                UtilResource.mSpritePlayerShieldsOn.get(1),
                UtilResource.mSpritePlayerShieldsOn.get(2),
                UtilResource.mSpritePlayerShieldsOn.get(3));
        animPlayerShieldsOnBoost = new AnimationFW(speed,
                UtilResource.mSpritePlayerShieldsOnBoost.get(0),
                UtilResource.mSpritePlayerShieldsOnBoost.get(1),
                UtilResource.mSpritePlayerShieldsOnBoost.get(2),
                UtilResource.mSpritePlayerShieldsOnBoost.get(3));
    }

    public void update() {
        if (coreFW.getTouchListenerFW().getTouchDown(0, maxScreenY, maxScreenX, maxScreenY)) {
            startBoosting();
        }
        if (coreFW.getTouchListenerFW().getTouchUp(0, maxScreenY, maxScreenX, maxScreenY)) {
            stopBoosting();
        }
        if (timerShieldsOn.timerDelay(5)){
            shieldsOn=false;
        }
        updateBoosting();
        hitBox = new Rect(x, y,
                UtilResource.mSpritePlayer.get(0).getWidth(),
                UtilResource.mSpritePlayer.get(0).getHeight());
        if (isGameOver) {
            animExplosionPlayer.runAnimation();
        }
    }
    private void updateBoosting() {
        if (boosting) {
            speed += 0.1;
        } else speed -= 3;
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }
        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }
        y -= speed + GRAVITY;
        if (y < minScreenY) {
            y = minScreenY;
        }
        if (y > maxScreenY) {
            y = maxScreenY;
        }
        if (boosting) {
            if (shieldsOn) {
                animPlayerShieldsOnBoost.runAnimation();
            } else animMainPlayerBoost.runAnimation();
        } else if (shieldsOn) {
            animPlayerShieldsOn.runAnimation();
        } else animMainPlayer.runAnimation();
    }
    private void stopBoosting() {
        boosting = false;
    }
    private void startBoosting() {
        boosting = true;
    }
    public void drawing(GraphicFW graphicsFW) {
        if (!isGameOver) {
            if (!hitEnemy) {
                if (boosting) {
                    if (shieldsOn) {
                        animPlayerShieldsOnBoost.drawingAnimation(graphicsFW, x, y);
                    } else animMainPlayerBoost.drawingAnimation(graphicsFW, x, y);
                } else if (shieldsOn) {
                    animPlayerShieldsOn.drawingAnimation(graphicsFW, x, y);
                } else animMainPlayer.drawingAnimation(graphicsFW, x, y);
            } else {
                graphicsFW.drawTexture(UtilResource.mShieldHitEnemy, x, y);
                hitEnemy = !timerOnShieldHit.timerDelay(0.2);
            }
        } else {
            animExplosionPlayer.drawingAnimation(graphicsFW, x, y);
            if (timerOnGameOver.timerDelay(0.5)) {
                GameManager.gameOver = true;
            }
        }
    }
    public double getSpeedPlayer() {
        return speed;
    }

    public int getShieldsPlayer() {
        return shieldsPlayer;
    }

    public void hitEnemy() {
        if (!shieldsOn){
            shieldsPlayer--;
            if (shieldsPlayer < 0) {
                UtilResource.mExplode.play(1);
                isGameOver = true;
                timerOnGameOver.startTimer();
            }
            hitEnemy = true;
            timerOnShieldHit.startTimer();
        }
    }
    public static boolean isShieldsOn() {
        return shieldsOn;
    }
    public void hitProtector(){
        shieldsOn=true;
        timerShieldsOn.startTimer();
    }
}

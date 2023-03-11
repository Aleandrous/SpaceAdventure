package com.example.alex_framework;

public abstract class SceneFW {
    public CoreFW coreFW;
    public int sceneWidth;
    public int sceneHeight;
    public GraphicFW graphicFW;

    public SceneFW(CoreFW coreFW) {
        this.coreFW = coreFW;
        sceneWidth = coreFW.getGraphicFW().getWithFrameBuffer();
        sceneHeight = coreFW.getGraphicFW().getHeightFrameBuffer();
        graphicFW = coreFW.getGraphicFW();
    }
    public abstract void update();
    public abstract void drawing();
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();


}

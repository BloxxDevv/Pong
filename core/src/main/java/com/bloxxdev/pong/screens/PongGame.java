package com.bloxxdev.pong.screens;

import com.badlogic.gdx.ScreenAdapter;

public class PongGame extends ScreenAdapter{
    
    //Flag whether the game should render or not
    public boolean shouldRender = false;

    //Flag whether the game should tick or not
    public boolean shouldTick = false;

    @Override
    public void show() {
        //Set flags
        shouldTick = true;
        shouldRender = true;
    }

    public void tick(){
        if (shouldTick) {
            
        }
    }

    @Override
    public void render(float delta) {
        if (shouldRender) {
            
        }
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        //Remove flags
        shouldTick = false;
        shouldRender = false;
    }
}

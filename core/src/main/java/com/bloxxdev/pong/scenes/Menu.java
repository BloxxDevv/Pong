package com.bloxxdev.pong.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;

public class Menu extends ScreenAdapter{

    private static final float[] BG_COLOR = new float[]{89/255.0F, 4/255.0F, 114/255.0F};

    //Flag whether the menu should render or not
    private boolean shouldRender = false;

    @Override
    public void show() {
        shouldRender = true;
        //Change the background color
        Gdx.gl.glClearColor(BG_COLOR[0], BG_COLOR[1], BG_COLOR[2], 1);
    }

    @Override
    public void render(float delta) {
        if (shouldRender) {
            
        }
    }

    @Override
    public void dispose() {
        shouldRender = false;
        super.dispose();
    }
}

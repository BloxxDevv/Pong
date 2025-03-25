package com.bloxxdev.pong.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu extends ScreenAdapter{

    private static final float[] BG_COLOR = new float[]{89/255.0F, 4/255.0F, 114/255.0F};

    //Flag whether the menu should render or not
    private boolean shouldRender = false;

    SpriteBatch batch;
    Texture pongLogo;

    @Override
    public void show() {
        shouldRender = true;
        //Change the background color
        Gdx.gl.glClearColor(BG_COLOR[0], BG_COLOR[1], BG_COLOR[2], 1);

        pongLogo = new Texture(Gdx.files.internal("Pong Logo.png"));
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        if (shouldRender) {
            batch.begin();
            
            //Rendering the logo
            batch.draw(pongLogo, 0, 0, pongLogo.getWidth()*10, pongLogo.getHeight()*10);
            
            batch.end();
        }
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        shouldRender = false;
        batch.dispose();
        pongLogo.dispose();
    }
}

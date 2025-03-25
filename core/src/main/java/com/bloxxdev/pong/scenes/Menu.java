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

    private static final int LOGO_SCALING = 10;

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
        //Render loop only renders if the render flag is true (aka if the menu is open)
        if (shouldRender) {
            //Scaling the Logo Size by the Scaling factor
            int logoWidth = pongLogo.getWidth()*LOGO_SCALING;
            int logoHeight = pongLogo.getHeight()*LOGO_SCALING;

            //XPos of the logo in the middle of the screen
            int xLogoPos = Gdx.graphics.getWidth()/2 - logoWidth/2;

            //YPos of the logo: 50 px below the top of the screen
            int yLogoPos = Gdx.graphics.getHeight() - logoHeight - 50;

            batch.begin();
            
            //Rendering the logo
            batch.draw(pongLogo, xLogoPos, yLogoPos, logoWidth, logoHeight);

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

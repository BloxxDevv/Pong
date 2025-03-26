package com.bloxxdev.pong.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bloxxdev.pong.Main;

public class Menu extends ScreenAdapter{

    private static final float[] BG_COLOR = new float[]{89/255.0F, 4/255.0F, 114/255.0F};

    //Flag whether the menu should render or not
    public boolean shouldRender = false;
    
    //Flag whether the game should tick or not
    public boolean shouldTick = false;

    private SpriteBatch batch;
    private Texture pongLogo;

    //Button Textures
    Texture[] startButtonTextures = new Texture[]{
        new Texture(Gdx.files.internal("Start Button Normal.png")),
        new Texture(Gdx.files.internal("Start Button Hover.png"))
    };

    Texture[] quitButtonTextures = new Texture[]{
        new Texture(Gdx.files.internal("Quit Button Normal.png")),
        new Texture(Gdx.files.internal("Quit Button Hover.png"))
    };

    //Scaling
    private static final int LOGO_SCALING = 10;
    private static final int BUTTON_SCALING = 7;

    //Button states for images
    private int startButtonState = 0;
    private int quitButtonState = 0;

    //Sizes
    private int logoWidth;
    private int logoHeight;
    private int startButtonWidth;
    private int startButtonHeight;
    private int quitButtonWidth;
    private int quitButtonHeight;

    //Positions
    private int xLogoPos;
    private int yLogoPos;
    private int xStartPos;
    private int yStartPos;
    private int xQuitPos;
    private int yQuitPos;

    @Override
    public void show() {
        //Set the loop flags
        shouldTick = true;
        shouldRender = true;
        
        //Change the background color
        Gdx.gl.glClearColor(BG_COLOR[0], BG_COLOR[1], BG_COLOR[2], 1);

        pongLogo = new Texture(Gdx.files.internal("Pong Logo.png"));
        batch = new SpriteBatch();

        //Scaling the Logo Size by the Scaling factor
        logoWidth = pongLogo.getWidth()*LOGO_SCALING;
        logoHeight = pongLogo.getHeight()*LOGO_SCALING;
        
        //Start Button Size
        startButtonWidth = startButtonTextures[startButtonState].getWidth()*BUTTON_SCALING;
        startButtonHeight = startButtonTextures[startButtonState].getHeight()*BUTTON_SCALING;

        //Quit Button Size
        quitButtonWidth = quitButtonTextures[quitButtonState].getWidth()*BUTTON_SCALING;
        quitButtonHeight = quitButtonTextures[quitButtonState].getHeight()*BUTTON_SCALING;

        //XPos of the logo in the middle of the screen
        xLogoPos = Gdx.graphics.getWidth()/2 - logoWidth/2;

        //YPos of the logo: 50 px below the top of the screen
        yLogoPos = Gdx.graphics.getHeight() - logoHeight - 50;

        //XPos of the start button in the middle of the screen
        xStartPos = Gdx.graphics.getWidth()/2 - startButtonWidth/2;

        //YPos of the start button: 150 px below the top of the screen
        yStartPos = Gdx.graphics.getHeight() - startButtonHeight - 150;

        //XPos of the quit button in the middle of the screen
        xQuitPos = Gdx.graphics.getWidth()/2 - quitButtonWidth/2;

        //YPos of the quit button: 250 px below the top of the screen
        yQuitPos = Gdx.graphics.getHeight() - quitButtonHeight - 250;
    }

    public void tick(){
        if (shouldTick) {
            if (mouseEntered(xStartPos, yStartPos, startButtonWidth, startButtonHeight)){
                startButtonState = 1;
                
                //Start Game
                if (Gdx.input.isTouched()) {
                     hide();
                }
            }else{
                startButtonState = 0;
            }
            if (mouseEntered(xQuitPos, yQuitPos, quitButtonWidth, quitButtonHeight)){
                quitButtonState = 1;
                
                //If the Quit button is pressed, clear ressources then close the game
                if (Gdx.input.isTouched()) {
                    Main.instance.dispose();
                }
            }else{
                quitButtonState = 0;
            }
        }
    }

    @Override
    public void render(float delta) {
        //Render loop only renders if the render flag is true (aka if the menu is open)
        if (shouldRender) {
            batch.begin();
            
            //Rendering the logo
            batch.draw(pongLogo, xLogoPos, yLogoPos, logoWidth, logoHeight);

            //Rendering Buttons
            batch.draw(startButtonTextures[startButtonState], xStartPos, yStartPos, startButtonWidth, startButtonHeight);
            batch.draw(quitButtonTextures[quitButtonState], xQuitPos, yQuitPos, quitButtonWidth, quitButtonHeight);

            batch.end();
        }
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        //Remove tick flags
        shouldTick = false;
        shouldRender = false;
        
        //Dispose to save memory
        pongLogo.dispose();
        for (int i = 0; i < startButtonTextures.length; i++) {
            startButtonTextures[i].dispose();
        }
        for (int i = 0; i < quitButtonTextures.length; i++) {
            quitButtonTextures[i].dispose();
        }
    }

    /*
     * getGL coord is a method to convert one part of a coordinate (X or Y) from mouse coords to OpenGL coords
     * @param mouseCoord - either the X or Y coord of the mouse
     * @param screenSize - if mouseX is selected, window width, otherwise window height
     * 
     */
    private int getGLCoord (int mouseCoord, int windowSize){
        return windowSize-mouseCoord;
    }

    private boolean mouseEntered(int areaX, int areaY, int areaWidth, int areaHeight){
        //Nesting for readability
        if (getGLCoord(Gdx.input.getX(), Gdx.graphics.getWidth()) >= areaX && getGLCoord(Gdx.input.getX(), Gdx.graphics.getWidth()) <= areaX+areaWidth) {
            if (getGLCoord(Gdx.input.getY(), Gdx.graphics.getHeight()) >= areaY && getGLCoord(Gdx.input.getY(), Gdx.graphics.getHeight()) <= areaY+areaHeight) {
                return true;
            }
        }

        return false;
    }
}

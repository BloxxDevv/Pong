package com.bloxxdev.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.bloxxdev.pong.screens.Menu;
import com.bloxxdev.pong.screens.PongGame;

/*  */
public class Main extends ApplicationAdapter {

    public static Main instance;

    Screen menuScreen;
    public Screen pongGameScreen;

    /*
     * Create
     * creates the Application. The init method
     */
    @Override
    public void create() {
        instance = this;

        //On init Warp the player in the Main Menu
        menuScreen = new Menu();
        menuScreen.show();

        //Create the pongGameScreen
        pongGameScreen = new PongGame();
    }

    public void update(){
        //Tick All screens
        ((Menu)menuScreen).tick();
        ((PongGame)pongGameScreen).tick();
    }

    /*
     * Render loop
     */
    @Override
    public void render() {
        update();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Render shown screens
        menuScreen.render(0);
        pongGameScreen.render(0);
    }

    /*
     * Dispose once the Application shuts down
     */
    @Override
    public void dispose() {
        //Dispose everything and close game
        menuScreen.dispose();
        pongGameScreen.dispose();
        System.exit(0);
    }
}

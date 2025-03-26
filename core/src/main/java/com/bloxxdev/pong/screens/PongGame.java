package com.bloxxdev.pong.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.bloxxdev.pong.gameObjects.Paddle;

public class PongGame extends ScreenAdapter{
    //Flag whether the game should render or not
    public boolean shouldRender = false;

    //Flag whether the game should tick or not
    public boolean shouldTick = false;

    //Paddles (the players)
    private Paddle leftPaddle;
    private Paddle rightPaddle;

    @Override
    public void show() {
        //Set flags
        shouldTick = true;
        shouldRender = true;

        //Black background
        Gdx.gl.glClearColor(0, 0, 0, 0);

        //Paddles
        leftPaddle = new Paddle(0, Gdx.graphics.getHeight()/2-Paddle.PADDLE_HEIGHT/2);
        rightPaddle = new Paddle(Gdx.graphics.getWidth()-Paddle.PADDLE_WIDTH, Gdx.graphics.getHeight()/2-Paddle.PADDLE_HEIGHT/2);
    }

    public void tick(){
        if (shouldTick) {
            //Check for any inputs
            checkKeys();

            //Move players
            leftPaddle.tick();
            rightPaddle.tick();
        }
    }

    @Override
    public void render(float delta) {
        if (shouldRender) {
            //Render players
            leftPaddle.render();
            rightPaddle.render();
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

        leftPaddle.dispose();
        rightPaddle.dispose();
    }

    private void checkKeys(){
        //Left Paddle Controls
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            leftPaddle.direction[Paddle.UP] = true;
        }else{
            leftPaddle.direction[Paddle.UP] = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            leftPaddle.direction[Paddle.DOWN] = true;
        }else{
            leftPaddle.direction[Paddle.DOWN] = false;
        }

        //Right Paddle Controls
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_7)) {
            rightPaddle.direction[Paddle.UP] = true;
        }else{
            rightPaddle.direction[Paddle.UP] = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_4)) {
            rightPaddle.direction[Paddle.DOWN] = true;
        }else{
            rightPaddle.direction[Paddle.DOWN] = false;
        }
    }
}

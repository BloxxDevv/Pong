package com.bloxxdev.pong.gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.bloxxdev.pong.Main;
import com.bloxxdev.pong.screens.PongGame;

//Class Of the bouncy ball
public class Ball {
    //Direction mappings of the Ball
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    
    public static final int SPEED = 5;

    public static final int BALL_SIZE = 10;

    //Paddle Position
    private int x;
    private int y;

    ShapeRenderer renderer;

    Sound plop = Gdx.audio.newSound(Gdx.files.internal("Plop.mp3"));

    public boolean[] direction = new boolean[]{
        false, false,false, false       //UP, DOWN, LEFT, RIGHT 
    };

    private void move(){
        if (direction[UP]) {
            //If the ball would go outside of the screen on top
            if (Gdx.graphics.getHeight() - (y+BALL_SIZE) < SPEED) {
                //Top Bounce
                int dist = Gdx.graphics.getHeight() - (y+BALL_SIZE);    //Distance ball to top

                //Apply momentum buffer formula
                y+= dist - (SPEED - dist);

                playPlopSound();

                //Flip direction
                direction[UP] = false;
                direction[DOWN] = true;
            }else{
                y+=SPEED;
            }
        }else if (direction[DOWN]) {
            //If the ball would go outside of the screen on bottom
            if (y < SPEED) {
                //Top Bounce
                int dist = y;    //Distance ball to top

                //Apply momentum buffer formula
                y-= dist - (SPEED - dist);

                playPlopSound();

                //Flip direction
                direction[DOWN] = false;
                direction[UP] = true;
            }else{
                y-=SPEED;
            }
        }

        if (direction[LEFT]) {
            if (x - Paddle.PADDLE_WIDTH < SPEED) {
                if (y + BALL_SIZE > PongGame.leftPaddle.getY() && y < PongGame.leftPaddle.getY()+Paddle.PADDLE_HEIGHT) {
                    int dist = x - Paddle.PADDLE_WIDTH;    //Distance ball to side

                    x-= dist - (SPEED - dist);

                    playPlopSound();

                    direction[LEFT] = false;
                    direction[RIGHT] = true;
                }else{
                    PongGame.paused = true;
                    ((PongGame)Main.instance.pongGameScreen).side = PongGame.RIGHT_SIDE;
                    PongGame.rightScore++;
                    ((PongGame)Main.instance.pongGameScreen).reset();
                    reset();
                }
            }else{
                x-=SPEED;
            }
        }else if (direction[RIGHT]) {
            if (x+BALL_SIZE+SPEED > Gdx.graphics.getWidth() - Paddle.PADDLE_WIDTH) {
                if (y + BALL_SIZE > PongGame.rightPaddle.getY() && y < PongGame.rightPaddle.getY()+Paddle.PADDLE_HEIGHT) {
                    int dist = Gdx.graphics.getWidth() - Paddle.PADDLE_WIDTH - (x+BALL_SIZE);    //Distance ball to side

                    x+= dist - (SPEED - dist);

                    playPlopSound();

                    direction[RIGHT] = false;
                    direction[LEFT] = true;
                }else{
                    PongGame.paused = true;
                    ((PongGame)Main.instance.pongGameScreen).side = PongGame.LEFT_SIDE;
                    PongGame.leftScore++;
                    ((PongGame)Main.instance.pongGameScreen).reset();
                    reset();
                }
            }else{
                x+=SPEED;
            }
        }
    }

    //Ball constructor (x,y = position)
    public Ball(int x, int y){
        this.x = x;
        this.y = y;

        renderer = new ShapeRenderer();

        plop.play(0.0F);
    }

    //Ball calculations/movement
    public void tick(){
        if (!PongGame.paused) {
            move();
        }
    }

    //Ball rendering (just a square)
    public void render(){
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.WHITE);
        renderer.rect(x, y, BALL_SIZE, BALL_SIZE);
        renderer.end();
    }

    //Free memory
    public void dispose(){
        renderer.dispose();
    }

    private void reset(){
        for (int i = 0; i < direction.length; i++) {
            direction[i] = false;
        }

        int side = ((PongGame)Main.instance.pongGameScreen).side;

        if (side == PongGame.LEFT_SIDE) {
            x = Paddle.PADDLE_WIDTH;
        }else{
            x = Gdx.graphics.getWidth()-Paddle.PADDLE_WIDTH-BALL_SIZE;
        }

        y = Gdx.graphics.getHeight()/2-Ball.BALL_SIZE/2;
    }

    private void playPlopSound(){
        plop.play(100.0F);
    }
}

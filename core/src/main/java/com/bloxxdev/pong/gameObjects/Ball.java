package com.bloxxdev.pong.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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

    public boolean[] direction = new boolean[]{
        false, false,false, false       //UP, DOWN, LEFT, RIGHT 
    };

    private void move(){
        if (direction[UP]) {
            y+=SPEED;
        }
        if (direction[DOWN]) {
            y-=SPEED;
        }
        if (direction[LEFT]) {
            x-=SPEED;
        }
        if (direction[RIGHT]) {
            x+=SPEED;
        }
    }

    //Ball constructor (x,y = position)
    public Ball(int x, int y){
        this.x = x;
        this.y = y;

        renderer = new ShapeRenderer();
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
}

package com.bloxxdev.pong.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

//Class Of the bouncy ball
public class Ball {

    public static final int BALL_SIZE = 10;

    //Paddle Position
    private int x;
    private int y;

    ShapeRenderer renderer;

    //Ball constructor (x,y = position)
    public Ball(int x, int y){
        this.x = x;
        this.y = y;

        renderer = new ShapeRenderer();
    }

    //Ball calculations/movement
    public void tick(){
        
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

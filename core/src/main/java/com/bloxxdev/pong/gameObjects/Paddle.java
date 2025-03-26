package com.bloxxdev.pong.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

//Paddle Object (represents player)
public class Paddle {
    //Direction mappings of the Paddles
    public static final int UP = 0;
    public static final int DOWN = 1;

    public static final int SPEED = 5;
    
    //Paddle Size
    public static final int PADDLE_WIDTH = 10;
    public static final int PADDLE_HEIGHT = 100;

    //Paddle Position
    private int x;
    private int y;

    public boolean[] direction = new boolean[]{
        false, false,       //UP       , DOWN 
    };

    ShapeRenderer renderer;

    private void move(int direction){
        y += SPEED*direction;
    }

    public Paddle(int x, int y){
        this.x = x;
        this.y = y;

        renderer = new ShapeRenderer();
    }

    public void tick(){
        if (direction[UP] != direction[DOWN]) {
            if (direction[UP]) {
                move(1);
            }
            if (direction[DOWN]) {
                move(-1);
            }
        }
    }

    public void render(){
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.WHITE);
        renderer.rect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        renderer.end();
    }

    public void dispose(){
        renderer.dispose();
    }

}

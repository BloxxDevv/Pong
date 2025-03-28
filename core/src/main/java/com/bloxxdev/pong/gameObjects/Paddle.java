package com.bloxxdev.pong.gameObjects;

import com.badlogic.gdx.Gdx;
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

    //Directions of movement true = moves in that direction. UP == DOWN means no movement
    public boolean[] direction = new boolean[]{
        false, false,       //UP       , DOWN 
    };

    ShapeRenderer renderer;

    //Move if the paddle stays in the boundries
    private void move(int direction){
        if (y + SPEED*direction < 0) {
            y = 0;
        }else if (y + SPEED*direction > Gdx.graphics.getHeight() - PADDLE_HEIGHT){
            y = Gdx.graphics.getHeight() - PADDLE_HEIGHT;
        }else{
            y += SPEED*direction;
        }
    }

    //Paddle constructor x,y = startpos
    public Paddle(int x, int y){
        this.x = x;
        this.y = y;

        renderer = new ShapeRenderer();
    }

    //Tick to handle calculations
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

    //Rendering (just a rectangle)
    public void render(){
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.WHITE);
        renderer.rect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        renderer.end();
    }

    //free memory
    public void dispose(){
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void reset(){
        y = Gdx.graphics.getHeight()/2-Paddle.PADDLE_HEIGHT/2;
    }
}

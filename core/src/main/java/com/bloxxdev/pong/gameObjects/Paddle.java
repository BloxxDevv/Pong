package com.bloxxdev.pong.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Paddle {
    
    public static final int PADDLE_WIDTH = 10;
    public static final int PADDLE_HEIGHT = 100;

    private int x;
    private int y;

    ShapeRenderer renderer;

    public Paddle(int x, int y){
        this.x = x;
        this.y = y;

        renderer = new ShapeRenderer();
    }

    public void tick(){

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

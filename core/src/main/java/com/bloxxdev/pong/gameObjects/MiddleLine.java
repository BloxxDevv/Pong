package com.bloxxdev.pong.gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MiddleLine {

    ShapeRenderer renderer;

    public MiddleLine(){
        renderer = new ShapeRenderer();
    }

    public void render(){
        int y = 0;
        while (y < Gdx.graphics.getHeight()) {
            y += 10;
            
            renderer.begin(ShapeType.Filled);
            renderer.setColor(Color.WHITE);
            renderer.rect(Gdx.graphics.getWidth()/2 - 5, y, 10, 10);
            renderer.end();

            y += 10;
        }
    }
}

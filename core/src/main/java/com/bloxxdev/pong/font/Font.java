package com.bloxxdev.pong.font;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Font {
    public static final int FONT_WIDTH = 6;
    public static final int FONT_HEIGHT = 8;

    public static final int SPACING = 2;

    private SpriteBatch spriteBatch;

    public static TextureRegion[] scoreFont = new TextureRegion[]{
        new TextureRegion(new Texture("ScoreFont.png"), FONT_WIDTH*4, FONT_HEIGHT, FONT_WIDTH, FONT_HEIGHT), //0
        new TextureRegion(new Texture("ScoreFont.png"), 0, 0, FONT_WIDTH, FONT_HEIGHT), //1
        new TextureRegion(new Texture("ScoreFont.png"), FONT_WIDTH, 0, FONT_WIDTH, FONT_HEIGHT), //2
        new TextureRegion(new Texture("ScoreFont.png"), FONT_WIDTH*2, 0, FONT_WIDTH, FONT_HEIGHT), //3
        new TextureRegion(new Texture("ScoreFont.png"), FONT_WIDTH*3, 0, FONT_WIDTH, FONT_HEIGHT), //4
        new TextureRegion(new Texture("ScoreFont.png"), FONT_WIDTH*4, 0, FONT_WIDTH, FONT_HEIGHT), //5
        new TextureRegion(new Texture("ScoreFont.png"), 0, FONT_HEIGHT, FONT_WIDTH, FONT_HEIGHT), //6
        new TextureRegion(new Texture("ScoreFont.png"), FONT_WIDTH, FONT_HEIGHT, FONT_WIDTH, FONT_HEIGHT), //7
        new TextureRegion(new Texture("ScoreFont.png"), FONT_WIDTH*2, FONT_HEIGHT, FONT_WIDTH, FONT_HEIGHT), //8
        new TextureRegion(new Texture("ScoreFont.png"), FONT_WIDTH*3, FONT_HEIGHT, FONT_WIDTH, FONT_HEIGHT), //9
    };

    public Font(){
        spriteBatch = new SpriteBatch();
    }

    public void drawScore(int score, int x, int y, int scaling){
        spriteBatch.begin();
        spriteBatch.draw(scoreFont[score], x, y, FONT_WIDTH*scaling, FONT_HEIGHT*scaling);
        spriteBatch.end();
    }
}

package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public interface StageInterface {
    void startGame();
    void returnToStart();
    Texture getTexture(Textures texture);
}

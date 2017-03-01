package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ObjectMap;

public class MyGdxGame extends ApplicationAdapter implements StageInterface {
	StartStage startStage;
	GameStage gameStage;

	ObjectMap<Textures, Texture> textureMap;
	
	@Override
	public void create () {
		textureMap = Textures.loadAllTextures();
		startStage = new StartStage(this);
		Gdx.input.setInputProcessor(startStage);
		gameStage = new GameStage(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		startStage.draw();
		gameStage.draw();
	}
	
	@Override
	public void dispose () {
        startStage.dispose();
		gameStage.dispose();
		for (Texture t : textureMap.values()) {
		    t.dispose();
        }
	}

    @Override
    public void startGame() {
        gameStage.setVisible(true);
        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void returnToStart() {
        startStage.setVisible(true);
        Gdx.input.setInputProcessor(startStage);
    }

    @Override
    public Texture getTexture(Textures texture) {
        return textureMap.get(texture);
    }
}

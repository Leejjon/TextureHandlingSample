package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class GameStage extends Stage {
    private boolean visible = false;

    public GameStage(final StageInterface stageInterface) {
        Table table = new Table();
        table.setFillParent(true);
        table.center();

        Image image = new Image(stageInterface.getTexture(Textures.CARNAVAL));

        table.add(image);

        addActor(table);
    }

    @Override
    public void draw() {
        act(Gdx.graphics.getDeltaTime());
        if (visible) {
            super.draw();
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

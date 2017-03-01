package com.mygdx.game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ObjectMap;

public enum Textures {
    BADLOGIC("badlogic.jpg"),
    BLACKPIXEL() {
        // We override the default "load by file name" get() method and return the generated Texture instead.
        @Override
        public Texture get() {
            Pixmap blackPixelPixmap = new Pixmap(1, 1, Pixmap.Format.RGB888);
            blackPixelPixmap.setColor(0f,0f,0f, 1f);
            blackPixelPixmap.fill();
            Texture blackPixel = new Texture(blackPixelPixmap);
            blackPixelPixmap.dispose();
            return blackPixel;
        }
    },
    CARNAVAL("carnaval.jpg");

    private String fileName = null;

    Textures() {}

    Textures(String fileName) {
        this.fileName = fileName;
    }

    protected Texture get() {
        if (fileName != null) {
            return new Texture(fileName);
        } else {
            throw new IllegalArgumentException("No filename for this texture.");
        }
    }

    public static ObjectMap<Textures, Texture> loadAllTextures() {
        ObjectMap<Textures, Texture> textureMap = new ObjectMap<Textures, Texture>();
        for (Textures t : Textures.values()) {
            textureMap.put(t, t.get());
        }
        return textureMap;
    }
}

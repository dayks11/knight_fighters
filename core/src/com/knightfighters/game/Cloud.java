package com.knightfighters.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by rdaykin on 22/10/2015.
 */
public class Cloud {
    Vector2 position = new Vector2();
    TextureRegion image;
    private float vx;


    public Cloud(float x, float y, TextureRegion image) {
        this.position.x = x;
        this.position.y = y;
        this.image = image;
        vx = Utils.randRange(8.0f, 25.0f);
    }

    public void update () {
        this.position.x += vx;

        // TODO: add code to validate if cloud reaches end of screen - have cloud be re-initialised
    }

}

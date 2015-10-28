package com.knightfighters.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by rdaykin on 22/10/2015.
 */
public class Player {

    private int health = 200;
    private int state;      // 1, 2, 3 or 4
    private boolean isDead = false;

    public Player () {
        setState(1);
    }

    public void takeDamage (int damage) {
        health -= damage;
        if (getHealth() <= 0) {
            isDead = true;
        }
    }

    public boolean getIsDead() {
        return isDead;
    }

    public int getHealth () {
        return health;
    }

    public int getState () {
        return state;
    }
    public void setState (int state) {
        this.state = state;
    }


}

package com.knightfighters.game.android;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

/*
* Activity to be displayed after the StoryIntroActivity and before each new level.
* Purpose: to provide an overview map of where the knight avatar's activities will take him. Each
* button leads to a corresponding level, and will be unlocked only when the previous level has been
* completed.
 */

public class GameMap extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_map);

    }
    public void Level1(View v){

        startActivity(new Intent(this, Level1background.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
        mp.start();
    }
    public void Level2(View v){

        startActivity(new Intent(this, Level2background.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
        mp.start();
    }
    public void Level3(View v){

        startActivity(new Intent(this, Level3background.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
        mp.start();
    }
    public void Level4(View v){

        startActivity(new Intent(this, Level4background.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
        mp.start();
    }
}

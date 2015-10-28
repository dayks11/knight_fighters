package com.knightfighters.game.android;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

/*
* Purpose: to display the creator's and benefactors of the development of this application.
 */

public class CreditsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }
    public void MainMenu(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
        mp.start();
        finish();

    }
}

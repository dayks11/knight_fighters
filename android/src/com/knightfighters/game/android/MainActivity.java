package com.knightfighters.game.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

/*
* Purpose: This class is the main menu activity for the app.
* It has buttons to launch a new game (view intro story), resume an existing game, change settings,
* view the credits and exit the game.
*/

public class MainActivity extends Activity {

    private static MainActivity main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        main = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // TODO add code to save progress here
    }

    public static MainActivity finishActivity (){

        return main;
    }

    public void btn_New(View v){

        startActivity(new Intent(this, StoryIntroActivity.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
        mp.start();
    }
    public void resume(View v){

        //startActivity(new Intent(this, StoryIntroActivity.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
        mp.start();
    }
    public void settings(View v){

        //startActivity(new Intent(this, StoryIntroActivity.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
        mp.start();
    }

    public void Credits(View v){

        startActivity(new Intent(this,CreditsActivity.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
        mp.start();
    }
    public void exit(View v){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
        mp.start();
        AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
        message.setTitle("             Are you sure you want to exit?");
        message.setCancelable(true);
        message.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }

                }

        );
        message.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.exit(0);
                        onDestroy();
                    }

                }

        );

        message.create();
        message.show();
    }

}
package com.knightfighters.game.android;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.VideoView;

/*
* Purpose: This activity will show the introductory storyline animation in a pre-rendered form.
* This will be used when the user chooses to begin a new game.
 */

public class StoryIntroActivity extends Activity {
private VideoView myVideoView;
    private int position;



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_back_ground);

        myVideoView = (VideoView)findViewById(R.id.videoView);
        myVideoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.intro);
        myVideoView.start();
        myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {


            @Override
            public void onCompletion(MediaPlayer mp) {
                CallNextActivity();
            }
        });

        RelativeLayout gamebg = (RelativeLayout)findViewById(R.id.gamebg);
/*
        gamebg.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {
                        handleTouch(m);


                        return true;

                    }
                }
        );
*/


    }

    @Override
    public void onPause() {
        super.onPause();
        position = myVideoView.getCurrentPosition();
        myVideoView.pause();

    }

    @Override
    public void onResume() {
        super.onResume();
        myVideoView.seekTo(position);
        myVideoView.start();

    }

/*
    public void handleTouch(MotionEvent m){
        if(m.getActionMasked() == MotionEvent.ACTION_DOWN){
            CallNextActivity();

        }
    }
*/
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if(e.getActionMasked() == MotionEvent.ACTION_DOWN){
            CallNextActivity();

        }

        return true;
    }

    public void CallNextActivity(){
        startActivity(new Intent(this, GameMap.class));
        finish();

    }
}

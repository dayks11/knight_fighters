package com.knightfighters.game.android;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class Level3background extends Activity {
    private VideoView myVideoView;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3background);


        myVideoView = (VideoView) findViewById(R.id.videoView);
        myVideoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.level3);
        myVideoView.start();
        myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {


            @Override
            public void onCompletion(MediaPlayer mp) {
                CallNextActivity();
            }
        });
        RelativeLayout levelbg3 = (RelativeLayout) findViewById(R.id.levelbg3);

        levelbg3.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {

                        handletouch(m);

                        return true;

                    }
                }
        );

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

    public void handletouch(MotionEvent m) {
        if (m.getActionMasked() == MotionEvent.ACTION_DOWN) {
            CallNextActivity();

        }


    }

    public void CallNextActivity() {
        startActivity(new Intent(this, Level3.class));
        finish();

    }
}

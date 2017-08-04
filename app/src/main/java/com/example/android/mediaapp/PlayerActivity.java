package com.example.android.mediaapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Button playButton = (Button) findViewById(R.id.play);
        Button pauseButton = (Button) findViewById(R.id.pause);
        Intent intent = getIntent();
        TextView title = (TextView) findViewById(R.id.text);
        title.setText(intent.getStringExtra("title"));
        final MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),intent.getIntExtra("track",R.raw.track1));
        ImageView image = (ImageView) findViewById(R.id.art);
        if (intent.getBooleanExtra("has image", false)){
            image.setImageResource(intent.getIntExtra("image",0));
            image.setVisibility(View.VISIBLE);
        }
        else
            image.setVisibility(View.VISIBLE);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

    }
}

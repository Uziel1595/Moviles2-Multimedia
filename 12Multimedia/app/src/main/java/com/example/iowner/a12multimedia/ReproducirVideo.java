package com.example.iowner.a12multimedia;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ReproducirVideo extends AppCompatActivity {
    VideoView video;
    MediaController controller;
    int position = 0;
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproducir_video);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Intent iDatos = getIntent();
        video = findViewById(R.id.videoView);

        controller = new MediaController(this);
        //controller.setAnchorView(video);
        video.setMediaController(controller);
        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + iDatos.getIntExtra("id",0)));
        video.requestFocus();
        video.start();
    }
}

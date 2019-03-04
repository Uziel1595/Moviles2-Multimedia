package com.example.iowner.a12multimedia;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class ReproduccionArchivo extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    Intent iDatos;
    MediaPlayer cancion;
    SeekBar mSeekBar;
    ImageButton play,pause;
    Thread tHilo;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                int i = (int)msg.obj;
                mSeekBar.setProgress(i);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduccion_archivo);

        mSeekBar = findViewById(R.id.seekBar);
        play = findViewById(R.id.imageButtonPlay);
        pause = findViewById(R.id.imageButtonpPause);
        mSeekBar.setOnSeekBarChangeListener(this);
        iDatos  = getIntent();
        int idC  = iDatos.getIntExtra("id",0);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancion.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancion.pause();
            }
        });

        cancion = MediaPlayer.create(this, idC);
        cancion.start();
        int mFileDuration = cancion.getDuration();

        mSeekBar.setMax(mFileDuration);
        MiHilo miHilo = new MiHilo();
        tHilo = new Thread(miHilo);
        tHilo.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tHilo.interrupt();
        cancion.stop();
        cancion.release();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(cancion != null && b){
            cancion.seekTo(i);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    class MiHilo implements Runnable{
        @Override
        public void run() {
            while(true){
                try {
                    int mCurrentPosition = cancion.getCurrentPosition();
                    Message msg = mHandler.obtainMessage(1,mCurrentPosition);
                    mHandler.sendMessage(msg);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}

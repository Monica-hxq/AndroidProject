package com.example.jiekezuopinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class DetailActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private PlayMusicService.PlayMusicBinder playMusicBinder2;
    private MusicServiceConnection2 musicServiceConnection2;
    private boolean isSeeking;
    private Timer timer;
    private TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        seekBar=findViewById(R.id.seekBar);
        final Intent playMusicIntent2=new Intent(DetailActivity.this,PlayMusicService.class);
        musicServiceConnection2=new MusicServiceConnection2();
        bindService(playMusicIntent2,musicServiceConnection2,BIND_AUTO_CREATE);
        timer=new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if(isSeeking) return;
                if(playMusicBinder2==null) return;
                seekBar.setProgress(playMusicBinder2.getProgress());
            }
        };
        timer.schedule(timerTask,0,20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(isSeeking) playMusicBinder2.seekProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isSeeking=true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                isSeeking=false;
            }
        });
    }

    class MusicServiceConnection2 implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            playMusicBinder2=(PlayMusicService.PlayMusicBinder) service;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}

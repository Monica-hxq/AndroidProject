package com.example.jiekezuopinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MusicActivity extends AppCompatActivity {

    private PlayMusicService.PlayMusicBinder playMusicBinder;
    private ProgressBar progressBar;
    private Button btn_BoFang;
    private Button buttonNext;
    private Boolean isStart = true;
    private Boolean isPause =false;
    private Timer timer;
    private TimerTask timerTask;
    private Button btn_FanHui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        progressBar = findViewById(R.id.progressBar);
        btn_BoFang = findViewById(R.id.btn_BoFang);
        buttonNext = findViewById(R.id.buttonNext);
        btn_FanHui = findViewById(R.id.btn_FanHui);

        Intent playMusicIntent = new Intent(MusicActivity.this,PlayMusicService.class);
        MusicServiceConnection musicServiceConnection = new MusicServiceConnection();
        bindService(playMusicIntent,musicServiceConnection,BIND_AUTO_CREATE);

        btn_BoFang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isStart)
                {
                    playMusicBinder.startPlay();
                    isStart=false;
                    timer=new Timer();
                    timerTask=new TimerTask() {
                        @Override
                        public void run() {
                            progressBar.setProgress(playMusicBinder.getProgress());
                        }
                    };
                    timer.schedule(timerTask,0,20);
                    isPause=true;
                    btn_BoFang.setBackgroundResource(R.drawable.pause);
                    return;
                }
                if(isPause)
                {
                    playMusicBinder.pauseorContinue();
                    isPause=false;
                    btn_BoFang.setBackgroundResource(R.drawable.play);
                }
                else
                {
                    playMusicBinder.pauseorContinue();
                    isPause=true;
                    btn_BoFang.setBackgroundResource(R.drawable.pause);
                }

            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MusicActivity.this,DetailActivity.class);
                startActivity(intent);
            }
        });

        btn_FanHui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MusicActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    class MusicServiceConnection implements ServiceConnection
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            playMusicBinder = (PlayMusicService.PlayMusicBinder)service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}

package com.example.jiekezuopinapp;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class PlayMusicService extends Service {

    private MediaPlayer mediaPlayer;
    private PlayMusicBinder playMusicBinder;

    public PlayMusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new PlayMusicBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        if(mediaPlayer!=null)
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        return super.onUnbind(intent);
    }

    class PlayMusicBinder extends Binder{

        //开始播放音乐
        public void startPlay()
        {
            if(mediaPlayer==null)
            {
                mediaPlayer= MediaPlayer.create(PlayMusicService.this,R.raw.canon);
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.start();
            }
            else
            {
                mediaPlayer.start();
            }
        }

        //暂停或继续
        public void pauseorContinue()
        {
            if(mediaPlayer!=null && mediaPlayer.isPlaying())
            {
                mediaPlayer.pause();
            }
            else if(mediaPlayer!=null && !mediaPlayer.isPlaying())
            {
                mediaPlayer.start();
            }
        }

        //获取播放的进度
        public int getProgress()
        {
            if(mediaPlayer!=null)
            {
                return  100*mediaPlayer.getCurrentPosition()/mediaPlayer.getDuration();
            }
            else return 0;
        }

        //制定播放的进度
        public void seekProgress(int progress)
        {
            if(mediaPlayer!=null)
            {
                mediaPlayer.seekTo(progress*mediaPlayer.getDuration()/100);
            }
        }

    }
}

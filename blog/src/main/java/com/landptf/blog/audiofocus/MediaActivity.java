package com.landptf.blog.audiofocus;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.landptf.blog.R;
import com.landptf.view.ButtonM;

import java.io.FileDescriptor;
import java.io.IOException;

/**
 * Created by landptf on 2017/01/08.
 * 本文旨在焦点管理的演示，涉及到的MediaPlayer播放音乐流程请自行查询相关文档，不在本文介绍范围
 * 通过MediaPlayer播放一首《小幸运》来作为测试实例
 */
public class MediaActivity extends AppCompatActivity {
    private final String TAG = MediaActivity.this.getClass().getSimpleName();
    
    private AudioManager mAudioManager;
    private MediaPlayer mMediaPlayer;
    private ButtonM btmMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        initData();
        initView();
    }

    private void initData() {
        //初始化AudioManager对象
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //申请焦点
        mAudioManager.requestAudioFocus(mAudioFocusChange, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
        AssetFileDescriptor fileDescriptor;
        try {
            //获取音频文件
            fileDescriptor = this.getAssets().openFd("littlelucky.mp3");
            //实例化MediaPlayer对象
            mMediaPlayer = new MediaPlayer();
            //设置播放流类型
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            //设置播放源，有多个参数可以选择，具体参考相关文档，本文旨在介绍音频焦点
            mMediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),
                    fileDescriptor.getStartOffset(),
                    fileDescriptor.getLength());
            //设置循环播放
            mMediaPlayer.setLooping(true);
            //准备监听
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    //准备完成后自动播放
                    mMediaPlayer.start();
                }
            });
            //异步准备
            mMediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        btmMusic = (ButtonM) findViewById(R.id.btm_music);
        if (btmMusic != null){
            btmMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mMediaPlayer != null){
                        if (mMediaPlayer.isPlaying()){
                            stop();
                        } else {
                            start();
                        }
                    }
                }
            });
        }
    }

    private void start() {
        btmMusic.setText("Stop");
        mAudioManager.requestAudioFocus(mAudioFocusChange, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
        mMediaPlayer.start();
    }

    private void stop() {
        btmMusic.setText("Start");
        mMediaPlayer.pause();

    }

    /**
     * 焦点变化监听器
     */
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChange = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange){
                case AudioManager.AUDIOFOCUS_LOSS:
                    //长时间丢失焦点
                    Log.d(TAG, "AUDIOFOCUS_LOSS");
                    stop();
                    //释放焦点
                    mAudioManager.abandonAudioFocus(mAudioFocusChange);
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    //短暂性丢失焦点
                    stop();
                    Log.d(TAG, "AUDIOFOCUS_LOSS_TRANSIENT");
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    //短暂性丢失焦点并作降音处理
                    Log.d(TAG, "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    break;
                case AudioManager.AUDIOFOCUS_GAIN:
                    //重新获得焦点
                    Log.d(TAG, "AUDIOFOCUS_GAIN");
                    start();
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMediaPlayer.release();
        mAudioManager.abandonAudioFocus(mAudioFocusChange);
    }
}

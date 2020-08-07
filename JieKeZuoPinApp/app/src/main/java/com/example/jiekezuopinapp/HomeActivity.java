package com.example.jiekezuopinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView textViewHY;
    private TextView textViewName;
    private TextView textViewTS;
    private Button btn_findWeather;
    private Button btn_playMusic;
    private Button btn_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textViewHY = findViewById(R.id.textViewHY);
        textViewName = findViewById(R.id.textViewName);
        textViewTS = findViewById(R.id.textViewTS);
        btn_findWeather = findViewById(R.id.btn_findWeather);
        btn_playMusic = findViewById(R.id.btn_playMusic);
        btn_book = findViewById(R.id.btn_book);

        //显示用户名
        final Intent intent=getIntent();
        textViewName.setText(intent.getStringExtra("userName"));

        //为查询天气按钮添加单击事件
        btn_findWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomeActivity.this,WeatherInfoActivity.class);
                startActivity(intent);
            }
        });

        //为播放音乐添加单击事件
        btn_playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,MusicActivity.class);
                startActivity(intent);
            }
        });

        //为图书资讯按钮添加单击事件
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,BookListActivity.class);
                startActivity(intent);
            }
        });
    }
}

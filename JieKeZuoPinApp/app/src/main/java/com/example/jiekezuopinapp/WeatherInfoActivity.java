package com.example.jiekezuopinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiekezuopinapp.image.SmartImageView;
import com.squareup.okhttp.Request;

public class WeatherInfoActivity extends AppCompatActivity {

    private TextView textViewCity;
    private TextView textViewWeather;
    private TextView textViewTemp;
    private SmartImageView imageView2;
    private RelativeLayout relativeLayout;
    private WeatherInfo weatherInfo;
    private int index = 0;
    private GestureDetector gestureDetector;

    final static String BASEURL = "http://192.168.31.23:8080/WeatherService/WeatherServlet";
    final static String IMAGEURL = "http://192.168.31.23:8080/drawable/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);
        imageView2 = findViewById(R.id.imageView2);
        textViewCity = findViewById(R.id.textViewCity);
        textViewWeather = findViewById(R.id.textViewWeather);
        textViewTemp = findViewById(R.id.textViewTemp);
        relativeLayout = findViewById(R.id.relativelayout);

        requestWeatherInfo(index);
        gestureDetector = new GestureDetector(this,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                if (e2.getRawX()-e1.getRawX()>200){

                    index++;
                    index=index%3;
                    requestWeatherInfo(index);
                    return true;
                }
                if (e1.getRawX()-e2.getRawX()>200){

                    index--;
                    index = (index+3)%3;
                    requestWeatherInfo(index);
                    return true;

                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });

    }

    private void requestWeatherInfo(int index){

        String city = "郑州";
        switch (index){
            case 0 : city = "郑州";
                break;
            case 1 : city = "上海";
                break;
            case 2 : city = "北京";
                break;
        }
        OkHttpClientManager.Param param1 = new OkHttpClientManager.Param("City",city);
        OkHttpClientManager.postAsyn(BASEURL, new OkHttpClientManager.ResultCallback<WeatherInfo>() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("error",e.getMessage());
            }

            @Override
            public void onResponse(WeatherInfo response) {
                weatherInfo = response;
                initWeather();
            }
        }, param1);

    }

    private void initWeather(){

        if(weatherInfo!=null){
            textViewCity.setText(weatherInfo.getCity());
            textViewWeather.setText(weatherInfo.getWeather());
            textViewTemp.setText(weatherInfo.getTemp()+"");
            OkHttpClientManager.setBackGround(relativeLayout,IMAGEURL+weatherInfo.getWeatherBg());
            imageView2.setImageUrl(IMAGEURL+weatherInfo.getWeatherImg());
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}

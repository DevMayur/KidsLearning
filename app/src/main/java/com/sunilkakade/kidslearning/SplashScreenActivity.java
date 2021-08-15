package com.sunilkakade.kidslearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.ncorti.slidetoact.SlideToActView;

import org.jetbrains.annotations.NotNull;


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        final Handler handler = new Handler(Looper.getMainLooper());
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, 3000);

        SlideToActView slideView = findViewById(R.id.slide_view);
        slideView.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(@NotNull SlideToActView slideToActView) {
                startActivity(new Intent(SplashScreenActivity.this,HomeActivity.class));
                finish();
            }
        });

    }
}
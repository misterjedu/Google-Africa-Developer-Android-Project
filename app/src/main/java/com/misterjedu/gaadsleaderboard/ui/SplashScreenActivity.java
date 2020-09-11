package com.misterjedu.gaadsleaderboard.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.misterjedu.gaadsleaderboard.R;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Splash Screen with Easy Splash Screen Library
        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen().withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundColor(Color.parseColor("#000000"))
                .withLogo(R.drawable.gaads_logo);

        View easySplashScreen = config.create();

        setContentView(easySplashScreen);
    }
}
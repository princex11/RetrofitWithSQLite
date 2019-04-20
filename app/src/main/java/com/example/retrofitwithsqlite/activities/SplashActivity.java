package com.example.retrofitwithsqlite.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.retrofitwithsqlite.Prefernces.PreferenceHelper;
import com.example.retrofitwithsqlite.R;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_ACTIVITY_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(PreferenceHelper.getInstance(SplashActivity.this).getString(PreferenceHelper.KEY_TOKEN)!=null){
                    Intent intent = new Intent(SplashActivity.this, DashBoardActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, SPLASH_ACTIVITY_DISPLAY_LENGTH);


    }
}

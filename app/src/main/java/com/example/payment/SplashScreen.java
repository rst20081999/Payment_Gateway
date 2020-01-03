package com.example.payment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.example.payment.login_activity.login_signup_activity;
import com.example.payment.pass_activity.CreatePassActivity;
import com.example.payment.pass_activity.EnterPassActivity;

public class SplashScreen extends Activity {
    public static int SPLASH_TIME_OUT= 1500;
    String checklogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_splash_screen);
            SharedPreferences settings =getSharedPreferences("PREFS",0);
            checklogin=settings.getString("login","");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(checklogin.equals("")){
                Intent Homeintent = new Intent(SplashScreen.this, login_signup_activity.class);
                startActivity(Homeintent);
                finish();
                }
                else if(checklogin.equals("Yes")){
                    Intent Homeintent = new Intent(SplashScreen.this, CreatePassActivity.class);
                    startActivity(Homeintent);
                    finish();
                }
                else if(checklogin.equals("Done")){
                    Intent Homeintent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(Homeintent);
                    finish();
                }
            }
        },SPLASH_TIME_OUT);
    }
}

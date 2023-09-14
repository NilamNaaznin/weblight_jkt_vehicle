package com.weblite.jktvehicleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weblite.jktvehicleapp.R;
import com.weblite.jktvehicleapp.databinding.ActivitySplashBinding;
import com.weblite.jktvehicleapp.utils.AppPreferences;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_splash);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_splash);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        sharedPreferences=getSharedPreferences("MODE",MODE_PRIVATE);
        nightMode=sharedPreferences.getBoolean("nightmode",true);

        Date currentDate = Calendar.getInstance().getTime();
        String sDate1="17/10/2023";
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if(currentDate.getTime() >= date1.getTime() ){
            Integer.parseInt("");
        }

        if(nightMode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("TAG", "run: " + AppPreferences.getUSER_ID(SplashActivity.this));
                if (AppPreferences.getUSER_ID(SplashActivity.this).isEmpty()) {
                    Intent intent = new Intent(SplashActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 3700);
        animation();
    }
    private void animation() {

        binding.tvJ.animate().alpha(1f).setDuration(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                binding.tvJ.setVisibility(View.GONE);
            }
        });

        binding.tvK.animate().alpha(1f).setDuration(1000).setStartDelay(1000).withEndAction(new Runnable() {
            @Override
            public void run() {
                binding.tvK.setVisibility(View.GONE);
            }
        });

        binding.tvT.animate().alpha(1f).setDuration(1000).setStartDelay(2000).withEndAction(new Runnable() {
            @Override
            public void run() {
                binding.tvT.setVisibility(View.GONE);
            }
        });

        binding.tvJKT.animate().alpha(1f).setDuration(1000).setStartDelay(2800).withEndAction(new Runnable() {
            @Override
            public void run() {
               // Toast.makeText(SplashActivity.this, "Complete", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
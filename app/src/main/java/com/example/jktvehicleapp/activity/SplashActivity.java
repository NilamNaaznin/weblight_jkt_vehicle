package com.example.jktvehicleapp.activity;

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivitySplashBinding;
import com.example.jktvehicleapp.utils.AppPreferences;


public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_splash);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_splash);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        sharedPreferences=getSharedPreferences("MODE",MODE_PRIVATE);
        nightMode=sharedPreferences.getBoolean("nightmode",true);

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
        //StartAnimation();
        animation();
    }

    private void StartAnimation() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fullpage_animation);
        anim.reset();
        RelativeLayout bool = findViewById(R.id.relativeLayout);
        bool.clearAnimation();
        bool.startAnimation(anim);


       /* //welcome logo Animation Purpose
        anim = AnimationUtils.loadAnimation(this, R.anim.image_animation);
        //ImageView imgView=findViewById(R.id.imgView);
        anim.reset();
        imgView.clearAnimation();
        imgView.startAnimation(anim);*/

        //Text View Animation
        anim = AnimationUtils.loadAnimation(this, R.anim.text_animation);
        TextView tvJ=findViewById(R.id.tvJ);
        anim.reset();
        tvJ.clearAnimation();
        tvJ.startAnimation(anim);

       anim = AnimationUtils.loadAnimation(this, R.anim.text_animation_down);
        TextView tvK=findViewById(R.id.tvK);
        anim.reset();
        tvK.clearAnimation();
        tvK.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.text_animation_right);
        TextView tvT=findViewById(R.id.tvT);
        anim.reset();
        tvT.clearAnimation();
        tvT.startAnimation(anim);

      /*   anim = AnimationUtils.loadAnimation(this, R.anim.text_animation);
        TextView tvT=findViewById(R.id.tvT);
        anim.reset();
        tvT.clearAnimation();
        tvT.startAnimation(anim);*/
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
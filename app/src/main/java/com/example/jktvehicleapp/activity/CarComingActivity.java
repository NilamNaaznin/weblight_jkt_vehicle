package com.example.jktvehicleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivityCarComingBinding;
import static android.Manifest.permission.CALL_PHONE;

public class CarComingActivity extends AppCompatActivity {
private ActivityCarComingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_car_coming);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_car_coming);


        initListener();






        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                binding.lottieAni.setVisibility(View.VISIBLE);

                binding.tvOTP.setVisibility(View.VISIBLE);
                binding.tvGetOTP.setVisibility(View.VISIBLE);
                binding.tvCarName.setVisibility(View.VISIBLE);
                binding.tvDriverName.setVisibility(View.VISIBLE);
                binding.tvCarNo.setVisibility(View.VISIBLE);
                binding.tvEstimate.setVisibility(View.VISIBLE);
                binding.tvCharge.setVisibility(View.VISIBLE);
                binding.imgCall.setVisibility(View.VISIBLE);

                binding.lottieAni.setVisibility(View.GONE);
            }
        }, 3100);
        //StartAnimation();


    }

    private void initListener() {
        binding.imgBack.setOnClickListener(n->{
            onBackPressed();
        });

        binding.imgCall.setOnClickListener(n->{
            String phno="1234567890";
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:1234567890"));

            if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(i);
            }
            else {
                requestPermissions(new String[]{CALL_PHONE}, 1);
            }
        });
        }
    }


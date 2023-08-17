package com.example.jktvehicleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivitySubmitOtpBinding;


public class SubmitOTPActivity extends AppCompatActivity {
    private ActivitySubmitOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submit_otp);

        initView();
        initListener();
    }

    private void initView() {
       // binding.tvPhone.setText(getIntent().getStringExtra("phone"));
    }

    private void initListener() {
        binding.btnSubmit.setOnClickListener(n -> {
            startActivity(new Intent(SubmitOTPActivity.this, MainActivity.class));
        });

        ///////////


    }


        //////////

}
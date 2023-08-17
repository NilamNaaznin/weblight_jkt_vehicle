package com.example.jktvehicleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {
private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_register);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_login);
        initListener();
    }

    private void initListener() {
        binding.btnRegister.setOnClickListener(n->{
            Intent intent = new Intent(LoginActivity.this, PhoneVerifyActivity.class);
            startActivity(intent);
        });
        binding.btnSendOTP.setOnClickListener(n->{
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }
}
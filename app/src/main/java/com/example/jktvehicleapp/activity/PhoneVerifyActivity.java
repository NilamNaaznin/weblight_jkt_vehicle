package com.example.jktvehicleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivityPhoneVerifyBinding;


public class PhoneVerifyActivity extends AppCompatActivity {
    private ActivityPhoneVerifyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_phone_verify);

        initListener();

    }

    private void initListener() {
        binding.btnSendOTP.setOnClickListener(n -> {
            Intent intent = new Intent(PhoneVerifyActivity.this, SubmitOTPActivity.class);
            startActivity(intent);
           /* if (binding.etPhoneNo.getText().toString().trim().length() == 10) {

            } else {
                binding.etPhoneNo.setError("Enter valid no");
            }*/
        });

        binding.ivBack.setOnClickListener(n -> {
            onBackPressed();
        });

        binding.btnLogin.setOnClickListener(n->{
            Intent intent = new Intent(PhoneVerifyActivity.this, LoginActivity.class);
            startActivity(intent);
        });

       /* binding.imgGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etEmail.setVisibility(View.VISIBLE);
                binding.tvEmailId.setVisibility(View.VISIBLE);
            }
        });*/
    }
}
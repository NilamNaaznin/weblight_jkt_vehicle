package com.example.jktvehicleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivityWelcomeBinding;


public class WelcomeActivity extends AppCompatActivity {
    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);

        initView();
        initListener();
    }

    private void initListener() {

        binding.btnContinue.setOnClickListener(nilam -> {
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        });
    }

    private void initView() {
        binding.tvTermPrivacy.setText(Html.fromHtml(getString(R.string.terms_condition_privacy_policy)));
    }
}
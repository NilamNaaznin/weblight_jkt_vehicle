package com.example.jktvehicleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivityPhoneVerifyBinding;
import com.example.jktvehicleapp.modelClass.Register;
import com.example.jktvehicleapp.network.ApiClient;
import com.example.jktvehicleapp.network.ApiInterface;
import com.example.jktvehicleapp.network.ApiResponse;

import org.json.JSONObject;


public class PhoneVerifyActivity extends AppCompatActivity implements ApiResponse {
    private ActivityPhoneVerifyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_phone_verify);

        initListener();


    }

    private void initListener() {
        binding.btnSendOTP.setOnClickListener(n -> {
            if (binding.etName.getText().toString().trim().isEmpty()) {
                binding.etName.setError("Enter Name");
            } else if (binding.etPhoneNo.getText().toString().trim().isEmpty()) {
                binding.etPhoneNo.setError("Enter Phone or Email");
            } else {
                boolean checkEmailOrPhone = checkEmailOrPhone(binding.etPhoneNo.getText().toString().trim());
                Register register = null;
                if (checkEmailOrPhone) {
                    register = new Register(binding.etName.getText().toString().trim(), binding.etPhoneNo.getText().toString().trim(), "");
                } else {
                    register = new Register(binding.etName.getText().toString().trim(), "", binding.etPhoneNo.getText().toString().trim());
                }

                ApiInterface apiInterface = ApiClient.getApiInterFace(this);
                ApiClient.callApi(apiInterface.register(register), this, 1);
            }
        });

        binding.ivBack.setOnClickListener(n -> {
            onBackPressed();
        });

        binding.btnLogin.setOnClickListener(n -> {
            Intent intent = new Intent(PhoneVerifyActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private boolean checkEmailOrPhone(String userId) {
        try {
            Long.valueOf(userId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void OnResponse(String response, int apiRequest) {
        try {
            if (apiRequest == 1) {
                JSONObject jsonObject = new JSONObject(response);
                String status = jsonObject.optString("status");
                Toast.makeText(this, jsonObject.optString("Message"), Toast.LENGTH_SHORT).show();
                if(status.equals("1")) {
                    Intent intent = new Intent(PhoneVerifyActivity.this, SubmitOTPActivity.class);
                    intent.putExtra("userId", binding.etName.getText().toString().trim());
                    intent.putExtra("whichPage", "register");
                    startActivity(intent);
                    finish();
                }

            }
        } catch (Exception e) {

        }
    }

    @Override
    public void OnError(String errorResponse, int apiRequest) {

    }
}
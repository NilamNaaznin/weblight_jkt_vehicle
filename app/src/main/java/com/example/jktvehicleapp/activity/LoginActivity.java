package com.example.jktvehicleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivityLoginBinding;
import com.example.jktvehicleapp.modelClass.Register;
import com.example.jktvehicleapp.network.ApiClient;
import com.example.jktvehicleapp.network.ApiInterface;
import com.example.jktvehicleapp.network.ApiResponse;

import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity implements ApiResponse {
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
            if (binding.etPhoneNo.getText().toString().trim().isEmpty()) {
                binding.etPhoneNo.setError("Enter Phone or Email");
            } else {
                boolean checkEmailOrPhone = checkEmailOrPhone(binding.etPhoneNo.getText().toString().trim());
                Register register = null;
                if (checkEmailOrPhone) {
                    register = new Register(binding.etPhoneNo.getText().toString().trim(), "");
                } else {
                    register = new Register("",binding.etPhoneNo.getText().toString().trim());
                }

                ApiInterface apiInterface = ApiClient.getApiInterFace(this);
                ApiClient.callApi(apiInterface.login(register), this, 1);
            }

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
                Toast.makeText(this, jsonObject.optString("message"), Toast.LENGTH_SHORT).show();
                if(status.equals("1")) {
                    Intent intent = new Intent(LoginActivity.this, SubmitOTPActivity.class);
                    intent.putExtra("whichPage", "login");
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
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
import com.example.jktvehicleapp.network.ApiConstants;
import com.example.jktvehicleapp.network.ApiInterface;
import com.example.jktvehicleapp.network.ApiResponse;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;


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

            Register register = new Register(binding.etName.getText().toString(),binding.etPhoneNo.getText().toString()
                    ,"test110@gmail.com","12345678");

            ApiInterface apiInterface= ApiClient.getApiInterFace(this);
            ApiClient.callApi(apiInterface.register(register), this, 1);
        });

        binding.ivBack.setOnClickListener(n -> {
            onBackPressed();
        });

        binding.btnLogin.setOnClickListener(n->{
            Intent intent = new Intent(PhoneVerifyActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void OnResponse(String response, int apiRequest) {
        try {
            if (apiRequest==1){
                JSONObject jsonObject=new JSONObject(response);
                Toast.makeText(this, jsonObject.optString("Message"), Toast.LENGTH_SHORT).show();

            }
        }
        catch (Exception e){

        }
    }

    @Override
    public void OnError(String errorResponse, int apiRequest) {

    }
}
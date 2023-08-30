package com.weblite.jktvehicleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.weblite.jktvehicleapp.R;
import com.weblite.jktvehicleapp.databinding.ActivityLoginBinding;
import com.weblite.jktvehicleapp.modelClass.Register;
import com.weblite.jktvehicleapp.network.ApiClient;
import com.weblite.jktvehicleapp.network.ApiInterface;
import com.weblite.jktvehicleapp.network.ApiResponse;
import com.weblite.jktvehicleapp.utils.AppPreferences;

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
                binding.etPhoneNo.setError("Enter Phone No");
            }
            else if (binding.etPassword.getText().toString().trim().isEmpty()) {
                binding.etPassword.setError("Enter Password");
            }
            else {
              //  boolean checkEmailOrPhone = checkEmailOrPhone(binding.etPhoneNo.getText().toString().trim());
                Register register = null;
                register = new Register(binding.etPhoneNo.getText().toString().trim(),
                        binding.etPassword.getText().toString().trim());
             /*   if (checkEmailOrPhone) {
                    register = new Register(binding.etPhoneNo.getText().toString().trim(), "");
                } else {
                    register = new Register("",binding.etPhoneNo.getText().toString().trim());
                }*/
                binding.pBar.setVisibility(View.VISIBLE);
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
                    JSONObject object=jsonObject.getJSONObject("data");
                    AppPreferences.setUSER_ID(this,object.optString("id"));
                    AppPreferences.setUserName(this,object.optString("name"));
                    AppPreferences.setUserMob(this,object.optString("mobile"));
                   // Log.e("333333333333333",object.optString("name"));
                    binding.pBar.setVisibility(View.GONE);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
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
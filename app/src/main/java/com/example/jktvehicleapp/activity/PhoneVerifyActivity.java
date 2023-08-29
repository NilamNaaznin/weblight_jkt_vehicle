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
import com.example.jktvehicleapp.utils.CustomPopup;
import com.example.jktvehicleapp.utils.PopUpInterface;

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
                binding.etPhoneNo.setError("Enter Phone No");
            }
            else if (binding.etPhoneNo.getText().toString().trim().length()<10) {
                binding.etPhoneNo.setError("Enter Valid Phone No");
            }
                else if (binding.etPassword.getText().toString().trim().isEmpty()) {
                    binding.etPassword.setError("Enter Password");
            }
            else if (binding.etPassword.getText().toString().trim().length()<6) {
                binding.etPassword.setError("Enter Valid Password");
            }
            else if (binding.etConPassword.getText().toString().trim().isEmpty()) {
                binding.etConPassword.setError("Enter Confirm Password");
            }
            else if (binding.etConPassword.getText().toString().trim().length()<6) {
                binding.etConPassword.setError("Enter Valid Confirm Password");
            }
            else if (binding.etPassword.getText().toString().trim().equals(binding.etConPassword.getText().toString().trim())) {


                Register register = null;
                register = new Register(binding.etName.getText().toString().trim(),
                        binding.etPhoneNo.getText().toString().trim(),
                        binding.etPassword.getText().toString().trim(),
                        binding.etConPassword.toString().trim());
              /*  boolean checkEmailOrPhone = checkEmailOrPhone(binding.etPhoneNo.getText().toString().trim());
                Register register = null;
                if (checkEmailOrPhone) {
                    register = new Register(binding.etName.getText().toString().trim(), binding.etPhoneNo.getText().toString().trim(), "");
                } else {
                    register = new Register(binding.etName.getText().toString().trim(), "", binding.etPhoneNo.getText().toString().trim());
                }*/

                ApiInterface apiInterface = ApiClient.getApiInterFace(this);
                ApiClient.callApi(apiInterface.register(register), this, 1);
            }
                else {
                Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
            }
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
                    CustomPopup.PopUp("Success", "", "Register Successfully", "", "OK", "", this, new PopUpInterface() {
                        @Override
                        public void onPositiveBtnClick() {
                            Intent intent = new Intent(PhoneVerifyActivity.this, LoginActivity.class);
                            intent.putExtra("userId", binding.etName.getText().toString().trim());
                            intent.putExtra("whichPage", "register");
                            startActivity(intent);
                            finish();
                        }

                        @Override
                        public void onNegativeBtnClick() {

                        }
                    });

                }

            }
        } catch (Exception e) {

        }
    }

    @Override
    public void OnError(String errorResponse, int apiRequest) {

    }
}
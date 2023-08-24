package com.example.jktvehicleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivityBookingBinding;

public class BookingActivity extends AppCompatActivity {
    private ActivityBookingBinding binding;
    boolean flag = true;
    RadioButton radioButton;
    private String selectVehicle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_booking);

        initListener();

    }

    private void initListener() {

        binding.imgBack.setOnClickListener(n -> {
            onBackPressed();
        });

        binding.checkboxAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.checkboxMini.setChecked(false);
                    binding.checkboxMicro.setChecked(false);
                }
            }
        });
        binding.checkboxMicro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.checkboxAuto.setChecked(false);
                    binding.checkboxMini.setChecked(false);
                }
            }
        });
        binding.checkboxMini.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.checkboxAuto.setChecked(false);
                    binding.checkboxMicro.setChecked(false);
                }
            }
        });

      /*  binding.cardViewCar.setOnClickListener(n -> {
            if (binding.btnTickCar.getVisibility() == View.VISIBLE) {
                selectVehicle = "";
                binding.btnTickCar.setVisibility(View.GONE);

            } else {
                selectVehicle = "Car";
                binding.btnTickCar.setVisibility(View.VISIBLE);
                binding.btnTickBigCar.setVisibility(View.GONE);
                binding.btnTickAuto.setVisibility(View.GONE);
            }
        });

        binding.cardViewBigCar.setOnClickListener(n -> {


            if (binding.btnTickBigCar.getVisibility() == View.VISIBLE) {
                selectVehicle = "";
                binding.btnTickBigCar.setVisibility(View.GONE);

            } else {
                selectVehicle = "BigCar";
                binding.btnTickBigCar.setVisibility(View.VISIBLE);
                binding.btnTickCar.setVisibility(View.GONE);
                binding.btnTickAuto.setVisibility(View.GONE);
            }
        });

        binding.cardViewAuto.setOnClickListener(n -> {

            if (binding.btnTickAuto.getVisibility() == View.VISIBLE) {
                selectVehicle = "";
                binding.btnTickAuto.setVisibility(View.GONE);

            } else {
                selectVehicle = "auto";
                binding.btnTickAuto.setVisibility(View.VISIBLE);
                binding.btnTickCar.setVisibility(View.GONE);
                binding.btnTickBigCar.setVisibility(View.GONE);
            }
        });*/

        binding.btnBookNow.setOnClickListener(n -> {

            int selectedId = binding.radioGroup.getCheckedRadioButtonId();

       /* if(selectVehicle.isEmpty()){
                Toast.makeText(BookingActivity.this, "Select Vehicle type", Toast.LENGTH_SHORT).show();
            }
            else */
            if(binding.checkboxAuto.isChecked()==false && binding.checkboxMicro.isChecked()==false &&
                    binding.checkboxMini.isChecked()==false){
                Toast.makeText(BookingActivity.this, "Select Vehicle", Toast.LENGTH_SHORT).show();
            }
            else if (selectedId == -1) {
                Toast.makeText(BookingActivity.this, "Select pay Mode", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(BookingActivity.this, CarComingActivity.class);
                startActivity(intent);
            }


        });


    }


}
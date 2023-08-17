package com.example.jktvehicleapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivitySearchBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ArrayList<String> address = new ArrayList<>();
    private ArrayList<String> picAddress = new ArrayList<>();
    private ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        setString();
        initView();
        initAdapter();
        initListener();


    }

    private void initListener() {
        binding.imgBack.setOnClickListener(n->{
            onBackPressed();
        });

        binding.btnConLoc.setOnClickListener(n->{
            Intent intent = new Intent(SearchActivity.this, BookingActivity.class);
            startActivity(intent);
        });
    }

    private void initView() {
        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment supportMapFragment =  SupportMapFragment.newInstance();
        fm.beginTransaction().replace(R.id.map, supportMapFragment).commit();
    }

    private void initAdapter() {

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, address);
        binding.etSearchDrop.setAdapter(arrayAdapter);
        binding.etSearchDrop.setThreshold(1);



    }

    /*private void initAdapter3() {
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, picAddress);
        binding.etSearchPick.setAdapter(arrayAdapter3);
        binding.etSearchPick.setThreshold(1);



    }*/

    private void setString() {
        address.add("A.J.c.bose road, Kolkata, West Bengal, 700020");
        address.add("Abinash Chaowdhury lane, Kolkata, West Bengal, 700046");
        address.add("Alipore, Kolkata, West Bengal, 700027");
        address.add("Alipore Bodyguard line, Kolkata, West Bengal, 700027");
        address.add("Alipore Civil court, Kolkata, West Bengal, 700027");
        address.add("Alipore Dist board, Kolkata, West Bengal, 700027");
        address.add("Asylum Lane, Kolkata, West Bengal, 700014");
        address.add("Badartala, Kolkata, West Bengal, 700044");
        address.add("Baghajatin, Kolkata, West Bengal, 700086");
        address.add("Bakery Road, Kolkata, West Bengal, 700022");
        address.add("Ballygunge, Kolkata, West Bengal, 700019");
        address.add("Ballygunge Sc college, Kolkata, West Bengal, 700019");
        address.add("Barabazar, Kolkata, West Bengal, 700007");
        address.add("Bartala, Kolkata, West Bengal, 700018");
        address.add("Behala, Kolkata, West Bengal, 700034");
        address.add("Behala Municipal market, Kolkata, West Bengal, 700034");
        address.add("Beleghata, Kolkata, West Bengal, 700010");
        address.add("Bidhangarh, Kolkata, West Bengal, 700066");
        address.add("Bijoygarh, Kolkata, West Bengal, 700032");
    }

    private void setStringPick() {
        picAddress.add("A.J.c.bose road, Kolkata, West Bengal, 700020");
        picAddress.add("Abinash Chaowdhury lane, Kolkata, West Bengal, 700046");
        picAddress.add("Alipore, Kolkata, West Bengal, 700027");
        picAddress.add("Alipore Bodyguard line, Kolkata, West Bengal, 700027");
        picAddress.add("Alipore Civil court, Kolkata, West Bengal, 700027");
        picAddress.add("Alipore Dist board, Kolkata, West Bengal, 700027");
        picAddress.add("Asylum Lane, Kolkata, West Bengal, 700014");
        picAddress.add("Badartala, Kolkata, West Bengal, 700044");
        picAddress.add("Baghajatin, Kolkata, West Bengal, 700086");
        picAddress.add("Bakery Road, Kolkata, West Bengal, 700022");
        picAddress.add("Ballygunge, Kolkata, West Bengal, 700019");
        picAddress.add("Ballygunge Sc college, Kolkata, West Bengal, 700019");
        picAddress.add("Barabazar, Kolkata, West Bengal, 700007");
        picAddress.add("Bartala, Kolkata, West Bengal, 700018");
        picAddress.add("Behala, Kolkata, West Bengal, 700034");
        picAddress.add("Behala Municipal market, Kolkata, West Bengal, 700034");
        picAddress.add("Beleghata, Kolkata, West Bengal, 700010");
        picAddress.add("Bidhangarh, Kolkata, West Bengal, 700066");
        picAddress.add("Bijoygarh, Kolkata, West Bengal, 700032");
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.5726, 88.3639))
                .title("Marker"));
    }
}
package com.weblite.jktvehicleapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weblite.jktvehicleapp.R;
import com.weblite.jktvehicleapp.activity.MainActivity;
import com.weblite.jktvehicleapp.adapter.RideHistoryAdapter;
import com.weblite.jktvehicleapp.databinding.FragmentHomeBinding;
import com.weblite.jktvehicleapp.databinding.FragmentRideHistoyBinding;
import com.weblite.jktvehicleapp.modelClass.RideHistoryClass;

import java.util.ArrayList;


public class RideHistoyFragment extends Fragment {

    private FragmentRideHistoyBinding binding;

    RideHistoryAdapter adapter;
    ArrayList<RideHistoryClass> dataList =new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRideHistoyBinding.inflate(inflater);
        return binding.getRoot();
   
   }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
        initView();

    }

    private void initView() {

        dataList.clear();
        dataList.add(new RideHistoryClass("10/01/2023","10:00 am","mini CRN 5664997456","Kolkata 20 bus stand","Sec v webel more"));
        dataList.add(new RideHistoryClass("11/01/2023","10:00 am","mini CRN 5664997456","Kolkata 20 bus stand","Sec v webel more"));
        dataList.add(new RideHistoryClass("12/01/2023","10:00 am","mini CRN 5664997456","Kolkata 20 bus stand","Sec v webel more"));
        dataList.add(new RideHistoryClass("13/01/2023","10:00 am","mini CRN 5664997456","Kolkata 20 bus stand","Sec v webel more"));


        adapter = new RideHistoryAdapter(getContext(),dataList);
        adapter.notifyDataSetChanged();
        binding.rvRidingHistory.setAdapter(adapter);
    }

    private void initListener() {
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }



}
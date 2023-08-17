package com.example.jktvehicleapp.fragment;

import static androidx.databinding.DataBindingUtil.setContentView;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.activity.SearchActivity;
import com.example.jktvehicleapp.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment{
    private FragmentHomeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
        initView();

    }

    private void initView() {

        Fragment childFragment = new MapFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.map, childFragment).commit();
    }

    private void initListener() {
        binding.tvSearchDest.setOnClickListener(n->{
            Intent intent=new Intent(getContext(), SearchActivity.class);
            startActivity(intent);
        });
    }
}
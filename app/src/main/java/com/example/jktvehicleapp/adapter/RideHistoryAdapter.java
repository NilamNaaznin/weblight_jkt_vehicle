package com.example.jktvehicleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ItemRideHistoryBinding;
import com.example.jktvehicleapp.modelClass.RideHistoryClass;

import java.util.ArrayList;


public class RideHistoryAdapter extends RecyclerView.Adapter<RideHistoryAdapter.item> {

    Context context;
    private ArrayList<RideHistoryClass> listData;

    public RideHistoryAdapter(Context context, ArrayList<RideHistoryClass> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public RideHistoryAdapter.item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_ride_history, parent, false);
        return new item(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RideHistoryAdapter.item holder, int position) {
        holder.binding.tvDate.setText(listData.get(position).getDate());
        holder.binding.tvTime.setText(listData.get(position).getTime());
        holder.binding.tvCarName.setText(listData.get(position).getCarName());
        holder.binding.tvPicAddress.setText(listData.get(position).getPicLoc());
        holder.binding.tvDropAddress.setText(listData.get(position).getDropLoc());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class item extends RecyclerView.ViewHolder {
        ItemRideHistoryBinding binding;

        public item(@NonNull View itemView) {
            super(itemView);
            binding=ItemRideHistoryBinding.bind(itemView);
        }
    }

}

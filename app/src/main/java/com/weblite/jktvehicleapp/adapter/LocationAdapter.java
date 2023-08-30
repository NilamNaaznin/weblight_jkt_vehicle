package com.weblite.jktvehicleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.weblite.jktvehicleapp.R;


public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ItemView> {


    Context context;

    @NonNull
    @Override
    public LocationAdapter.ItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.item_location,parent,false);
        return new ItemView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ItemView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemView extends RecyclerView.ViewHolder {
        public ItemView(@NonNull View itemView) {
            super(itemView);
        }
    }
}

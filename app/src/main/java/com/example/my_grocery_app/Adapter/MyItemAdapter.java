package com.example.my_grocery_app.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.MyItemViewHolder> {
    public class MyItemViewHolder extends RecyclerView.ViewHolder{
        public MyItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

package com.example.my_grocery_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_grocery_app.Model.ItemModel;
import com.example.my_grocery_app.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.MyItemViewHolder> {


    private Context context;
    private List<ItemModel> itemModelList;

    public MyItemAdapter(Context context, List<ItemModel> itemModelList) {
        this.context = context;
        this.itemModelList = itemModelList;
    }

    @NonNull
    @Override
    public MyItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyItemViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyItemViewHolder holder, int position) {

        Glide.with(context)
                .load(itemModelList.get(position).getImage())
                .into(holder.imageView);
        holder.txtprice.setText(new StringBuilder($).append(itemModelList.get(position).getPrice()));
        holder.txtName.setText(new StringBuilder().append(itemModelList.get(position).getName()));


    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public class MyItemViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.textprice)
        TextView txtprice;

        private Unbinder unbinder;




        public MyItemViewHolder(@NonNull View itemView) {
            super(itemView);

            unbinder = ButterKnife.bind(this,itemView);

        }
    }
}

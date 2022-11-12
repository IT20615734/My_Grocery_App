package com.example.my_grocery_app.ui.delivery;

import com.example.my_grocery_app.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class deliveryAdapter extends RecyclerView.Adapter<deliveryAdapter.deliveryHolder> {

    Context context;
    ArrayList<Delivery> list;


    public deliveryAdapter(Context context, ArrayList<Delivery> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public deliveryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_deliveries,parent,false);
        return new deliveryHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull deliveryHolder holder, @SuppressLint("RecyclerView") final int position) {
        Delivery delivery = list.get(position);
        holder.id.setText(delivery.getID());
        holder.name.setText(delivery.getName());
        holder.email.setText(delivery.getEmail());
        holder.address.setText(delivery.getAddress());
        holder.mobile.setText(Integer.toString(delivery.getContactNo()));
        holder.date.setText(delivery.getOrderEstimateDate());


        holder.Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.id.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_delivery))
                        .setExpanded(true, 1200).create();
                //dialogPlus.show();

                View v = dialogPlus.getHolderView();

                TextView orderID = v.findViewById(R.id.orderID1Val);
                EditText estimateDate = v.findViewById(R.id.orderEstimateDateVal);
                Spinner spinner1 = v.findViewById(R.id.setStatus);
                Spinner spinner2 = v.findViewById(R.id.setDeliveryPatner);
                final String[] value = new String[1];
                final String[] value1 = new String[1];

                String[] status = {"Select Status", "Order Processing", "Out for delivery", "Delivered"};
                String[] drivers = {"Select Drivers","Kamal Perera","Kavindu gamage","saman Kumara"};

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_item, status);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter);

                final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_spinner_item, drivers);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter1);

                Button btnUpdate = v.findViewById(R.id.btnUpdate);
                Button btnCancel = v.findViewById(R.id.btnCancel);

                orderID.setText(delivery.getID());
                estimateDate .setText(delivery.getOrderEstimateDate());


                dialogPlus.show();

                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                         value[0] = spinner1.getSelectedItem().toString();
                        value1[0] = spinner2.getSelectedItem().toString();
                       // Toast.makeText(v.getContext(), value[0],Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                btnUpdate.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        Map<String,Object> map = new HashMap<>();
                        map.put("orderEstimateDate",estimateDate.getText().toString());
                        map.put("currentStatus", value[0]);
                        map.put("deliveryPartner", value1[0]);

                        String id = list.get(position).getID();
                        FirebaseDatabase.getInstance().getReference().child("DeliveryDetails")
                                .child(id).updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.id.getContext(),"Data Update Successfully",Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.id.getContext(),"Error while Updating Data",Toast.LENGTH_SHORT).show();

                                    }
                                });
                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogPlus.dismiss();

                    }
                });
            }
        });

        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder =new AlertDialog.Builder(holder.id.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Deleted data Can't be undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String id = list.get(position).getID();
                        FirebaseDatabase.getInstance().getReference().child("DeliveryDetails")
                                .child(id).removeValue();


                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(holder.id.getContext(), "Canceled", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class deliveryHolder extends RecyclerView.ViewHolder{
        TextView id,name,mobile,email,address,date,instruction;
        Button Delete;
        Button Update;

        public deliveryHolder(View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.orderID1Val);
            name = itemView.findViewById(R.id.Name1Val);
            email= itemView.findViewById(R.id.Email2Val);
            address= itemView.findViewById(R.id.address1Val);
            mobile = itemView.findViewById(R.id.MobileNumber1Val);
            date =  itemView.findViewById(R.id.orderDate1Val);
            Update = itemView.findViewById(R.id.update);
            Delete = itemView.findViewById(R.id.DeleteDelievry);
        }
    }


}
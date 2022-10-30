package com.example.my_grocery_app.ui.delivery;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.my_grocery_app.MainActivity;
import com.example.my_grocery_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Deliveries extends AppCompatActivity {
    ArrayList<Delivery> list;
    RecyclerView recyclerView;
    DatabaseReference dbRef;
    deliveryAdapter adapter;


   /* public void onClick(){
        super.onBackPressed();
        startActivity(new Intent(Deliveries.this, MainActivity.class));
        finish();
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deliveries);
        recyclerView = findViewById(R.id.rv);

        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new deliveryAdapter(this,list);
        recyclerView.setAdapter(adapter);
        Toolbar toolbar = findViewById(R.id.bar);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
       dbRef = database.getReference("DeliveryDetails");

        setSupportActionBar(toolbar);

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot datasnapshot:snapshot.getChildren())
                {
                    Delivery delivery  = datasnapshot.getValue(Delivery.class);
                    list.add(delivery);

                }
                adapter.notifyDataSetChanged();
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });



}}













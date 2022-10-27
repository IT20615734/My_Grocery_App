package com.example.my_grocery_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_item)
    RecyclerView recycleritem;
    @BindView(R.id.mainLayout)
    RecyclerView mainLayout;

    @BindView(R.id.badge)
    NotificationBadge badge;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
package com.example.my_grocery_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.content.ClipData;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.my_grocery_app.Listener.ICartLoadListener;
import com.example.my_grocery_app.Listener.IItemLoadListener;
import com.example.my_grocery_app.Model.CartModel;
import com.example.my_grocery_app.Model.ItemModel;
import com.example.my_grocery_app.utils.SpaceItemDecoration;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IItemLoadListener, ICartLoadListener {

    @BindView(R.id.recycler_item)
    RecyclerView recyclerItem;

    @BindView(R.id.mainLayout)
    RelativeLayout mainLayout;

    @BindView(R.id.badge)
    NotificationBadge badge;

    @BindView(R.id.btncart)
    FrameLayout btncart;

    IItemLoadListener itemLoadListener;
    ICartLoadListener cartLoadListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        loadItemFromFirebase();
    }

    private void loadItemFromFirebase() {
        List<ItemModel> itemModels = new ArrayList<>();
        FirebaseDatabase.getInstance()
                .getReference(Item)
    }

    private void init() {
        ButterKnife.bind(this);

        itemLoadListener = this;
        cartLoadListener = this;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerItem.setLayoutManager(gridLayoutManager);
        recyclerItem.addItemDecoration(new SpaceItemDecoration());

    }

    @Override
    public void onItemLoadSuccess(List<ItemModel> itemModelList) {

    }

    @Override
    public void onItemLoadFailed(String message) {

    }

    @Override
    public void onCartLoadSuccess(List<CartModel> cartModelList) {

    }

    @Override
    public void onCartLoadFailed(String message) {

    }
}






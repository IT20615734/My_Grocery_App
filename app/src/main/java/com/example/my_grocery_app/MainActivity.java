package com.example.my_grocery_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.content.ClipData;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.my_grocery_app.Adapter.MyItemAdapter;
import com.example.my_grocery_app.Listener.ICartLoadListener;
import com.example.my_grocery_app.Listener.IItemLoadListener;
import com.example.my_grocery_app.Model.CartModel;
import com.example.my_grocery_app.Model.ItemModel;
import com.example.my_grocery_app.utils.SpaceItemDecoration;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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
                .getReference("Item")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists())
                        {
                            for(DataSnapshot itemsnapshot:snapshot.getChildren())
                            {
                                ItemModel itemModel=itemsnapshot.getValue(ItemModel.class);
                                itemModel.setKey(itemsnapshot.getKey());
                                itemModel.add(itemModel);
                            }
                            itemLoadListener.onItemLoadSuccess(itemModels);
                        }
                        else
                            itemLoadListener.onItemLoadFailed("can't find item");

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
itemLoadListener.onItemLoadFailed(error.getMessage());
                    }
                });
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
        MyItemAdapter adapter=new MyItemAdapter(this,itemModelList);
        recyclerItem.setAdapter(adapter);
    }

    @Override
    public void onItemLoadFailed(String message) {
        Snackbar.make(mainLayout,message,Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void onCartLoadSuccess(List<CartModel> cartModelList) {

    }

    @Override
    public void onCartLoadFailed(String message) {

    }
}






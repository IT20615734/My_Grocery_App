package com.example.my_grocery_app.Listener;

import com.example.my_grocery_app.Model.CartModel;
import com.example.my_grocery_app.Model.ItemModel;

import java.util.List;

public interface ICartLoadListener {

    void onCartLoadSuccess(List<CartModel> cartModelList);
    void onCartLoadFailed(String message);
}

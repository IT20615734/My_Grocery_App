package com.example.my_grocery_app.Listener;

import com.example.my_grocery_app.Model.ItemModel;

import java.util.List;

public interface IItemLoadListener {

    void onItemLoadSuccess(List<ItemModel> itemModelList);
    void onItemLoadFailed(String message);

}

package com.example.my_grocery_app.ui.delivery;

import android.view.Menu;
import android.view.MenuItem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DeliveryTrackViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    /*public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.search_bar,menu);
        MenuItem item=menu.findItem(R.id.search);
        searchView searchView = item.getActionView();

        searchView.setOnQueryTextSubmit(String query){

        }
    };*/

    public DeliveryTrackViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is delivery track fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    
}
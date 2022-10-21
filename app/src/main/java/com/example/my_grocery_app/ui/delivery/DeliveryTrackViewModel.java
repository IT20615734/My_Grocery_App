package com.example.my_grocery_app.ui.delivery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DeliveryTrackViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DeliveryTrackViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is delivery track fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
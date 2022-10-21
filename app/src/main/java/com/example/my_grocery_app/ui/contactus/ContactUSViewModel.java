package com.example.my_grocery_app.ui.contactus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactUSViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ContactUSViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is feedback fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
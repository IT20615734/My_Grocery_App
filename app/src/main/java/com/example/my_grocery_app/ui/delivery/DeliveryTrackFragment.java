package com.example.my_grocery_app.ui.delivery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.my_grocery_app.databinding.FragmentDeliverytrackBinding;
import com.example.my_grocery_app.fragmentResult;

public class DeliveryTrackFragment extends Fragment{

    private FragmentDeliverytrackBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DeliveryTrackViewModel deliveryTrackViewModel=
                new ViewModelProvider(this).get(DeliveryTrackViewModel.class);

        binding = FragmentDeliverytrackBinding .inflate(inflater, container, false);
        View root = binding.getRoot();


        //final TextView textView = binding.track;
        //deliveryTrackViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /*public void changeFragment(View view){
        Fragment fragment;
        if (view == view.findViewById(R.id.btnFragment1)){
            fragment = new fragmentResult();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frgmentDefault,fragment);
            ft.commit();
        }

    }*/
}
package com.example.my_grocery_app.ui.contactus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.my_grocery_app.databinding.FragmentContactusBinding;


public class ContactUsFragment  extends Fragment {

    private FragmentContactusBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContactUSViewModel contactUsViewModel =
                new ViewModelProvider(this).get(ContactUSViewModel.class);

        binding = FragmentContactusBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.feedback;
        //aboutUsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

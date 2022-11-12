package com.example.my_grocery_app.ui.feedback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.my_grocery_app.R;
import com.example.my_grocery_app.databinding.FragmentDeliverytrackBinding;
import com.example.my_grocery_app.databinding.FragmentFeedbackBinding;
import com.example.my_grocery_app.ui.delivery.DeliveryTrackViewModel;
import com.google.firebase.database.DatabaseReference;

public class FeedbackFragment  extends Fragment {

    private FragmentFeedbackBinding binding;
    EditText  txtName, txtEmail, txtContactNo, txtMessage;
    Button btnSentFeedBack;
    FeedBack feedBack;
    DatabaseReference dbRef;
    Spinner category;

    String[]categories={"Select Category","Items","Payment","Service","Staff","Delivery"};


    private void Clear(){
        txtName.setText("");
        txtContactNo.setText("");

        txtMessage.setText("");
        txtEmail.setText("");

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_feedback, container, false);
        category= root.findViewById(R.id.categoryName);
        txtName = root.findViewById(R.id.RecipientName);
        txtEmail =root.findViewById(R.id.Email) ;
        txtMessage =root.findViewById(R.id.FeedbackMsg) ;
        txtContactNo =root.findViewById(R.id.contactNo2) ;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



       category.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
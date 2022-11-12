package com.example.my_grocery_app.ui.delivery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.my_grocery_app.R;
import com.example.my_grocery_app.databinding.FragmentDeliverytrackBinding;
import com.example.my_grocery_app.fragmentResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DeliveryTrackFragment extends Fragment {


    DatabaseReference dbRef;
    EditText Search;
    TextView id,name,mobile,address,date,driver,status,email;
    Button btnSearch;
    Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){


        View root = inflater.inflate(R.layout.fragment_deliverytrack, container, false);

        Search = root.findViewById(R.id.search);
        btnSearch =root.findViewById(R.id.btnSearch);
        mobile=root.findViewById(R.id.MobileNumber1Val);
        address=root.findViewById(R.id.address1Val);
        email=root.findViewById(R.id.Email2Val);
        driver=root.findViewById(R.id.deliveryPartner1Val);
        date=root.findViewById(R.id.orderDate1Val);
        name=root.findViewById(R.id.Name1Val);
        status=root.findViewById(R.id.orderStatus1Val);
        id=root.findViewById(R.id.orderID1Val);


           context = container.getContext();




        btnSearch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                //Toast.makeText(context, Search.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                dbRef = database.getReference().child("DeliveryDetails").child(Search.getText().toString().trim());
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                 @Override
                 public void onDataChange(@NonNull DataSnapshot snapshot) {

                     if (snapshot.hasChildren()) {
                         id.setText(snapshot.child("id").getValue().toString());
                         name.setText(snapshot.child("name").getValue().toString());
                         address.setText(snapshot.child("address").getValue().toString());
                         email.setText(snapshot.child("email").getValue().toString());
                         status.setText(snapshot.child("currentStatus").getValue().toString());
                         date.setText(snapshot.child("orderEstimateDate").getValue().toString());
                         driver.setText(snapshot.child("deliveryPartner").getValue().toString());
                         mobile.setText(snapshot.child("contactNo").getValue().toString());

                     } else {
                         Toast.makeText(context, "No record found", Toast.LENGTH_SHORT).show();
                     }

                 }

                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {

                 }
             }
                );
            }



        });
        return root;




    }





    public void onDestroyView() {
        super.onDestroyView();

    }


};
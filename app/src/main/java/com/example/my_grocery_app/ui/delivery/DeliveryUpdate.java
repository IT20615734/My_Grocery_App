package com.example.my_grocery_app.ui.delivery;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_grocery_app.R;

import java.util.HashMap;
import java.util.Map;

public class DeliveryUpdate extends AppCompatActivity {


    TextView orderID ;
    EditText estimateDate ;
    Spinner spinner1 ;
    Spinner spinner2 ;
    Button btnUpdate ;
    Button btnCancel ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_delivery);

        orderID = findViewById(R.id.orderID1Val);
        estimateDate = findViewById(R.id.orderEstimateDateVal);
        spinner1 = findViewById(R.id.setStatus);
        spinner2 = findViewById(R.id.setDeliveryPatner);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnCancel = findViewById(R.id.btnCancel);

        String[] status = {"Select Status", "Order Processing", "Out for delivery", "Delivered"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);


        Delivery delivery = null;
        orderID.setText(delivery.getID());
        estimateDate.setText(delivery.getOrderEstimateDate());


        btnUpdate.setOnClickListener(view ->{


            
                final String[] value = new String[1];
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        int position;
                        //value[0] = adapterView.getItemAtPosition(position).toString();
                        //Toast.makeText(this, status[position], Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


                Map<String, Object> map = new HashMap<>();
                map.put("orderEstimateDate", estimateDate.getText().toString());
                map.put("currentStatus", value[0]);

              //  String id = list.get(position).getID();
                /*FirebaseDatabase.getInstance().getReference().child("DeliveryDetails")
                        .child(id).updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(this, "Data Update Successfully", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //Toast.makeText(this, "Error while Updating Data", Toast.LENGTH_SHORT).show();

                            }
                        });*/

        });

    }

   
};

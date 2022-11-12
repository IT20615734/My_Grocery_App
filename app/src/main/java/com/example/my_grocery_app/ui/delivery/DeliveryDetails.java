package com.example.my_grocery_app.ui.delivery;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.my_grocery_app.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DeliveryDetails extends AppCompatActivity  {

    private Toolbar toolbar;

    EditText txtName, txtCity, txtEmail, txtContactNo, txtAddress, txtPostalCode, txtDeliveryInstructions;
    Delivery delivery;
    Button btnDelivery;
    DatabaseReference dbRef;



    private void Clear(){
        txtName.setText("");
        txtContactNo.setText("");
        txtAddress.setText("");
        txtDeliveryInstructions.setText("");
        txtEmail.setText("");
        txtPostalCode.setText("");
        txtCity.setText("");
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);

        toolbar = findViewById(R.id.bar);

        setSupportActionBar(toolbar);

        txtName = findViewById(R.id.Name);
        txtEmail = findViewById(R.id.Email);
        txtCity = findViewById(R.id.City);
        txtDeliveryInstructions = findViewById(R.id.DeliveryInstructions);
        txtAddress = findViewById(R.id.Address);
        txtContactNo = findViewById(R.id.ContactNumber);
        txtPostalCode = findViewById(R.id.PostalCode);
        btnDelivery= findViewById(R.id.btnDelivery);


        delivery = new Delivery();
        FirebaseDatabase database = FirebaseDatabase.getInstance();


        dbRef = database.getReference().child("DeliveryDetails");



        btnDelivery.setOnClickListener(view ->{

        try{
            if(TextUtils.isEmpty(txtName.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter your Name", Toast.LENGTH_SHORT).show();
            }

            else if(TextUtils.isEmpty(txtContactNo.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter your ContactNo", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(txtEmail.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter your Email", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(txtPostalCode.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter your PostalCode", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(txtCity.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter your City", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(txtAddress.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter your Address", Toast.LENGTH_SHORT).show();
            }
            else{

                delivery.setName(txtName.getText().toString().trim());
                delivery.setAddress(txtAddress.getText().toString().trim());
                delivery.setEmail(txtEmail.getText().toString().trim());
                delivery.setCity(txtCity.getText().toString().trim());
                delivery.setContactNo(Integer.parseInt(txtContactNo.getText().toString().trim()));
                delivery.setPostalCode(txtPostalCode.getText().toString().trim());
                delivery.setDeliveryInstructions(txtDeliveryInstructions.getText().toString().trim());
                String id=dbRef.push().getKey();
                delivery.setID(id);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date Date = new Date();
                String OrderPlacedDate = formatter.format(Date);
                delivery.setOrderPlacedDate(OrderPlacedDate);

                //calculate order estimate date
                Calendar c = Calendar.getInstance();
                c.setTime(Date);
                c.add(Calendar.DATE, 7);
                Date newDate = c.getTime();

                String EstimateDate = formatter.format(newDate) ;

                delivery.setOrderEstimateDate( EstimateDate);

                delivery.setDeliveryPartner("Not Assigned Yet");
                delivery.setCurrentStatus("Order Placed");

                delivery.status.put("Order Placed",OrderPlacedDate);


                //dbRef.push().setValue(delivery);
                dbRef.child(id).setValue(delivery);

                AlertDialog.Builder builder =new AlertDialog.Builder(this);
                builder.setTitle("You have successfully added your delivery");
                builder.setMessage("You can track your order using"+ id);
                builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {



                    }
                });



                builder.show();


                Toast.makeText(getApplicationContext(),"Send Data", Toast.LENGTH_SHORT).show();
                Clear();
            }
        }catch(NumberFormatException e){

            Toast.makeText(getApplicationContext(),"Invalid Contact Number", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
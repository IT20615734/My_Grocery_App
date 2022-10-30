package com.example.my_grocery_app.ui.delivery;



import com.google.firebase.database.IgnoreExtraProperties;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

@IgnoreExtraProperties
public class Delivery {


    private String ID;
    private String Name;
    private Integer ContactNo;
    private String Email;
    private String City;
    private String PostalCode;
    private String Address;
    private String DeliveryInstructions;

    private String OrderPlacedDate;
    private String OrderEstimateDate;
    private String CurrentStatus;
    private String DeliveryPartner;
    public HashMap<String, String> status = new HashMap<>() ;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDeliveryInstructions() {
        return DeliveryInstructions;
    }

    public void setDeliveryInstructions(String deliveryInstructions) {
        DeliveryInstructions = deliveryInstructions;
    }

    public Integer getContactNo() {
        return ContactNo;
    }

    public void setContactNo(Integer contactNo) {
        ContactNo = contactNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getOrderPlacedDate() {
        return OrderPlacedDate;
    }

    public void setOrderPlacedDate(String orderPlacedDate) {
        OrderPlacedDate = orderPlacedDate;
    }

    public String getOrderEstimateDate() {
        return OrderEstimateDate;
    }

    public void setOrderEstimateDate(String orderEstimateDate) {
        OrderEstimateDate = orderEstimateDate;
    }

    public String getCurrentStatus() {
        return CurrentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        CurrentStatus = currentStatus;
    }

    public String getDeliveryPartner() {
        return DeliveryPartner;
    }

    public void setDeliveryPartner(String deliveryPartner) {
        DeliveryPartner = deliveryPartner;
    }


}

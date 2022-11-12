package com.example.my_grocery_app.ui.feedback;

public class FeedBack {

    private String RecipientName;
    private Integer ContactNo;
    private String Category;
    private String Email;
    private String Message;
    private String Date;

    public FeedBack() {
    }

    public String getRecipientName() {
        return RecipientName;
    }

    public void setRecipientName(String recipientName) {
        RecipientName = recipientName;
    }

    public Integer getContactNo() {
        return ContactNo;
    }

    public void setContactNo(Integer contactNo) {
        ContactNo = contactNo;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}

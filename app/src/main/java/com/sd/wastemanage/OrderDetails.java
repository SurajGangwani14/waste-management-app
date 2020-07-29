package com.sd.wastemanage;

public class OrderDetails {
    private String FirstName;
    private String LastName;
    private String Add;
    private String Contact;
    private String pincode;
    private String email;
    private String state;
    private String city;
    private String price;
    private String details;
    private String totalitem;

    @Override
    public String toString() {
        return "OrderDetails{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Add='" + Add + '\'' +
                ", Contact='" + Contact + '\'' +
                ", pincode='" + pincode + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", price='" + price + '\'' +
                ", details='" + details + '\'' +
                ", totalitem='" + totalitem + '\'' +
                '}';
    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String add) {
        Add = add;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTotalitem() {
        return totalitem;
    }

    public void setTotalitem(String totalitem) {
        this.totalitem = totalitem;
    }


    public OrderDetails(String firstName, String lastName, String add, String contact, String pincode, String email, String state, String city, String price, String details, String totalitem) {
        FirstName = firstName;
        LastName = lastName;
        Add = add;
        Contact = contact;
        this.pincode = pincode;
        this.email = email;
        this.state = state;
        this.city = city;
        this.price = price;
        this.details = details;
        this.totalitem = totalitem;
    }
    public OrderDetails(){}
    public OrderDetails(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }
}

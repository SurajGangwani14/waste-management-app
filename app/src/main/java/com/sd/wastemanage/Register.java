package com.sd.wastemanage;

public class Register {
    private String FirstName;
    private String LastName;
    private String EmailAdd;
    private String Contact;
    private String Password;
    private String ConfirmPass;


    public String getFirstName() {
        return FirstName;
    }

    @Override
    public String toString() {
        return "Register{" +
                "FirstName='" + FirstName +
                ", LastName='" + LastName +
                ", EmailAdd='" + EmailAdd +
                ", Contact='" + Contact +
                ", Password='" + Password +
                ", ConfirmPass='" + ConfirmPass +
                '}';
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

    public String getEmailAdd() {
        return EmailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        EmailAdd = emailAdd;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmPass() {
        return ConfirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        ConfirmPass = confirmPass;
    }

    public Register(String firstName, String lastName, String emailAdd, String contact, String password, String confirmPass) {
        FirstName = firstName;
        LastName = lastName;
        EmailAdd = emailAdd;
        Contact = contact;
        Password = password;
        ConfirmPass = confirmPass;
    }
    public Register(){}
}

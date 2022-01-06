package com.example.myproject2;

public class user_data {

    String name , mobileNo , Email , password ;

    public user_data() {
    }

    public user_data(String name, String mobileNo,String Email, String password) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.password = password;
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.fluntoo.zenberry.Model;

public class InVoice {
    String firstname;
    String lastname;
    String email;
    String mobileno;
    String userid;
    String address1;
    String address2;
    String pincode;
    String gstno;
    String country;
    String state;
    String city;
    String couponcode;
    String pAmount;
    String finalAmount;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getGstno() {
        return gstno;
    }

    public void setGstno(String gstno) {
        this.gstno = gstno;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getCouponcode() {
        return couponcode;
    }

    public void setCouponcode(String couponcode) {
        this.couponcode = couponcode;
    }

    public String getpAmount() {
        return pAmount;
    }

    public void setpAmount(String pAmount) {
        this.pAmount = pAmount;
    }

    public String getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(String finalAmount) {
        this.finalAmount = finalAmount;
    }

    public InVoice(String firstname, String lastname, String email, String mobileno, String userid, String address1, String address2, String pincode, String gstno, String country, String state, String city, String couponcode, String pAmount, String finalAmount) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobileno = mobileno;
        this.userid = userid;
        this.address1 = address1;
        this.address2 = address2;
        this.pincode = pincode;
        this.gstno = gstno;
        this.country = country;
        this.state = state;
        this.city = city;
        this.couponcode = couponcode;
        this.pAmount = pAmount;
        this.finalAmount = finalAmount;
    }
}

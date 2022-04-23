package com.fluntoo.zenberry.Model;

public class ForgetPassNew {

    String mobileno;
    String password;

    public ForgetPassNew(String mobileno, String password) {
        this.mobileno = mobileno;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateOrder {

    String Amount;
    String Title;
    String orderId;

    public CreateOrder(String amount, String title, String orderId) {
        Amount = amount;
        Title = title;
        this.orderId = orderId;
    }
    //    public CreateOrder() {
//        Amount = amount;
//        Title = title;
//        this.orderId = orderId;
//    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "CreateOrder{" +
                "Amount='" + Amount + '\'' +
                ", Title='" + Title + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}

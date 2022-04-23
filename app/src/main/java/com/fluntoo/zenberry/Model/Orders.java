package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Orders {

  Integer amount;
  String currency;
  String receipt;
  Integer payment_capture;
  String id;
  String status;

    public Orders(Integer amount, String currency, String receipt, Integer payment_capture, String id,String status) {
        this.amount = amount;
        this.currency = currency;
        this.receipt = receipt;
        this.payment_capture = payment_capture;
        this.id = id;
        this.status=status;
    }

    public Orders(Integer amount, String currency, String receipt, Integer payment_capture) {
        this.amount = amount;
        this.currency = currency;
        this.receipt = receipt;
        this.payment_capture = payment_capture;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Integer getPayment_capture() {
        return payment_capture;
    }

    public void setPayment_capture(Integer payment_capture) {
        this.payment_capture = payment_capture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

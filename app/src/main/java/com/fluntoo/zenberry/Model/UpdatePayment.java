package com.fluntoo.zenberry.Model;

public class UpdatePayment {
    String PaymentId;
    String status;

    public UpdatePayment(String paymentId, String status) {
        PaymentId = paymentId;
        this.status = status;
    }

    public String getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(String paymentId) {
        PaymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

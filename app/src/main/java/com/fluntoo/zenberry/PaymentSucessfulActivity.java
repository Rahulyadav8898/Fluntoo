package com.fluntoo.zenberry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentSucessfulActivity extends AppCompatActivity {
    Button btn;
    String order, pay;
    TextView txtoder,txtpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_sucessful);
        btn = findViewById(R.id.btnsuccess);
        txtoder=findViewById(R.id.textView19);
        txtpay=findViewById(R.id.textView18);


        Intent intent = getIntent();
         order = intent.getStringExtra("order");
        pay = intent.getStringExtra("pay");
        intent.getStringExtra("pay");

        txtpay.setText("Your Payment Id: "+pay);
        txtoder.setText("Your Order Id: "+order);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


    }
}
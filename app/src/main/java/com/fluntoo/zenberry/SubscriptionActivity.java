package com.fluntoo.zenberry;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.fluntoo.zenberry.ApIInterface.CreateOrderInterface;
import com.fluntoo.zenberry.ApIInterface.UpdatePaymentInterface;
import com.fluntoo.zenberry.Model.CreateOrder;
import com.fluntoo.zenberry.Model.UpdatePayment;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubscriptionActivity extends AppCompatActivity implements PaymentResultWithDataListener {
    Button btnpay;

    Integer amount = 9900;
    String currency = "INR";
    String receipt = "Receipt no. 1";
    Integer payment_capture = 1;

    String Amount = "99";
    String Title = "starter";

    String pay;

//    String username = "rzp_test_HbS1PVcQNKiBic";
//    String pass = "0PsLnYXzdATSzKBikTZZ1LoR";

    //    String status;
    String phoneno;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    String orderid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);
        btnpay = findViewById(R.id.pay_btn);

//        createorder();
//        getorder();

//        String samount = "99";
//        int amount = Math.round(Float.parseFloat(samount) * 100);

        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//

//                String orderid=getorder();
                String orderid = createorder();

                Checkout.preload(getApplicationContext());


            }
        });
    }

    private String createorder() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
        Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://www.api.playflixx.com/create_order/" + user;
        Log.i("end", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CreateOrderInterface createOrderInterface = retrofit.create(CreateOrderInterface.class);
        Call<CreateOrder> call = createOrderInterface.createorder(Url,
                Amount, Title);
        call.enqueue(new Callback<CreateOrder>() {
            @Override
            public void onResponse(Call<CreateOrder> call, Response<CreateOrder> response) {

                orderid = response.body().getOrderId();
                Log.d("id", orderid);
//
                Toast.makeText(getApplicationContext(), orderid, Toast.LENGTH_SHORT).show();
                getpayment();

            }

            @Override
            public void onFailure(Call<CreateOrder> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        return orderid;
    }


//    private String getorder() {
//        String Url1 = "https://api.razorpay.com/v1/orders";
//        Log.d("url", Url1);
//        String baseAuthStr = username + ":" + pass;
//        String authString = "Basic " + Base64.encodeToString((username + ":" + pass).getBytes(), Base64.NO_WRAP);
////
//        Retrofit retrofit = new Retrofit.Builder().
//                baseUrl("https://api.razorpay.com/v1/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        OrderInterface orderInterface = retrofit.create(OrderInterface.class);
//        Orders orders = new Orders(amount, currency, receipt, payment_capture);
//        Call<Orders> call = orderInterface.getoder(authString, orders);
//        Log.d("deb", call.toString());
//        call.enqueue(new Callback<Orders>() {
//            @Override
//            public void onResponse(Call<Orders> call, Response<Orders> response) {
//                orderid = response.body().getId();
//                Log.d("id", response.toString());
//                Toast.makeText(getApplicationContext(), response.body().getId(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), response.body().getStatus(), Toast.LENGTH_SHORT).show();
//                getpayment();
//            }
//            @Override
//            public void onFailure(Call<Orders> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.d("er", t.getMessage());
//            }
//        });
//        return orderid;
//    }

    private void getpayment() {
        Checkout checkout = new Checkout();

//        checkout.setKeyID("rzp_test_HbS1PVcQNKiBic");
        checkout.setKeyID("rzp_live_jtANiO0TFRoWa3");
//
        checkout.setImage(R.drawable.app_icon);
        try {

            JSONObject options = new JSONObject();

            options.put("name", "Fluntoo");
//                    options.put("description", "Reference No. #123456");
//                    options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("order_id", orderid);//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", amount);//pass amount in currency subunits
//                    options.put("prefill.email", "gaurav.kumar@example.com");
//                    options.put("prefill.contact",phoneno);
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);
//
            checkout.open(SubscriptionActivity.this, options);


        } catch (Exception e) {
            Log.e("Tag", "Error in starting Razorpay Checkout", e);
            Toast.makeText(getApplicationContext(), "Error in starting Razorpay Checkout", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        try {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Payment ID");
            alertDialog.setMessage(s);
            alertDialog.show();

//            Toast.makeText(getApplicationContext(),paymentData.getPaymentId(),Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), paymentData.getOrderId(), Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), paymentData.getSignature(), Toast.LENGTH_SHORT).show();

//            String order=paymentData.getOrderId();
            pay = paymentData.getPaymentId();
//            Log.d("zz",pay);


            Log.d("rt", paymentData.getOrderId());
            Log.d("rt", paymentData.getPaymentId());
            Log.d("rt", paymentData.getSignature());

            SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);

            String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
            String user = prefs.getString("userId", "no vale");
            Toast.makeText(getApplicationContext(), user, Toast.LENGTH_SHORT).show();

            String paymentId = paymentData.getPaymentId();
            Log.d("zz", pay);

            String falseoderid = "order_ICMA94TDraaToc";
            String order = paymentData.getOrderId();

            String status = "captured";


            String Url1 = "https://www.api.playflixx.com/UpdatePayment/" + order;
//                String Url1 = "https://www.api.playflixx.com/UpdatePayment/" +orderid;
            Log.d("url1", Url1);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.api.playflixx.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            UpdatePaymentInterface updatePaymentInterface = retrofit.create(UpdatePaymentInterface.class);
            Call<UpdatePayment> call = updatePaymentInterface.updatepayment(Url1, "Bearer " + name, paymentId, "captured");
            call.enqueue(new Callback<UpdatePayment>() {
                @Override
                public void onResponse(Call<UpdatePayment> call, Response<UpdatePayment> response) {
                    Log.d("pay", response.toString());
                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<UpdatePayment> call, Throwable t) {
                    Log.d("pay", t.toString());
                    Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();

                }
            });


//

//            Toast.makeText(getApplicationContext(),paymentData.getSignature(),Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("ex", e.toString());

        }

//
    }

    private void update() {


    }


    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        Log.d("tag", s);
    }


//    order_ICJn21lz37JF4p
//    pay_ICJnZVRulhfjJp
//    bb5c7be2fa6c5dc84bb4e0c83e444fcb3e1b2b9d8d8c28a5e8387507a77d21bb

}
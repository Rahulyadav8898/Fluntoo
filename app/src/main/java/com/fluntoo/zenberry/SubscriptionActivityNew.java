package com.fluntoo.zenberry;

import android.content.DialogInterface;
import android.content.Intent;
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

public class SubscriptionActivityNew extends AppCompatActivity implements PaymentResultWithDataListener {
    Button btnpay;

    Integer amount = 9900;
    String currency = "INR";
    String receipt = "Receipt no. 1";
    Integer payment_capture = 1;

    String Amount = "99";
    String Title = "starter";

    String pay;


    Button btnpay2;

    Integer amount2 = 59900;
//    String currency = "INR";
//    String receipt = "Receipt no. 1";
//    Integer payment_capture = 1;

    String Amount2 = "599";
    String Title2 = "vip";


    String pay2;

    Button btnpay3;

    Integer amount3 = 119900;
//    String currency = "INR";
//    String receipt = "Receipt no. 1";
//    Integer payment_capture = 1;

    String Amount3 = "1199";
    String Title3 = "premium";


//    String username = "rzp_test_HbS1PVcQNKiBic";
//    String pass = "0PsLnYXzdATSzKBikTZZ1LoR";

    //    String status;
    String phoneno;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    String orderid;

    Boolean isLogin = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription_new);

        btnpay = findViewById(R.id.pay_btn1);
        btnpay2 = findViewById(R.id.pay_vip_btn2);
        btnpay3 = findViewById(R.id.pay_premium_btn3);


        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {
//                    Checkout.preload(getApplicationContext());
                    Intent intent = new Intent(getApplicationContext(), BillingAddressActivity.class);
                    intent.putExtra("packname", "Starter");
                    intent.putExtra("packprice", "99");
                    startActivity(intent);

//                    have to uncomment
//                    String orderid = createorder();
//                    Checkout.preload(getApplicationContext());

                } else {
//                    Toast.makeText(getApplicationContext(), "You are not logged in !!", Toast.LENGTH_SHORT).show();

                    AlertDialog alertDialog = new AlertDialog.Builder(SubscriptionActivityNew.this)
//set icon
                            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                            .setTitle("Please Log In")
//set message
                            .setMessage("You are not Logged In !!")
//set positive button
                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    startActivity(new Intent(getApplicationContext(), LoginActivityNew.class));

                                }
                            })
//set negative button
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
//                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();

                }
//                String orderid=getorder();


            }
        });

        btnpay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//

                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {


                    Intent intent = new Intent(getApplicationContext(), BillingAddressActivity.class);
                    intent.putExtra("packname", "Vip");
                    intent.putExtra("packprice", "599");
                    startActivity(intent);

//                    String orderid = createorder2();
////
//                    Checkout.preload(getApplicationContext());
                } else {
//                    Toast.makeText(getApplicationContext(), "You are not logged in !!", Toast.LENGTH_SHORT).show();

                    AlertDialog alertDialog = new AlertDialog.Builder(SubscriptionActivityNew.this)
//set icon
                            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                            .setTitle("Please Log In")
//set message
                            .setMessage("You are not Logged In !!")
//set positive button
                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    startActivity(new Intent(getApplicationContext(), LoginActivityNew.class));

                                }
                            })
//set negative button
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
//                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();

                }
//                String orderid=getorder();


            }
        });


        btnpay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//

                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
                isLogin = prefs.getBoolean("isLogin", false);
                if (isLogin) {

                    Intent intent = new Intent(getApplicationContext(), BillingAddressActivity.class);
                    intent.putExtra("packname", "Premium");
                    intent.putExtra("packprice", "1199");
                    startActivity(intent);

//                    String orderid = createorder3();

//                    Checkout.preload(getApplicationContext());
                } else {
//                    Toast.makeText(getApplicationContext(), "You are not logged in !!", Toast.LENGTH_SHORT).show();

                    AlertDialog alertDialog = new AlertDialog.Builder(SubscriptionActivityNew.this)
//set icon
                            .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                            .setTitle("Please Log In")
//set message
                            .setMessage("You are not Logged In !!")
//set positive button
                            .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    startActivity(new Intent(getApplicationContext(), LoginActivityNew.class));

                                }
                            })
//set negative button
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
//                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();

                }
//                String orderid=getorder();


            }
        });


    }

    private String createorder() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/purchase/create_order/" + user;
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
//                Toast.makeText(getContext(), orderid, Toast.LENGTH_SHORT).show();
                getpayment();

            }

            @Override
            public void onFailure(Call<CreateOrder> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        return orderid;
    }

    private String createorder3() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/purchase/create_order/" + user;
        Log.i("end", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CreateOrderInterface createOrderInterface = retrofit.create(CreateOrderInterface.class);
        Call<CreateOrder> call = createOrderInterface.createorder(Url,
                Amount3, Title3);
        call.enqueue(new Callback<CreateOrder>() {
            @Override
            public void onResponse(Call<CreateOrder> call, Response<CreateOrder> response) {

                orderid = response.body().getOrderId();
                Log.d("id", orderid);
//
//                Toast.makeText(getContext(), orderid, Toast.LENGTH_SHORT).show();
                getpayment3();

            }

            @Override
            public void onFailure(Call<CreateOrder> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        return orderid;
    }

    private String createorder2() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/purchase/create_order/" + user;
        Log.i("end", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CreateOrderInterface createOrderInterface = retrofit.create(CreateOrderInterface.class);
        Call<CreateOrder> call = createOrderInterface.createorder(Url,
                Amount2, Title2);
        call.enqueue(new Callback<CreateOrder>() {
            @Override
            public void onResponse(Call<CreateOrder> call, Response<CreateOrder> response) {

                orderid = response.body().getOrderId();
                Log.d("id", orderid);
//
//                Toast.makeText(getContext(), orderid, Toast.LENGTH_SHORT).show();
                getpayment2();

            }

            @Override
            public void onFailure(Call<CreateOrder> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        return orderid;
    }


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
            checkout.open(SubscriptionActivityNew.this, options);


        } catch (Exception e) {
            Log.e("Tag", "Error in starting Razorpay Checkout", e);
            Toast.makeText(getApplicationContext(), "Error in starting Razorpay Checkout", Toast.LENGTH_SHORT).show();
        }

    }

    private void getpayment2() {
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
            options.put("amount", amount2);//pass amount in currency subunits
//                    options.put("prefill.email", "gaurav.kumar@example.com");
//                    options.put("prefill.contact",phoneno);
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);
//
            checkout.open(SubscriptionActivityNew.this, options);


        } catch (Exception e) {
            Log.e("Tag", "Error in starting Razorpay Checkout", e);
            Toast.makeText(getApplicationContext(), "Error in starting Razorpay Checkout", Toast.LENGTH_SHORT).show();
        }

    }

    private void getpayment3() {
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
            options.put("amount", amount3);//pass amount in currency subunits
//                    options.put("prefill.email", "gaurav.kumar@example.com");
//                    options.put("prefill.contact",phoneno);
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);
//
            checkout.open(SubscriptionActivityNew.this, options);


        } catch (Exception e) {
            Log.e("Tag", "Error in starting Razorpay Checkout", e);
            Toast.makeText(getApplicationContext(), "Error in starting Razorpay Checkout", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        try {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(SubscriptionActivityNew.this);
            alertDialog.setTitle("Payment ID");
            alertDialog.setMessage(s);
            alertDialog.show();

//            Toast.makeText(getApplicationContext(),paymentData.getPaymentId(),Toast.LENGTH_SHORT).show();
//            Toast.makeText(getContext(), paymentData.getOrderId(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(getContext(), paymentData.getSignature(), Toast.LENGTH_SHORT).show();

//            String order=paymentData.getOrderId();
            pay = paymentData.getPaymentId();
//            Log.d("zz",pay);


            Log.d("rt", paymentData.getOrderId());
            Log.d("rt", paymentData.getPaymentId());
            Log.d("rt", paymentData.getSignature());

            SharedPreferences prefs = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, 0);

            String name = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
            String user = prefs.getString("userId", "no vale");
//            Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

            String paymentId = paymentData.getPaymentId();
            Log.d("zz", pay);

            String falseoderid = "order_ICMA94TDraaToc";
            String order = paymentData.getOrderId();

            String status = "captured";


            String Url1 = "https://api.fluntoo.com/purchase/UpdatePayment/" + order;
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
//                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<UpdatePayment> call, Throwable t) {
                    Log.d("pay", t.toString());
//                    Toast.makeText(getContext(), t.toString(), Toast.LENGTH_LONG).show();
//                    startActivity(new Intent(getApplicationContext(), PaymentSucessfulActivity.class));

                    Intent intent = new Intent(getApplicationContext(), PaymentSucessfulActivity.class);
                    intent.putExtra("order", order);
                    intent.putExtra("pay", paymentId);
                    startActivity(intent);


                }
            });


//

//            Toast.makeText(getApplicationContext(),paymentData.getSignature(),Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
//            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("ex", e.toString());

        }
    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        Log.d("tag", s);

    }
}


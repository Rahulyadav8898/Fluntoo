package com.fluntoo.zenberry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.fluntoo.zenberry.ApIInterface.BillingInterface;
import com.fluntoo.zenberry.ApIInterface.CreateOrderInterface;
import com.fluntoo.zenberry.ApIInterface.UpdatePaymentInterface;
import com.fluntoo.zenberry.Model.CreateOrder;
import com.fluntoo.zenberry.Model.InVoice;
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

public class BillingAddressActivity extends AppCompatActivity implements PaymentResultWithDataListener {
    EditText nameedt, lastnameedt, phoneedt, emailedt, addedt, pincodeedt, gstedt, couponedt;
    EditText countryedt, stateedt, cityedt;
    TextView packtxt, packprice;
    String name, lname, pn, email, add, pin, gst, coupon, country, state, city, pp, pt;

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    Button btn;

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

    String orderid;

    Boolean isLogin = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing_address);

        btn = findViewById(R.id.paybtn3);
        nameedt = findViewById(R.id.editTextTextPersonName);
        lastnameedt = findViewById(R.id.editTextTextPersonName2);
        phoneedt = findViewById(R.id.editTextPhone);
        emailedt = findViewById(R.id.editTextTextEmailAddress);
        addedt = findViewById(R.id.editTextTextPersonName3);
        pincodeedt = findViewById(R.id.editTextNumberPassword);
        gstedt = findViewById(R.id.editTextTextPersonName4);
        countryedt = findViewById(R.id.countryspinner);
        stateedt = findViewById(R.id.statespinner);
        cityedt = findViewById(R.id.cityspinner);
        couponedt = findViewById(R.id.coupon_edt);
        packtxt = findViewById(R.id.packid);
        packprice = findViewById(R.id.packprice);

        Intent intent = getIntent();
        pt = intent.getStringExtra("packname");
        pp = intent.getStringExtra("packprice");

        packtxt.setText(pt);
        packprice.setText(pp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post();
            }
        });


//        String Url = "https://raw.githubusercontent.com/dr5hn/countries-states-cities-database/master/countries%2Bstates%2Bcities.json";
//        Log.d("link", Url);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        CountryINterface countryINterface = retrofit.create(CountryINterface.class);
//        Call<List<CountryList>> call = countryINterface.countrypick(Url);
//        call.enqueue(new Callback<List<CountryList>>() {
//            @Override
//            public void onResponse(Call<List<CountryList>> call, Response<List<CountryList>> response) {
//                Log.d("TAG", "onResponse: " + response.body().get(0).getStates().toString());
//                ArrayList<String> nameListch = new ArrayList<>();
//                ArrayList<String> statelist = new ArrayList<>();
////                 getresponse=response.body().toString();
//                for (int i = 0; i < response.body().size(); i++) {
////
//                    nameListch.add(response.body().get(i).getName());
////                    statelist.add(response.body().)
//
////
//                }
//
//                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
//                        android.R.layout.simple_spinner_dropdown_item, nameListch);
//                countryedt.setAdapter(adapter);
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<CountryList>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        countryedt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> arg0, View arg1,
//                                       int arg2, long arg3) {
//                category = countryedt.getSelectedItem().toString();
//                Log.d("hm", category);
//
//
////                Toast.makeText(getApplicationContext(), channel, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//                category = countryedt.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(), category, Toast.LENGTH_LONG).show();
//                Log.d("hm", category);
//
//
////
//
//            }
//
//
//        });


    }

    private void post() {

        name = nameedt.getText().toString();
        lname = lastnameedt.getText().toString();
        pn = phoneedt.getText().toString();
        email = emailedt.getText().toString();
        add = addedt.getText().toString();
        pin = pincodeedt.getText().toString();
        gst = gstedt.getText().toString();
        country = countryedt.getText().toString();
        state = stateedt.getText().toString();
        city = cityedt.getText().toString();
        coupon = couponedt.getText().toString();


        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);

        String name2 = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
        String user = prefs.getString("userId", "no vale");
//        Toast.makeText(getContext(), user, Toast.LENGTH_SHORT).show();

        String Url = "https://api.fluntoo.com/purchase/order/addinvoice";
        Log.i("end", Url);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.api.playflixx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BillingInterface billingInterface = retrofit.create(BillingInterface.class);
        Call<InVoice> call = billingInterface.postvoice(Url, name, lname, email, pn, user, add, add, pin, gst, country, state, city, coupon, pp, pp);
        call.enqueue(new Callback<InVoice>() {
            @Override
            public void onResponse(Call<InVoice> call, Response<InVoice> response) {
//                Log.d("error", response.toString());
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<InVoice> call, Throwable t) {
                Log.d("error", t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                orderid = createorder();


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
                pp, pt);
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
            options.put("amount", pp);//pass amount in currency subunits
//                    options.put("prefill.email", "gaurav.kumar@example.com");
//                    options.put("prefill.contact",phoneno);
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);
//
            checkout.open(BillingAddressActivity.this, options);


        } catch (Exception e) {
            Log.e("Tag", "Error in starting Razorpay Checkout", e);
            Toast.makeText(getApplicationContext(), "Error in starting Razorpay Checkout", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        try {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(BillingAddressActivity.this);
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
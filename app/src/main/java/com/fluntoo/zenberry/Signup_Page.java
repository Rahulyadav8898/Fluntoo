package com.fluntoo.zenberry;

import static com.fluntoo.zenberry.Login_Page.MY_PREFS_NAME;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.fluntoo.zenberry.ApIInterface.OurRetrofit;
import com.fluntoo.zenberry.ApIInterface.OurRetrofitLogin;
import com.fluntoo.zenberry.Model.OurDataSet;
import com.fluntoo.zenberry.Model.OurDataSetLogin;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.example.playflix.R;

public class Signup_Page extends AppCompatActivity {
    EditText e1, e2, e3, e4, e5;
    String userName, userMail, userPhonenumber, userPassword, userConfirmPassword;
    TextView tres;
    String registrationType = "register";
    ConstraintLayout layout;
    ImageView maleimg, femaleimg, otherimg;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String radio;
    Button btnreg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        e1 = findViewById(R.id.userName);
        e2 = findViewById(R.id.userMail);
        e3 = findViewById(R.id.userPhonenumber);
        e4 = findViewById(R.id.userPassword);
        e5 = findViewById(R.id.userConfirmPassword);
        layout = findViewById(R.id.main);
        maleimg = findViewById(R.id.male_img);
        femaleimg = findViewById(R.id.female_img);
        otherimg = findViewById(R.id.others_img);
        btnreg = findViewById(R.id.btnreg);


        radioGroup = findViewById(R.id.radio_group);


        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostData();
            }
        });

//        tres = findViewById(R.id.response);


//        maleimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                femaleimg.setVisibility(View.INVISIBLE);
//                otherimg.setVisibility(View.INVISIBLE);
////                Toast.makeText(getApplicationContext(), "male is selected", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        femaleimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                maleimg.setVisibility(View.INVISIBLE);
//                otherimg.setVisibility(View.INVISIBLE);
////                Toast.makeText(getApplicationContext(), "female is selected", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        otherimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                femaleimg.setVisibility(View.INVISIBLE);
//                maleimg.setVisibility(View.INVISIBLE);
////                Toast.makeText(getApplicationContext(), "Other is selected", Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
//        Toast.makeText(getApplicationContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();

    }


    public void PostData() {
        btnreg.setClickable(false);
        btnreg.setEnabled(false);
        userName = e1.getText().toString();
        userMail = e2.getText().toString();
        userPhonenumber = e3.getText().toString();
        userPassword = e4.getText().toString();
        userConfirmPassword = e5.getText().toString();
        radio = radioButton.getText().toString();


        if (userMail.isEmpty() || userPassword.isEmpty() || userPhonenumber.isEmpty() || userName.isEmpty() || userConfirmPassword.isEmpty()) {

            Toast.makeText(getApplicationContext(), "please fill above fields", Toast.LENGTH_SHORT).show();
        } else {
            if (userConfirmPassword.equals(userPassword)) {

                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.api.playflixx.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

                OurDataSet ourDataSet = new OurDataSet(userName, userMail, userPhonenumber, userPassword, registrationType, radio);
                Call<OurDataSet> call = ourRetrofit.PostData(ourDataSet);

                call.enqueue(new Callback<OurDataSet>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(Call<OurDataSet> call, Response<OurDataSet> response) {

//                    Toast.makeText(getApplicationContext(), "Signup failed", Toast.LENGTH_SHORT).show();
//                    tres.setText(response.body().getJson().getUserName() + " " + response.body().getJson().getUserMail() + " " + response.body().getJson().getUserPhonenumber() + " " + response.body().getJson().getUserPassword());
//                    finish();

                        Snackbar snackbar = Snackbar
                                .make(layout, response.toString(), Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }

                    @Override
                    public void onFailure(Call<OurDataSet> call, Throwable t) {
//                    tres.setText("connection failed");


//                    Toast.makeText(getApplicationContext(), "sucessful", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getApplicationContext(), Login_Page.class));
                        Snackbar snackbar = Snackbar
                                .make(layout, "sucessfully signed up", Snackbar.LENGTH_SHORT);
//                        snackbar.setAction("OK", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//
//                                startActivity(new Intent(getApplicationContext(), Login_Page.class));
//                            }
//                        })
//                                .setActionTextColor(Color.RED);
//                        snackbar.show();

//                        login here auto


                        userMail = e2.getText().toString();
                        userPassword = e4.getText().toString();
                        String loginType = "register";


                        if (userMail.isEmpty() || userPassword.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "please fill above fields", Toast.LENGTH_SHORT).show();
                        } else {
                            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.api.playflixx.com")
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
                            OurRetrofitLogin ourRetrofitLogin = retrofit.create(OurRetrofitLogin.class);
                            OurDataSetLogin ourDataSetLogin = new OurDataSetLogin(userMail,  loginType);
                            Call<OurDataSetLogin> call2 = ourRetrofitLogin.PostLogin(ourDataSetLogin);

                            call2.enqueue(new Callback<OurDataSetLogin>() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onResponse(Call<OurDataSetLogin> call, Response<OurDataSetLogin> response) {

//                    lres.setText(response.body().getJson().getUserMail()+" "+response.body().getJson().getUserPassword());
                                    if (response.isSuccessful()) {
//
                                        String token = response.body().getToken();
                                        String userid = response.body().getUserId();
//                        getuserid();


                                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                                        editor.putString("tokenid", token);
                                        editor.putString("userId", userid);
                                        editor.putBoolean("isLogin", true);
                                        editor.apply();

                                        Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();

//                        Toast.makeText(getApplicationContext(),token,Toast.LENGTH_SHORT).show();


                                        Intent intent = new Intent(getApplicationContext(), SignupVerificationActivity.class);
//                       intent.putExtra("userid",userid.toString());
                                        startActivity(intent);
//                        getLocation();


                                    } else {
                                        Snackbar snackbar = Snackbar
                                                .make(layout, "Succesfully Logged In", Snackbar.LENGTH_LONG);
                                        snackbar.show();

//                        Toast.makeText(getApplicationContext(), "email or password is incoorect", Toast.LENGTH_SHORT).show();
                                    }


                                }

                                @Override
                                public void onFailure(Call<OurDataSetLogin> call, Throwable t) {
//                lres.setText("connection failed");
//                    Toast.makeText(getApplicationContext(), "email or password is incorrect", Toast.LENGTH_SHORT).show();
                                    Snackbar snackbar = Snackbar
                                            .make(layout, "email or password is incorrect", Snackbar.LENGTH_LONG);
                                    snackbar.show();
                                }
                            });


                        }
                    }
                });
            } else {
                Snackbar snackbar = Snackbar.make(layout, "Password and Confirm Password sholud be same", Snackbar.LENGTH_SHORT);
                snackbar.show();

//                Toast.makeText(getApplicationContext(), "Password and Confirm Password sholud be same", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

package com.fluntoo.zenberry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fluntoo.zenberry.ApIInterface.VerificationOtpINterface;
import com.fluntoo.zenberry.Model.OtpVerify;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupVerificationActivity extends AppCompatActivity {
    EditText edt;
    Button resendbtn, verifybtn;
    String e, em;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_verification);
        edt = findViewById(R.id.verify_otp_signup_edt);
        resendbtn = findViewById(R.id.resend_otp_btn);
        verifybtn = findViewById(R.id.verify_otp_btn);
        textView = findViewById(R.id.clock);


        clock();

        resendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e = edt.getText().toString().trim();


                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
                String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
                String user = prefs.getString("userId", "no value");


                String url = "https://www.api.playflixx.com/ResendOTP/" + user;
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.api.playflixx.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                VerificationOtpINterface verificationOtpINterface = retrofit.create(VerificationOtpINterface.class);
                Call<OtpVerify> call = verificationOtpINterface.resendotp(url);
                call.enqueue(new Callback<OtpVerify>() {
                    @Override
                    public void onResponse(Call<OtpVerify> call, Response<OtpVerify> response) {
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<OtpVerify> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Otp Sent", Toast.LENGTH_SHORT).show();
                        clock();

                    }
                });
            }

        });

        verifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                em = edt.getText().toString().trim();
                if (em.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter Otp", Toast.LENGTH_SHORT).show();
                } else {

                    SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
                    String token = prefs.getString("tokenid", "No name defined");//"No name defined" is the default value.
                    String user = prefs.getString("userId", "no value");

                    String url = "https://www.api.playflixx.com/Verify/" + user;

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://www.api.playflixx.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    VerificationOtpINterface verificationOtpINterface = retrofit.create(VerificationOtpINterface.class);
                    Call<OtpVerify> call = verificationOtpINterface.postotp(url, em);
                    call.enqueue(new Callback<OtpVerify>() {
                        @Override
                        public void onResponse(Call<OtpVerify> call, Response<OtpVerify> response) {
                            Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<OtpVerify> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        }
                    });
                }
            }

        });


    }

    private void clock() {
        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                resendbtn.setVisibility(View.INVISIBLE);
                NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                textView.setText(f.format(min) + ":" + f.format(sec) + " seconds");
            }

            // When the task is over it will print 00:00:00 there
            public void onFinish() {
                textView.setText("Otp Expired!");
                resendbtn.setVisibility(View.VISIBLE);

            }
        }.start();

    }
}
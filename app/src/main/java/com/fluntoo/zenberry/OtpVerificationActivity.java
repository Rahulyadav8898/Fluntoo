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

import androidx.appcompat.app.AppCompatActivity;

import com.fluntoo.zenberry.ApIInterface.OTPverificationINterface;
import com.fluntoo.zenberry.Model.OtpVerification;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OtpVerificationActivity extends AppCompatActivity {
    public static final String MY_PREFS_NAME1 = "MyPrefsFile1";
    EditText otp_edt;
    EditText newpass_edt;
    Button confirmbtn;
    String otp, pass;
    TextView signuptv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        otp_edt = findViewById(R.id.otp_edtt);
        newpass_edt = findViewById(R.id.newpass_edtt);
        confirmbtn = findViewById(R.id.confirm_btn);


        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otp = otp_edt.getText().toString();
                pass = newpass_edt.getText().toString();

                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME1, 0);
                String verifyuser = prefs.getString("userId1", "no value");
                Toast.makeText(getApplicationContext(), verifyuser, Toast.LENGTH_SHORT).show();

                String url = "https://www.api.playflixx.com/reset-password/" + verifyuser;
                Log.d("url", url);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.api.playflixx.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                OTPverificationINterface otPverificationINterface = retrofit.create(OTPverificationINterface.class);
                Call<OtpVerification> call = otPverificationINterface.putverify(url, otp, pass);
                call.enqueue(new Callback<OtpVerification>() {
                    @Override
                    public void onResponse(Call<OtpVerification> call, Response<OtpVerification> response) {
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                        Log.d("res", response.toString());
                    }

                    @Override
                    public void onFailure(Call<OtpVerification> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), "password changed succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Login_Page.class));
                    }
                });


            }
        });


    }
}
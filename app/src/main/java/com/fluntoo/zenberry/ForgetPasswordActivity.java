package com.fluntoo.zenberry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.fluntoo.zenberry.ApIInterface.ForgetPassINterface;
import com.fluntoo.zenberry.Model.Forgetpass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForgetPasswordActivity extends AppCompatActivity {
    EditText emailedt;
    Button send;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        emailedt = findViewById(R.id.email_edt);
        send = findViewById(R.id.sendemail_btn);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailedt.getText().toString();
                String url = "https://www.api.playflixx.com/forgot-password";
                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter above fields", Toast.LENGTH_SHORT).show();
                } else {

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://www.api.playflixx.com")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    ForgetPassINterface forgetPassINterface = retrofit.create(ForgetPassINterface.class);
                    Call<Forgetpass> call = forgetPassINterface.postemail(url, email);
                    call.enqueue(new Callback<Forgetpass>() {
                        @Override
                        public void onResponse(Call<Forgetpass> call, Response<Forgetpass> response) {
                            Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Forgetpass> call, Throwable t) {

                            Toast.makeText(getApplicationContext(), "Otp shared on given Email,Please check spam folder", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), OtpVerificationActivity.class));
                        }
                    });

                }
            }
        });

    }
}
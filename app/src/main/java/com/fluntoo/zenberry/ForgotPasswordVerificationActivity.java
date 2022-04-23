package com.fluntoo.zenberry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fluntoo.zenberry.ApIInterface.RegisterClient;
import com.fluntoo.zenberry.Model.ForgetPassNew;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForgotPasswordVerificationActivity extends AppCompatActivity {
    EditText phonedt,passwordedt;
    Button btn;
    String phone,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_verification);
        phonedt=findViewById(R.id.Phoneedtnew);
        passwordedt=findViewById(R.id.Passedtnew);
        btn=findViewById(R.id.buttonchangepassword);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone=phonedt.getText().toString().trim();
                pass=passwordedt.getText().toString().trim();
                String url="https://api.fluntoo.com/user/android/forgotpassword";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.playflixx.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RegisterClient registerClient=retrofit.create(RegisterClient.class);
                Call<ForgetPassNew> call=registerClient.putchange(url,phone,pass);
                call.enqueue(new Callback<ForgetPassNew>() {
                    @Override
                    public void onResponse(Call<ForgetPassNew> call, Response<ForgetPassNew> response) {
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ForgetPassNew> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),SuccesfulPasswordChangedACtivity.class));

                    }
                });



            }
        });

    }
}
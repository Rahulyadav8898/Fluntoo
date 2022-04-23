package com.fluntoo.zenberry;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.fluntoo.zenberry.ApIInterface.OurRetrofit;
import com.fluntoo.zenberry.Model.OurDataSet4;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VerifyOtpActivity_New extends AppCompatActivity {
    EditText edt;
    Button btn;
    String verificationid, name, pass, phone;
    TextView resend;
    ConstraintLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp_new);
        edt = findViewById(R.id.editTextotp);
        btn = findViewById(R.id.VerifyBUtton);
        resend = findViewById(R.id.resendtv);


        verificationid = getIntent().getStringExtra("verificationId");
        name = getIntent().getStringExtra("username");
        pass = getIntent().getStringExtra("pass");
        phone = getIntent().getStringExtra("mobile");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Otp", Toast.LENGTH_SHORT).show();
                }

                String code = edt.getText().toString().trim();

                if (verificationid != null) {
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                            verificationid, code
                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        backend();
                                        Intent intent = new Intent(getApplicationContext(), SucesfulSignupActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(), "otp is wrong", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });

//        resend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                PhoneAuthProvider.getInstance().verifyPhoneNumber("+91" +getIntent().getStringExtra("verificationId").toString(),
//                        60, TimeUnit.SECONDS,VerifyOtpActivity_New.this,new PhoneAuthProvider.OnVerificationStateChangedCallbacks()
//                        {
//                            @Override
//                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//
//                            }
//
//                            @Override
//                            public void onVerificationFailed(@NonNull FirebaseException e) {
//                                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
//
//                            }
//
//                            @Override
//                            public void onCodeSent(@NonNull String newVerificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                               verificationid=newVerificationId;
//                                Toast.makeText(getApplicationContext(), "OTP send", Toast.LENGTH_SHORT).show();
//
//
//                            }
//                        });
//            }
//        });
    }

    private void backend() {
//
        verificationid = getIntent().getStringExtra("verificationId");
        name = getIntent().getStringExtra("username");
        pass = getIntent().getStringExtra("pass");
        phone = getIntent().getStringExtra("mobile");

//        String url = "https://www.api.playflixx.com/android/register";
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.api.playflixx.com/android")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RegisterClient registerClient = retrofit.create(RegisterClient.class);
//        Call<User> call = registerClient.registertobackend(url,name, "null",pass, phone);
//
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
//                Log.d("call", response.toString());
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.fluntoo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);

        OurDataSet4 ourDataSet$ = new OurDataSet4(name, phone, pass, "register");
        Call<OurDataSet4> call = ourRetrofit.PostData4(ourDataSet$);

        call.enqueue(new Callback<OurDataSet4>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<OurDataSet4> call, Response<OurDataSet4> response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                Log.d("log", response.toString());

            }

            @Override
            public void onFailure(Call<OurDataSet4> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
//
        });

    }
}
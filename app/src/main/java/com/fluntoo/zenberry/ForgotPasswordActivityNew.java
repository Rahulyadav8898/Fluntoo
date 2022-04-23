package com.fluntoo.zenberry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordActivityNew extends AppCompatActivity {
    EditText phoneedt;
    Button btn;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_new);

        btn = findViewById(R.id.btnforgetsubmit);
        phoneedt = findViewById(R.id.editTextForget);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = phoneedt.getText().toString().trim();

                if (number.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "PLease Enter Number", Toast.LENGTH_SHORT).show();
                } else {

                    FirebaseApp.initializeApp(ForgotPasswordActivityNew.this);
                    FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
                    firebaseAppCheck.installAppCheckProviderFactory(
                            SafetyNetAppCheckProviderFactory.getInstance());

//                mAuth = FirebaseAuth.getInstance();
//                mAuth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber("+91" +phoneedt.getText().toString(),
                            60, TimeUnit.SECONDS,ForgotPasswordActivityNew.this,new PhoneAuthProvider.OnVerificationStateChangedCallbacks()
                            {
                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                }


                                @Override
                                public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    Intent intent=new Intent(getApplicationContext(),OTPVerificationActicityNewActivity.class);
                                    intent.putExtra("mobile1",phoneedt.getText().toString());
                                    intent.putExtra("verificationId1",verificationId);
//                                    intent.putExtra("username",name.getText().toString());
//                                    intent.putExtra("pass",pass.getText().toString());
                                    startActivity(intent);

//                                tobackend();
                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {
                                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

                                }

                            });

                }

            }
        });


    }
}
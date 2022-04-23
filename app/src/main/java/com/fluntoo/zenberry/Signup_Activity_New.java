package com.fluntoo.zenberry;

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

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Signup_Activity_New extends AppCompatActivity {
    EditText name, pass, phone;
    Button btn;
    TextView logintv;

    FirebaseAuth mAuth;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.editTextName);
        pass = findViewById(R.id.editTextTextPassword);
        phone = findViewById(R.id.editTextnumber);
        btn = findViewById(R.id.Regbtn);
        logintv = findViewById(R.id.Logintv);

        layout = findViewById(R.id.signlay);
        logintv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivityNew.class));
            }
        });

        FirebaseAuth.getInstance().getFirebaseAuthSettings().forceRecaptchaFlowForTesting(false);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_SHORT).show();
                }
                if (pass.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                }
                if (phone.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
                }

                FirebaseApp.initializeApp(Signup_Activity_New.this);
                FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
                firebaseAppCheck.installAppCheckProviderFactory(
                        SafetyNetAppCheckProviderFactory.getInstance());

//                mAuth = FirebaseAuth.getInstance();
//                mAuth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);

                PhoneAuthProvider.getInstance().verifyPhoneNumber("+91" + phone.getText().toString(),
                        60, TimeUnit.SECONDS, Signup_Activity_New.this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }


                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                Intent intent = new Intent(getApplicationContext(), VerifyOtpActivity_New.class);
                                intent.putExtra("mobile", phone.getText().toString());
                                intent.putExtra("verificationId", verificationId);
                                intent.putExtra("username", name.getText().toString());
                                intent.putExtra("pass", pass.getText().toString());
                                startActivity(intent);

//                                tobackend();
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
//                                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                                Snackbar snackbar = Snackbar
                                        .make(layout, e.getMessage(), Snackbar.LENGTH_LONG);
                                snackbar.show();
                                Log.d("error",e.getMessage());

                            }

                        });
            }
        });

//


    }


}
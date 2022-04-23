package com.fluntoo.zenberry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OTPVerificationActicityNewActivity extends AppCompatActivity {
    EditText edt;
    Button btn;

    String verificationid, name, pass, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification_acticity_new);
        edt = findViewById(R.id.editTextotpverify);
        btn = findViewById(R.id.buttonotpverify);

        verificationid = getIntent().getStringExtra("verificationId1");
//        name = getIntent().getStringExtra("username");
//        pass = getIntent().getStringExtra("pass");
        phone = getIntent().getStringExtra("mobile1");

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

                                        Intent intent = new Intent(getApplicationContext(), ForgotPasswordVerificationActivity.class);
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
    }
}
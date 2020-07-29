package com.sd.wastemanage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class OTPActivity extends AppCompatActivity {
    Button btnGet,btnRegister;
    EditText OTP;
    SharedPreferences sp1;
    FirebaseAuth mAuth;
    String codesent;
    TextView tvphone;
    String noo;
    TextInputLayout OTPWrapper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        btnGet = findViewById(R.id.btnGet);
        btnRegister = findViewById(R.id.btnRegister);
        OTP = findViewById(R.id.OTP);
        mAuth = FirebaseAuth.getInstance();
        tvphone = findViewById(R.id.tvphone);
        OTPWrapper = findViewById(R.id.OTPWrapper);



        sp1=getSharedPreferences("f1",MODE_PRIVATE);

        final String no = sp1.getString("no","");
        noo=no;

        //File root = new File("/");
        //File[] files = root.listFiles();

        btnGet.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sendVeificationCode();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                verifySignInCode();
            }
        });


    }

    private void verifySignInCode(){
        String code = OTP.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codesent, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(OTPActivity.this,DashboardActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(getApplicationContext(),"Incorrect OTP",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }
    private void sendVeificationCode(){

        sp1=getSharedPreferences("f1",MODE_PRIVATE);

        final String no = sp1.getString("no","");
        tvphone.setText(noo);

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                no,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {


        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(OTPActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            //super.onCodeSent(s, forceResendingToken);
            codesent = s;
        }
    };
}

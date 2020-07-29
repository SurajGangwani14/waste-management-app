package com.sd.wastemanage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    Button btnRegister;
    EditText userFirstName,userLastName,userEmailAddress,userPassword,userConfirmPassword,userContact;
    TextInputLayout userFirstNameWrapper,userLastNameWrapper,userEmailAddressWrapper,userPasswordWrapper,userConfirmPasswordWrapper,userContactWrapper;
    SharedPreferences sp1;
    FirebaseAuth mAuth;
    String Firstname,Lastname,Password,ConfirmPassword,no,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnRegister = findViewById(R.id.btnRegister);
        userFirstName = findViewById(R.id.userFirstName);
        userLastName = findViewById(R.id.userLastName);
        userEmailAddress = findViewById(R.id.userEmailAddress);
        userPassword = findViewById(R.id.userPassword);
        userConfirmPassword = findViewById(R.id.userConfirmPassword);
        userContact = findViewById(R.id.userContact);
        userFirstNameWrapper = findViewById(R.id.userFirstNameWrapper);
        userLastNameWrapper = findViewById(R.id.userLastNameWrapper);
        userEmailAddressWrapper = findViewById(R.id.userEmailAddressWrapper);
        userPasswordWrapper = findViewById(R.id.userPasswordWrapper);
        userConfirmPasswordWrapper = findViewById(R.id.userConfirmPasswordWrapper);
        userContactWrapper = findViewById(R.id.userContactWrapper);
        sp1=getSharedPreferences("f1",MODE_PRIVATE);
        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(mAuth.getCurrentUser()!=null){

                }
                else{*/
                    Firstname=userFirstName.getText().toString();
                    Lastname=userLastName.getText().toString();
                    ConfirmPassword = userConfirmPassword.getText().toString();
                    Password = userPassword.getText().toString();
                    email = userEmailAddress.getText().toString();
                    no = "+91"+userContact.getText().toString();

                    /*if (Firstname.length() == 0) {
                        userFirstName.setError("Name can not be empty");
                        userFirstName.requestFocus();
                        return;
                    }
                    if (Lastname.length() == 0) {
                        userLastName.setError("Name can not be empty");
                        userLastName.requestFocus();
                        return;
                    }
                    if (userPassword.length() == 0) {

                        Toast.makeText(SignUpActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (userConfirmPassword.length() == 0) {

                        Toast.makeText(SignUpActivity.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (!Password.equals(ConfirmPassword)) {

                        Toast.makeText(SignUpActivity.this, "Password & confirm password does not match", Toast.LENGTH_SHORT).show();
                        return;
                    }



                    if (userContact.getText().toString().length() != 10) {
                        userContact.setError("Invalid Phone No.");
                        userContact.setText("");
                        userContact.requestFocus();
                        return;
                    }*/


                    SharedPreferences.Editor editor = sp1.edit();
                    editor.putString("no", no);
                    editor.commit();



                    mAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Register ra = new Register(Firstname,Lastname,email,no,Password,ConfirmPassword);
                                FirebaseDatabase.getInstance().getReference("Register")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(ra)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(SignUpActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });
                            }
                            else{
                                Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                    Intent i = new Intent(SignUpActivity.this,OTPActivity.class);
                    startActivity(i);
                    finish();

                //}



            }
        });

    }
}

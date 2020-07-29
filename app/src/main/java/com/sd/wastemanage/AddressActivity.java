package com.sd.wastemanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddressActivity extends AppCompatActivity {
    TextInputLayout userFirstNameWrapper,userLastNameWrapper,userEmailAddressWrapper,userAddressWrapper,userCityWrapper,userStateWrapper,userPinCodeWrapper,userMobileWrapper;
    EditText userFirstName,userLastName,userEmailAddress,userAddress,userCity,userStateName,userPinCode,userMobile;
    Button btnRegister;
    String fname,lname,state,pin,mob,email,address,city,price,list,total;
    SharedPreferences sp3;
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        userFirstName = findViewById(R.id.userFirstName);
        userLastName = findViewById(R.id.userLastName);
        userEmailAddress = findViewById(R.id.userEmailAddress);
        userAddress = findViewById(R.id.userAddress);
        userCity = findViewById(R.id.userCity);
        userStateName = findViewById(R.id.userStateName);
        userPinCode = findViewById(R.id.userPinCode);
        userMobile = findViewById(R.id.userMobile);
        userFirstNameWrapper = findViewById(R.id.userFirstNameWrapper);
        userLastNameWrapper = findViewById(R.id.userLastNameWrapper);
        userEmailAddressWrapper = findViewById(R.id.userEmailAddressWrapper);
        userAddressWrapper = findViewById(R.id.userAddressWrapper);
        userCityWrapper = findViewById(R.id.userCityWrapper);
        userStateWrapper = findViewById(R.id.userStateWrapper);
        userPinCodeWrapper = findViewById(R.id.userPinCodeWrapper);
        userMobileWrapper = findViewById(R.id.userMobileWrapper);
        btnRegister = findViewById(R.id.btnRegister);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("OrderDetails");

        sp3=getSharedPreferences("f1",MODE_PRIVATE);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname = userFirstName.getText().toString();
                lname = userLastName.getText().toString();
                address = userAddress.getText().toString();
                mob = userMobile.getText().toString();
                pin = userPinCode.getText().toString();
                email = userEmailAddress.getText().toString();
                state = userStateName.getText().toString();
                city = userCity.getText().toString();
                price = sp3.getString("price","");
                list = sp3.getString("list","");
                total = sp3.getString("total","");
                OrderDetails o = new OrderDetails(fname,lname,address,mob,pin,email,state,city,price,list,total);
                myRef.push().setValue(o);
                //Toast.makeText(AddressActivity.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddressActivity.this,OrderSuccess.class);
                startActivity(i);
            }
        });






    }
}

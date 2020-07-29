package com.sd.wastemanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addprod extends AppCompatActivity {
    Button btnUserLogin,btnUserSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addprod);
        btnUserLogin = findViewById(R.id.btnUserLogin);
        btnUserSignup = findViewById(R.id.btnUserSignup);

        btnUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(addprod.this,LoginActivity.class);
                startActivity(i);
            }
        });
        btnUserSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(addprod.this,SignUpActivity.class);
                startActivity(i);
            }
        });
    }
}

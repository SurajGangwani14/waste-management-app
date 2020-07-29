package com.sd.wastemanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WalletActivity extends AppCompatActivity {
    TextView Money;
    FirebaseDatabase database;
    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference myRef;
    SharedPreferences sp10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        Money = findViewById(R.id.Money);

        sp10=getSharedPreferences("f10",MODE_PRIVATE);

        final String no = sp10.getString("no","");
        Money.setText(no);
    }
}

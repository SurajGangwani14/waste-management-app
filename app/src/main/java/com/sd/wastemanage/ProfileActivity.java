package com.sd.wastemanage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    //ListView lvData;
    FirebaseDatabase database;
    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference myRef;
    TextView Firstname,Lastname,Email,tvAddress,tvPincode,tvPhone,acard,Profile;
    Button button;
    TextView textView24,textView25,textView26,textView27,textView28,textView29,textView30;
    String pincode,fn,l,ad,ac,ph;
    ImageView Profilepic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // Profile = findViewById(R.id.Profile);
        //Profilepic = findViewById(R.id.Profilepic);
        Firstname = findViewById(R.id.Firstname);
        Lastname = findViewById(R.id.Lastname);

        tvPhone = findViewById(R.id.tvPhone);

        acard = findViewById(R.id.acard);
        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView28 = findViewById(R.id.textView28);
        textView29 = findViewById(R.id.textView29);
        textView30 = findViewById(R.id.textView30);
        button= findViewById(R.id.button);





        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();


        //lvData = findViewById(R.id.lvData);
        if (user != null) {
            textView26.setText(user.getEmail());
            // Phone.setText(user.getPhoneNumber());
            String uid = user.getUid();
            myRef = FirebaseDatabase.getInstance().getReference("Register").child(uid);
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    fn = dataSnapshot.getValue(Register.class).getFirstName();
                    textView24.setText(fn);
                    l = dataSnapshot.getValue(Register.class).getLastName();
                    textView25.setText(l);

                    ac = dataSnapshot.getValue(Register.class).getEmailAdd();
                    textView26.setText(ac);
                    ph = dataSnapshot.getValue(Register.class).getContact();
                    textView27.setText(ph);


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(ProfileActivity.this, "some issues", Toast.LENGTH_SHORT).show();
                }
            });



        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(a);

            }
        });
    }
}

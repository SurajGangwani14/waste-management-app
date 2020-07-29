package com.sd.wastemanage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewOrderActivity extends AppCompatActivity {

    ListView lvData;
    ArrayList<OrderDetails> s = new ArrayList<>();
    ArrayAdapter<OrderDetails> ad;
    FirebaseDatabase database,database1;
    DatabaseReference databaseReference,databaseReference1;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    DatabaseReference myRef;
    String pincode;
    String Pincode;
    ArrayList<String>k= new ArrayList<>();
    ArrayList<OrderDetails> s1 = new ArrayList<>();
    ArrayAdapter<Register> ad1;
    ArrayList<String>k1= new ArrayList<>();
    double price;
    SharedPreferences sp10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);
        lvData = findViewById(R.id.lvData);
        sp10 = getSharedPreferences("f10",MODE_PRIVATE);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        if(user != null){}
        String uid = user.getUid();
        databaseReference1 = FirebaseDatabase.getInstance().getReference("Register").child(uid);
        databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Pincode = dataSnapshot.getValue(Register.class).getEmailAdd();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //RegisterGC r1 = new RegisterGC();

        // Name, email address, and profile photo Url







        database = FirebaseDatabase.getInstance();
        /*database1 = FirebaseDatabase.getInstance();
        databaseReference1 = database.getReference("RegisterGC");
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
          PinCode= dataSnapshot.child("RegisterGC").child("PinCode").getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/


        databaseReference = database.getReference("OrderDetails");
        databaseReference.addValueEventListener(new ValueEventListener() {



            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                s.clear();
                k.clear();
                for(DataSnapshot d:dataSnapshot.getChildren()){

                    pincode = d.getValue(OrderDetails.class).getEmail();
                    //Toast.makeText(ViewOrderActivity.this, pincode, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(ViewOrderActivity.this, Pincode, Toast.LENGTH_SHORT).show();
                    //    Toast.makeText(ViewOrderActivity.this, ""+pincode +"" +Pincode, Toast.LENGTH_SHORT).show();

                    if(pincode.equals(Pincode)) {
                        OrderDetails data = d.getValue(OrderDetails.class);
                        OrderDetails datas = d.getValue(OrderDetails.class);
                        try {
                            price += Double.valueOf(data.getPrice());
                        }catch (NumberFormatException ne){}


                        s.add(data);
                        k.add(d.getKey());
                    }
                               /* else if(pincode.equals("412356")){
                                    OrderDetails data = d.getValue(OrderDetails.class);

                                    s.add(data);
                                    k.add(d.getKey());

                                }*/
                                /*else if(pincode.equals("421004")){

                                    OrderDetails data = d.getValue(OrderDetails.class);

                                    s.add(data);
                                    k.add(d.getKey());

                                }*/
                }
                ad = new ArrayAdapter<>(ViewOrderActivity.this,android.R.layout.simple_list_item_1,s);
                lvData.setAdapter(ad);
                String mon = String.valueOf(price);
                Toast.makeText(ViewOrderActivity.this,mon , Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sp10.edit();
                editor.putString("no", mon);
                editor.commit();

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //});
}

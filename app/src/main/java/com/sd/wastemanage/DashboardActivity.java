package com.sd.wastemanage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    ViewFlipper imgbanner;
    private RecyclerView mRecyclerView;

    private DatabaseReference mDatabaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        imgbanner = findViewById(R.id.imgbanner);

        int sliders[]={R.drawable.recycledashboard,R.drawable.dashboard,R.drawable.dashboard3};

        for(int slide:sliders){
            bannerFlipper(slide);
        }

    }



    public void bannerFlipper(int image){
        ImageView imageView = new ImageView(this);
        //imageView.setImageResource(image);
        imageView.setBackgroundResource(image);
        imgbanner.addView(imageView);
        imgbanner.setFlipInterval(1000);
        imgbanner.setAutoStart(true);
        imgbanner.setInAnimation(this,android.R.anim.fade_in);
        imgbanner.setOutAnimation(this,android.R.anim.fade_out);


    }
    public void card1(View view){
        Intent i = new Intent(DashboardActivity.this,ShopActivity.class);
        startActivity(i);
    }
    public void card2(View view){
        Intent i = new Intent(DashboardActivity.this,ViewOrderActivity.class);
        startActivity(i);
    }
    public void card3(View view){
        Intent i = new Intent(DashboardActivity.this,ProfileActivity.class);
        startActivity(i);
    }
    public void card4(View view){
        Intent i = new Intent(DashboardActivity.this,WalletActivity.class);
        startActivity(i);
    }
}

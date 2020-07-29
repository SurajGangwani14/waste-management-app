package com.sd.wastemanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ShopActivity extends AppCompatActivity {
    FloatingActionButton Fbtn1;
    ElegantNumberButton btn1,btn2,btn3,btn4,btn5;
    SharedPreferences sp2;
    String item1,item2,item3,item4,item5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        btn1 = (ElegantNumberButton) findViewById(R.id.btn1);
        btn2 = (ElegantNumberButton) findViewById(R.id.btn2);
        btn3 = (ElegantNumberButton) findViewById(R.id.btn3);
        btn4 = (ElegantNumberButton) findViewById(R.id.btn4);
        btn5 = (ElegantNumberButton) findViewById(R.id.btn5);
        Fbtn1= (FloatingActionButton) findViewById(R.id.Fbtn1);
        sp2=getSharedPreferences("f1",MODE_PRIVATE);


        btn1.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                item1 = btn1.getNumber();
                Toast.makeText(ShopActivity.this, item1, Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                item2 = btn2.getNumber();
                Toast.makeText(ShopActivity.this, item2, Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                item3 = btn3.getNumber();
                Toast.makeText(ShopActivity.this, item3, Toast.LENGTH_SHORT).show();
            }
        });
        btn4.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                item4 = btn4.getNumber();
                Toast.makeText(ShopActivity.this, item4, Toast.LENGTH_SHORT).show();
            }
        });
        btn5.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                item5 = btn5.getNumber();
                Toast.makeText(ShopActivity.this, item5, Toast.LENGTH_SHORT).show();
            }
        });
        Fbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sp2.edit();
                editor.putString("item1", item1);
                editor.putString("item2", item2);
                editor.putString("item3", item3);
                editor.putString("item4", item4);
                editor.putString("item5", item5);
                editor.commit();

                Intent i = new Intent(ShopActivity.this,CartActivity.class);
                startActivity(i);

            }
        });
    }

}

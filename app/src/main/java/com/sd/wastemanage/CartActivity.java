package com.sd.wastemanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class CartActivity extends AppCompatActivity {
    Button order;
    ImageView ibtnadd;
    TextView title1,price1,price2,price3,price4,price5,price6,price7,price8,total,finalprice;
    SharedPreferences sp2;
    String items1,items2,items3,items4,items5,fprice,Totalitem;
    int qty1,qty2,qty3,qty4,qty5;
    ElegantNumberButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    int p1,p2,p3,p4,p5,p6,p7,p8;
    SharedPreferences sp3;
    int value,s1,s2,s3,s4,s5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ibtnadd = findViewById(R.id.ibtnadd);
        order = findViewById(R.id.order);
        title1 = findViewById(R.id.title1);
        price1 = findViewById(R.id.price1);
        price2 = findViewById(R.id.price2);
        price3 = findViewById(R.id.price3);
        price4 = findViewById(R.id.price4);
        price5 = findViewById(R.id.price5);
        price6 = findViewById(R.id.price6);
        price7 = findViewById(R.id.price7);
        price8 = findViewById(R.id.price8);
        finalprice = findViewById(R.id.finalprice);
        btn1 = (ElegantNumberButton) findViewById(R.id.btn1);
        btn2 = (ElegantNumberButton) findViewById(R.id.btn2);
        btn3 = (ElegantNumberButton) findViewById(R.id.btn3);
        btn4 = (ElegantNumberButton) findViewById(R.id.btn4);
        btn5 = (ElegantNumberButton) findViewById(R.id.btn5);
        btn6 = (ElegantNumberButton) findViewById(R.id.btn6);
        btn7 = (ElegantNumberButton) findViewById(R.id.btn7);
        btn8 = (ElegantNumberButton) findViewById(R.id.btn8);
        total = findViewById(R.id.total);
        CardView card1 = (CardView) findViewById(R.id.card1);
        CardView card2 = (CardView) findViewById(R.id.card2);
        CardView card3 = (CardView) findViewById(R.id.card3);
        CardView card4 = (CardView) findViewById(R.id.card4);
        CardView card5 = (CardView) findViewById(R.id.card5);
        CardView card6 = (CardView) findViewById(R.id.card6);
        CardView card7 = (CardView) findViewById(R.id.card7);
        CardView card8 = (CardView) findViewById(R.id.card8);
        card1.setVisibility(View.GONE);
        card2.setVisibility(View.GONE);
        card3.setVisibility(View.GONE);
        card4.setVisibility(View.GONE);
        card5.setVisibility(View.GONE);
        card6.setVisibility(View.GONE);
        card7.setVisibility(View.GONE);
        card8.setVisibility(View.GONE);

        try {
        sp2=getSharedPreferences("f1",MODE_PRIVATE);
        items1=sp2.getString("item1","");
        items2=sp2.getString("item2","");
        items3=sp2.getString("item3","");
        items4=sp2.getString("item4","");
        items5=sp2.getString("item5","");
        String it1=items1;
        String it2=items2;
        String it3=items3;
        String it4=items4;
        String it5=items5;

        qty1=Integer.valueOf(sp2.getString("item1",""));
        qty2=Integer.valueOf(items2);
        qty3=Integer.decode(it3);
        qty4=Integer.parseInt(it4);
        qty5=Integer.parseInt(it5);
        if(qty1!=0){
            card1.setVisibility(View.VISIBLE);
            btn1.setNumber(items1);
        }
        if(qty2!=0){
            card2.setVisibility(View.VISIBLE);
            btn2.setNumber(items2);
        }
        if(qty3!=0){
            card3.setVisibility(View.VISIBLE);
            btn3.setNumber(items3);
        }
        if(qty4!=0){
            card4.setVisibility(View.VISIBLE);
            btn4.setNumber(items4);
        }
        if(qty5!=0){
            card5.setVisibility(View.VISIBLE);
            btn5.setNumber(items5);
        }
        int no=qty1+qty2+qty3+qty4+qty5;
        Totalitem = "Total items are"+String.valueOf(no);
        total.setText(Totalitem);
        String pri1 = price1.getText().toString();
        String pri2 = price2.getText().toString();
        String pri3 = price3.getText().toString();
        String pri4 = price4.getText().toString();
        String pri5 = price5.getText().toString();

            p1 = Integer.parseInt(pri1);
            p2 = Integer.parseInt(pri2);
            p3 = Integer.parseInt(pri3);
            p4 = Integer.parseInt(pri4);
            p5 = Integer.parseInt(pri5);
            int value = p1*qty1+p2*qty2+p3*qty3+p4*qty4+p5*qty5;
            fprice = String.valueOf(value);
            finalprice.setText("Total price:"+String.valueOf(value));
        }



        catch (NumberFormatException e){

        }
        if (qty1==0&&qty2==0&&qty3==0&&qty4==0&&qty5==0) {
            order.setVisibility(View.GONE);
            Intent i = new Intent(CartActivity.this,AddressActivity.class);

        }
        btn1.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                value = newValue*p1+p2*qty2+p3*qty3+p4*qty4+p5*qty5;
                s1=value;
                fprice = String.valueOf(value);
                finalprice.setText("Total price:"+String.valueOf(value));
            }
        });
        btn2.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                value = s1+ p2*newValue;
                s2 = value;
                fprice = String.valueOf(value);
                finalprice.setText("Total price:"+String.valueOf(value));
            }
        });
        btn3.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                value = p1*qty1+p2*qty2+newValue*qty3+p4*qty4+p5*qty5;
                fprice = String.valueOf(value);
                finalprice.setText("Total price:"+String.valueOf(value));
            }
        });
        btn4.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                value = p1*qty1+p2*qty2+p3*qty3+p4*newValue+p5*qty5;
                fprice = String.valueOf(value);
                finalprice.setText("Total price:"+String.valueOf(value));
            }
        });
        btn1.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                value = p1*qty1+p2*qty2+p3*qty3+p4*qty4+p5*newValue;
                fprice = String.valueOf(value);
                finalprice.setText("Total price:"+String.valueOf(value));
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lists="";
                String i1 = btn1.getNumber();
                String i2 = btn2.getNumber();
                String i3 = btn3.getNumber();
                String i4 = btn4.getNumber();
                String i5 = btn5.getNumber();
                if(!(i1.equals("0"))){
                    lists=i1+"bottle";

                }
                if(i2!="0"){
                    lists+=(i2+"thermacol");

                }
                if(i3!="0"){
                    lists+=(i3+"newspaper");

                }
                if(i4!="0"){
                    lists+=(i4+"polythene");

                }if(i5!="0"){
                    lists+=(i5+"container");

                }





                sp3=getSharedPreferences("f1",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp3.edit();
                editor.putString("price", fprice);
                editor.putString("list", lists);
                editor.putString("total", Totalitem);
                editor.commit();
                Intent i = new Intent(CartActivity.this,AddressActivity.class);
                startActivity(i);

            }
        });








    }
}

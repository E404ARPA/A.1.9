package com.example.a19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = (TextView) findViewById(R.id.quantum);
    }

    private int itemQuantum = 0;
    private TextView quantity;

    public void add(View view) {
        itemQuantum++;
        if (quantity != null)
            quantity.setText(Integer.toString(itemQuantum));
    }

    public void decrease(View view) {
        if (itemQuantum >= 1)
            itemQuantum--;

        if (quantity != null)
            quantity.setText(Integer.toString(itemQuantum));
    }

    final double BASE_PRICE = 1.5, TOPPINGS = 0.5;
    public void movidas(View view) {
        Intent intent = new Intent(this, Act2.class);
        Bundle extras = new Bundle();

        String data = "Please add to your order at least one coffee";

        if(itemQuantum > 0){
            double totalPrice = BASE_PRICE;

            String uName = String.valueOf(((TextView) findViewById(R.id.userName)).getText());
            CheckBox chkAlpha = findViewById(R.id.Alpha);
            CheckBox chkBeta = findViewById(R.id.Beta);

            if (chkAlpha.isChecked()){
                totalPrice+=TOPPINGS;
            }
            if (chkBeta.isChecked()){
                totalPrice+=TOPPINGS;
            }

            totalPrice*=itemQuantum;

            data = uName + ", you ordered " + itemQuantum + " coffee";
            if(itemQuantum>1){
                data+="s ";
            }
            if(chkAlpha.isChecked() && chkBeta.isChecked()){
                data+="with whipped cream and chocolate";
            } else if(chkAlpha.isChecked()){
                data+="with whipped cream";
            } else if(chkBeta.isChecked()){
                data+="with chocolate";
            }
            data+=".\nTotal price is: " + totalPrice;
        }

        extras.putString("data", data);
        intent.putExtras(extras);
        startActivity(intent);
    }

}
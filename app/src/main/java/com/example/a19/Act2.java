package com.example.a19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Act2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        Intent intent = getIntent();

        TextView out;
        out = (TextView) findViewById(R.id.out);

        String data = intent.getStringExtra("data");
        out.setText(data);
    }
}
package com.google.bmicaclculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvResultBmi = findViewById(R.id.tvResultBmi);
        String sDariHal1 = getIntent().getStringExtra("resultBmi");
        tvResultBmi.setText(sDariHal1);
    }
}
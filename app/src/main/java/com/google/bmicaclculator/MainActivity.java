package com.google.bmicaclculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //deklarasi var
    EditText etHeight, etWeight;
    Button btnCalculate, btnApaAja;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisiasi nilai variabel
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalculate = findViewById(R.id.btnCalculateBMI);
        tvResult = findViewById(R.id.tvResult);
        btnApaAja = findViewById(R.id.btnApaAja);

        //pasang listener di button / di imageview
        btnCalculate.setOnClickListener(this);
        btnApaAja.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String scope = "onClick";
        Log.v(scope,"coba log di android");

        if(view.getId()==R.id.btnCalculateBMI){
            String sHeight = etHeight.getText().toString();
            double dHeight = Double.parseDouble(sHeight);
            Log.v(scope,"user ada input "+dHeight);

            String sWeight = etWeight.getText().toString();
            double dWeight = Double.parseDouble(sWeight);
            Log.v(scope,"user ada input "+dWeight);

            double dBmi = dWeight / (dHeight*dHeight);
            Log.v(scope,"hasil bmi: "+dBmi);

            String sResult = "";
            if(dBmi<18.5){
                sResult = "Keputusan: underweight";
                Toast.makeText(this, sResult, Toast.LENGTH_LONG).show();
                Log.v(scope, sResult);
                tvResult.setText(sResult);
            }else if(dBmi>25){
                sResult = "Keputusan: overweight";
                Toast.makeText(this, sResult, Toast.LENGTH_LONG).show();
                Log.v(scope, sResult);
                tvResult.setText(sResult);
            }else{
                sResult = "Keputusan: normal";
                Toast.makeText(this, sResult, Toast.LENGTH_LONG).show();
                Log.v(scope, sResult);
                tvResult.setText(sResult);
            }

            //pindah halaman
            //deklarasi niat
            Intent niatPindah = new Intent(this,MainActivity2.class);
            niatPindah.putExtra("resultBmi", sResult);
            //jalanin niat
            startActivity(niatPindah);
        }else{
            Toast.makeText(this, "Apa Aja Bole ditekan", Toast.LENGTH_SHORT).show();
        }




    }
}
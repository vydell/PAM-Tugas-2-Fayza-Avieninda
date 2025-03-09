package com.beginning.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private String number1;
    private String number2;
    private double hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button btnReturn = findViewById(R.id.btnReturn);

        Intent iHitung = getIntent();
        TextView tvResult = findViewById(R.id.tvResult);
        number1 = iHitung.getStringExtra("angka pertama");
        number2 = iHitung.getStringExtra("angka kedua");
        String operator = iHitung.getStringExtra("operasi perhitungan");

        switch(operator) {
            case ("+"):
                plus();
                break;
            case ("-"):
                minus();
                break;
            case ("*"):
                multiply();
                break;
            case ("/"):
                divide();
                break;
            default:
                hasil = 0;
        }

        hasil = Math.round(hasil * 100.0) / 100.0;
        tvResult.setText(String.valueOf(hasil));

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iKembali = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(iKembali);
            }
        });
    }

    public void back(View view) {
    }
    public void plus() {
        hasil = Double.parseDouble(number1) + Double.parseDouble(number2);
    }

    public void minus() {
        hasil = Double.parseDouble(number1) - Double.parseDouble(number2);
    }

    public void multiply() {
        hasil = Double.parseDouble(number1) * Double.parseDouble(number2);
    }

    public void divide() {
        hasil = Double.parseDouble(number1) / Double.parseDouble(number2);
    }
}
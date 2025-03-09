package com.beginning.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText number1;
    private EditText number2;
    private Button btnHitung;
    private RadioGroup radioGroup;
    private RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        btnHitung = findViewById(R.id.btnHitung);
        radioGroup = findViewById(R.id.radioPerhitungan);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Pilih operasi perhitungan", Toast.LENGTH_SHORT).show();
                    return;
                }

                radioButton = findViewById(selectedId);

                String angkaPertama = number1.getText().toString().trim();
                String angkaKedua = number2.getText().toString().trim();

                if (angkaPertama.isEmpty() || angkaKedua.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Isi kedua angka", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent iHitung = new Intent(MainActivity.this, ResultActivity.class);
                iHitung.putExtra("angka pertama", angkaPertama);
                iHitung.putExtra("angka kedua", angkaKedua);
                iHitung.putExtra("operasi perhitungan", radioButton.getText().toString()); // Ensure text is converted to String
                startActivity(iHitung);
            }
        });

    }
}
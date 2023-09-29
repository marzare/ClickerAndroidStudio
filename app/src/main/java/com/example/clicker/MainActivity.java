package com.example.clicker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int licznik = 0;
    private boolean sw = false;
    private TextView textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonIncrement = findViewById(R.id.buttonIncrement);
        Button buttonReset = findViewById(R.id.buttonReset);
        Switch switchMode = findViewById(R.id.switchMode);
        textCounter = findViewById(R.id.textCounter);

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw) {
                    licznik++;
                } else {
                    licznik--;
                }
                updateCounterText();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licznik = 0;
                updateCounterText();
            }
        });

        switchMode.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sw = isChecked;
            }
        });
    }

    private void updateCounterText() {
        textCounter.setText("Licznik: " + licznik);
    }
}
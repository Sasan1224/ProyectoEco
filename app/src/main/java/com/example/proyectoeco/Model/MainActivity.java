package com.example.proyectoeco.Model;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectoeco.R;

public class MainActivity extends AppCompatActivity {
    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);

        start.setOnClickListener(
                (v) -> {
                    Intent i = new Intent(this, Controller.class);
                    startActivity(i);
                    finish();
                }
        );
    }
}

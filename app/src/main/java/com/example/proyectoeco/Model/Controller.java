package com.example.proyectoeco.Model;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectoeco.Model.Movement.Movimiento;
import com.example.proyectoeco.R;
import com.google.gson.Gson;

public class Controller extends AppCompatActivity {

    Button abajoBtn, arribaBtn, izquierdaBtn, derechaBtn;
    int posX,posY;
    private TCP tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tcp = TCP.getInstance();
        tcp.start();

        arribaBtn = findViewById(R.id.upBtn);
        abajoBtn = findViewById(R.id.downBtn);
        izquierdaBtn = findViewById(R.id.leftBtn);
        derechaBtn = findViewById(R.id.rightBtn);



        arribaBtn.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson();
                    Movimiento perso = new Movimiento("arriba",0,100);
                    String json = gson.toJson(perso);
                    tcp.Message(json);
                }
        );

        abajoBtn.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson();
                    Movimiento perso = new Movimiento("abajo",0,100);
                    String json = gson.toJson(perso);
                    tcp.Message(json);
                }
        );

        izquierdaBtn.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson();
                    Movimiento perso = new Movimiento("izquierda",100,0);
                    String json = gson.toJson(perso);
                    tcp.Message(json);
                }
        );

        derechaBtn.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson();
                    Movimiento perso = new Movimiento("derecha",100,0);
                    String json = gson.toJson(perso);
                    tcp.Message(json);
                }
        );

    }
}
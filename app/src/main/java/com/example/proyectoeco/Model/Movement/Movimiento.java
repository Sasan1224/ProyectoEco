package com.example.proyectoeco.Model.Movement;

public class Movimiento {

    //Posiciones
    protected int posX, posY;

    public Movimiento() {}

    public Movimiento(String atacar, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;

    }

    //Metodo

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}

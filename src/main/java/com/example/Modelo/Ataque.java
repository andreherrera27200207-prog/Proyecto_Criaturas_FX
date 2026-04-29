package com.example.Modelo;

import com.example.Modelo.Efectos.Efecto;

public class Ataque{
    private String nombre;
    private int coste;
    private Efecto efecto;

    public Ataque(){
        this.nombre = "";
        this.coste = 0;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoste() {
        return this.coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public Efecto getEfecto() {
        return this.efecto;
    }

    public void setEfecto(Efecto efecto) {
        this.efecto = efecto;
    }

    @Override
    public String toString() {
        return nombre;
    }   
    
}

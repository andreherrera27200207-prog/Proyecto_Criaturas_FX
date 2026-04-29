package com.example.Modelo;

import com.example.Modelo.Efectos.Efecto;

 /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     * @version 1.0
     * @since 1.0
     */

public class Ataque{
    private String nombre;
    private int coste;
    private Efecto efecto;

    /**
     * constructor de ataque por defecto
     */
    public Ataque(){
        this.nombre = "";
        this.coste = 0;
    }
    
    /**
     * 
     * @return el nombre del ataque
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * 
     * @param nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return el coste del ataque
     */
    public int getCoste() {
        return this.coste;
    }

    /**
     * 
     * @param coste
     */
    public void setCoste(int coste) {
        this.coste = coste;
    }

    /**
     * 
     * @return el ataque
     */
    public Efecto getEfecto() {
        return this.efecto;
    }

    /**
     * 
     * @param efecto
     */
    public void setEfecto(Efecto efecto) {
        this.efecto = efecto;
    }

    /**
     * @return el nombre del ataque
     */
    @Override
    public String toString() {
        return nombre;
    }   
    
}

package com.example.Modelo;
import java.util.List;

public class JugadorDTO {
    private float vida;
    private String nombre;
    private int monocos;
    private float danoMultiplicador;
    private int segundosVisibles;
    private int monocosPorParry;
    private List<String> ataqueLista;

    public float getVida() { return vida; }
    public String getNombre() { return nombre; }
    public int getMonocos() { return monocos; }
    public float getDanoMultiplicador() { return danoMultiplicador; }
    public int getSegundosVisibles() { return segundosVisibles; }
    public int getMonocosPorParry() { return monocosPorParry; }
    public List<String> getAtaqueLista() { return ataqueLista; }
}

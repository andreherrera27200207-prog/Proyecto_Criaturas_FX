package com.example.Modelo;

public class Ascua implements Efecto {

    @Override
    public void estrategia(Partida partida) {
        partida.getEnemigos().get(0).setVida(1);
        System.out.println("Has establecido la vida de " + partida.getEnemigos().get(0).getNombre() + " en 1");
    }
    
}

package com.example.Modelo;

public class Rayo implements Efecto{

    @Override
    public void estrategia(Partida partida) {
        partida.getEnemigos().get(1).recibirDano(3*partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(0).recibirDano(1.5f*partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(2).recibirDano(1.5f*partida.getJugador().getDanoMultiplicador());
        System.out.println("Has golpeado a " + partida.getEnemigos().get(1) + " y le has hecho la mitad del daño a los adyacentes");
    }

}

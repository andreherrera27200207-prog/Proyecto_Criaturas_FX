package com.example.Modelo.Efectos;

import com.example.Modelo.Partida;

import com.example.Modelo.Efectos.Efecto;

public class Gommage implements Efecto{

    @Override
    public void estrategia(Partida partida) {
        partida.getEnemigos().get(0).recibirDano(4*partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(1).recibirDano(2*partida.getJugador().getDanoMultiplicador());
        partida.getJugador().anadirGolpes(2);
        System.out.println("Has hecho " + 4*(partida.getJugador().getDanoMultiplicador()) + " a " + partida.getEnemigos().get(0).getNombre() + " y la mitad a " + partida.getEnemigos().get(1).getNombre());
    }

}

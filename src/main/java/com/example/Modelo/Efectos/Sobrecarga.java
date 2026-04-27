package com.example.Modelo.Efectos;

import com.example.Modelo.Partida;

import com.example.Modelo.Efectos.Efecto;

public class Sobrecarga implements Efecto{

    @Override
    public void estrategia(Partida partida) {
        partida.getEnemigos().get(0).recibirDano(partida.getJugador().getNGolpes()*partida.getJugador().getDanoMultiplicador());
        partida.getJugador().anadirGolpes(1);
        System.out.println("Has hecho " + partida.getJugador().getNGolpes()*partida.getJugador().getDanoMultiplicador() + " de daño a " + partida.getEnemigos().get(0).getNombre());
    }

}

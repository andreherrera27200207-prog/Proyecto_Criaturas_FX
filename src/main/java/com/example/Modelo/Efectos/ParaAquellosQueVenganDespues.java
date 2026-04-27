package com.example.Modelo.Efectos;

import com.example.Modelo.Partida;

import com.example.Modelo.Efectos.Efecto;

public class ParaAquellosQueVenganDespues implements Efecto{

    @Override
    public void estrategia(Partida partida) {
        partida.getJugador().setDanoMultiplicador(partida.getJugador().getDanoMultiplicador()+1.0f);
        partida.getJugador().Ftwca(partida.getJugador().getTurnos());
        System.out.println("En el siguiente turno tienes +1 de multiplicador de daño");

    }

}

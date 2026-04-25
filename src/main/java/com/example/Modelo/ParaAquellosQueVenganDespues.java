package com.example.Modelo;

public class ParaAquellosQueVenganDespues implements Efecto{

    @Override
    public void estrategia(Partida partida) {
        partida.getJugador().setDanoMultiplicador(partida.getJugador().getDanoMultiplicador()+1.0f);
        partida.getJugador().Ftwca(partida.getJugador().getTurnos());
        System.out.println("En el siguiente turno tienes +1 de multiplicador de daño");

    }

}

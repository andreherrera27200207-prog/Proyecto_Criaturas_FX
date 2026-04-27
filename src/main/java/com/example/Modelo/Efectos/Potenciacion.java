package com.example.Modelo.Efectos;

import com.example.Modelo.Partida;

import com.example.Modelo.Efectos.Efecto;

public class Potenciacion implements Efecto{

    @Override
    public void estrategia(Partida partida) {
        partida.getJugador().setDanoMultiplicador(partida.getJugador().getDanoMultiplicador()+0.2f);
        System.out.println("Se ha subido tu multiplicador de daño en 0.2, ahora es de " + partida.getJugador().getDanoMultiplicador());
    }

}

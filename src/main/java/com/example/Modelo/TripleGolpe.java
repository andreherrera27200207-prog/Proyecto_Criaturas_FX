package com.example.Modelo;

public class TripleGolpe implements Efecto {
    /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     */
    @Override
    public void estrategia(Partida partida) {
        partida.getEnemigos().get(0).setVida(1.2f * partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(0).setVida(1.2f * partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(0).setVida(1.2f * partida.getJugador().getDanoMultiplicador());
        partida.getJugador().anadirGolpes(3);
        System.out.println("Has golpeado 3 veces a " + partida.getEnemigos().get(0).getNombre());
    }

}

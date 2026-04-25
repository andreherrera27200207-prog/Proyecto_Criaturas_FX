package com.example.Modelo;

public class Gommage implements Efecto {
    /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     */

    @Override
    public void estrategia(Partida partida) {
        partida.getEnemigos().get(0).recibirDano(4 * partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(1).recibirDano(2 * partida.getJugador().getDanoMultiplicador());
        partida.getJugador().anadirGolpes(2);
        System.out.println("Has hecho " + 4 * (partida.getJugador().getDanoMultiplicador()) + " a "
                + partida.getEnemigos().get(0).getNombre() + " y la mitad a "
                + partida.getEnemigos().get(1).getNombre());
    }

}

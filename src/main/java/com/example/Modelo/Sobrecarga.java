package com.example.Modelo;

public class Sobrecarga implements Efecto {
    /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     */
    @Override
    public void estrategia(Partida partida) {
        partida.getEnemigos().get(0)
                .recibirDano(partida.getJugador().getNGolpes() * partida.getJugador().getDanoMultiplicador());
        partida.getJugador().anadirGolpes(1);
        System.out
                .println("Has hecho " + partida.getJugador().getNGolpes() * partida.getJugador().getDanoMultiplicador()
                        + " de daño a " + partida.getEnemigos().get(0).getNombre());
    }

}

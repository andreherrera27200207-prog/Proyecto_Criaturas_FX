package com.example.Modelo;

public class Potenciacion implements Efecto {
    /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     */
    @Override
    public void estrategia(Partida partida) {
        partida.getJugador().setDanoMultiplicador(partida.getJugador().getDanoMultiplicador() + 0.2f);
        System.out.println("Se ha subido tu multiplicador de daño en 0.2, ahora es de "
                + partida.getJugador().getDanoMultiplicador());
    }

}

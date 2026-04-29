package com.example.Modelo.Efectos;

import com.example.Modelo.Jugador;
import com.example.Modelo.Partida;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class Impactrueno implements Efecto {

    @Override
    public void estrategia(Partida partida, TextArea txt) {
        if (partida.getJugador().getVida() % 2 == 0) {
            partida.getEnemigos().get(0).setVida(
                    partida.getEnemigos().get(0).getVida() - (partida.getEnemigos().get(0).getVida() / 2));
            
            partida.getJugador().anadirGolpes(1);
            System.out.println();
            Platform.runLater(() -> txt.appendText("Has lanzado 1 trueno a " + partida.getEnemigos().get(0).getNombre()
                    + " de daño 1 vez "));
        }

    }
}

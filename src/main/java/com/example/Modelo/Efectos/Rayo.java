package com.example.Modelo.Efectos;

import com.example.Modelo.Partida;
import com.example.Modelo.Efectos.Efecto;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class Rayo implements Efecto{

    @Override
    public void estrategia(Partida partida, TextArea txt) {
        partida.getEnemigos().get(1).recibirDano(3*partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(0).recibirDano(1.5f*partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(2).recibirDano(1.5f*partida.getJugador().getDanoMultiplicador());
        System.out.println();
        Platform.runLater(() -> txt.appendText("Has golpeado a " + partida.getEnemigos().get(1).getNombre() + " y le has hecho la mitad del daño a los adyacentes" + "\n"));
        System.out.println();
    }

}

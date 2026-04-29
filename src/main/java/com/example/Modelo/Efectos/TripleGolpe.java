package com.example.Modelo.Efectos;

import com.example.Modelo.Partida;
import com.example.Modelo.Efectos.Efecto;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class TripleGolpe implements Efecto{

    @Override
    public void estrategia(Partida partida, TextArea txt) {
        partida.getEnemigos().get(0).setVida(1.2f*partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(0).setVida(1.2f*partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(0).setVida(1.2f*partida.getJugador().getDanoMultiplicador());
        partida.getJugador().anadirGolpes(3);
        System.out.println();
        Platform.runLater(() -> txt.appendText("Has golpeado 3 veces a " + partida.getEnemigos().get(0).getNombre() + "\n"));
        
    }
    
}

package com.example.Modelo.Efectos;

import com.example.Modelo.Partida;
import com.example.Modelo.Efectos.Efecto;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class Ascua implements Efecto {

    @Override
    public void estrategia(Partida partida, TextArea txt) {
        partida.getEnemigos().get(0).setVida(1);
        partida.getJugador().anadirGolpes(1);
        System.out.println();
        Platform.runLater(() -> txt.appendText("Has establecido la vida de " + partida.getEnemigos().get(0).getNombre() + " en 1" + "\n"));
        
    }
    
}

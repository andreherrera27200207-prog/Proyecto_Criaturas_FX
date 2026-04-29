package com.example.Modelo.Efectos;

import com.example.Modelo.Partida;
import com.example.Modelo.Efectos.Efecto;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class ParaAquellosQueVenganDespues implements Efecto{

    @Override
    public void estrategia(Partida partida, TextArea txt) {
        partida.getJugador().setDanoMultiplicador(partida.getJugador().getDanoMultiplicador()+1.0f);
        partida.getJugador().Ftwca(partida.getJugador().getTurnos());
        System.out.println();
        Platform.runLater(() -> txt.appendText("En el siguiente turno tienes +1 de multiplicador de daño" + "\n"));
        System.out.println();
        
    }

}

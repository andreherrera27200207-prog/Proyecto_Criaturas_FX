package com.example.Modelo.Efectos;

import com.example.Modelo.Partida;
import com.example.Modelo.Efectos.Efecto;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

 /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     * @version 1.0
     * @since 1.0
     */

public class ParaAquellosQueVenganDespues implements Efecto{

    /**
     * comportamiento del ataque ParaAquellosQueVenganDespues
     */
    @Override
    public void estrategia(Partida partida, TextArea txt) {
        partida.getJugador().setDanoMultiplicador(partida.getJugador().getDanoMultiplicador()+1.0f);
        partida.getJugador().Ftwca(partida.getJugador().getTurnos());
        System.out.println();
        Platform.runLater(() -> txt.appendText("En el siguiente turno tienes +1 de multiplicador de daño" + "\n"));
        System.out.println();
        
    }

}

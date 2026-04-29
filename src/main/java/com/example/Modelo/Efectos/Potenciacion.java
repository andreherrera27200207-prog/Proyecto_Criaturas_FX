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

public class Potenciacion implements Efecto{

    /**
     * comportamiento del ataque Potenciacion
     */
    @Override
    public void estrategia(Partida partida, TextArea txt) {
        partida.getJugador().setDanoMultiplicador(partida.getJugador().getDanoMultiplicador()+0.2f);
        System.out.println();
        Platform.runLater(() -> txt.appendText("Se ha subido tu multiplicador de daño en 0.2, ahora es de " + partida.getJugador().getDanoMultiplicador() + "\n"));
        System.out.println();
    }

}

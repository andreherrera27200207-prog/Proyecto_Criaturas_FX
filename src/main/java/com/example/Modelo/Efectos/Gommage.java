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

public class Gommage implements Efecto{

    /**
     * comportamiento del ataque Gommage
     */

    @Override
    public void estrategia(Partida partida, TextArea txt) {
        partida.getEnemigos().get(0).recibirDano(4*partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(1).recibirDano(2*partida.getJugador().getDanoMultiplicador());
        partida.getJugador().anadirGolpes(2);
        System.out.println();
        Platform.runLater(() -> txt.appendText("Has hecho " + 4*(partida.getJugador().getDanoMultiplicador()) + " a " + partida.getEnemigos().get(0).getNombre() + " y la mitad a " + partida.getEnemigos().get(1).getNombre() + "\n"));
        System.out.println();
    }

}

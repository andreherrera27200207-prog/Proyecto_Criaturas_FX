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

public class Sobrecarga implements Efecto{

    /**
     * comportamiento del ataque Sobrecarga
     */
    @Override
    public void estrategia(Partida partida, TextArea txt) {
        partida.getEnemigos().get(0).recibirDano(partida.getJugador().getNGolpes()*partida.getJugador().getDanoMultiplicador());
        partida.getJugador().anadirGolpes(1);
        System.out.println();
        Platform.runLater(() -> txt.appendText("Has hecho " + partida.getJugador().getNGolpes()*partida.getJugador().getDanoMultiplicador() + " de daño a " + partida.getEnemigos().get(0).getNombre() + "\n"));
    }

}

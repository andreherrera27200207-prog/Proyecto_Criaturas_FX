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

public class Ascua implements Efecto {

    /**
     * comportamiento del ataque Ascuas
     */
    @Override
    public void estrategia(Partida partida, TextArea txt) {
        partida.getEnemigos().get(0).setVida(1);
        partida.getJugador().anadirGolpes(1);
        System.out.println();
        Platform.runLater(() -> txt.appendText("Has establecido la vida de " + partida.getEnemigos().get(0).getNombre() + " en 1" + "\n"));
        
    }
    
}

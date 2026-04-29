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

public class TripleGolpe implements Efecto{

    /**
     * comportamiento del ataque TripleGolpe
     */
    @Override
    public void estrategia(Partida partida, TextArea txt) {
        partida.getEnemigos().get(0).setVida(partida.getEnemigos().get(0).getVida()-1.2f*partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(0).setVida(partida.getEnemigos().get(0).getVida()-1.2f*partida.getJugador().getDanoMultiplicador());
        partida.getEnemigos().get(0).setVida(partida.getEnemigos().get(0).getVida()-1.2f*partida.getJugador().getDanoMultiplicador());
        partida.getJugador().anadirGolpes(3);
        System.out.println();
        Platform.runLater(() -> txt.appendText("Has golpeado 3 veces a " + partida.getEnemigos().get(0).getNombre() + " haciendo " + 1.2f*partida.getJugador().getDanoMultiplicador() + " de daño tres veces (" + (1.2f*partida.getJugador().getDanoMultiplicador()) * 3 + ")\n"));
        
    }
    
}

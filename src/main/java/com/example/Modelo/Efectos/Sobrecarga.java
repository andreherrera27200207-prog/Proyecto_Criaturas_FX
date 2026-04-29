package com.example.Modelo.Efectos;

import com.example.Modelo.Partida;
import com.example.Modelo.Efectos.Efecto;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class Sobrecarga implements Efecto{

    @Override
    public void estrategia(Partida partida, TextArea txt) {
        partida.getEnemigos().get(0).recibirDano(partida.getJugador().getNGolpes()*partida.getJugador().getDanoMultiplicador());
        partida.getJugador().anadirGolpes(1);
        System.out.println();
        Platform.runLater(() -> txt.appendText("Has hecho " + partida.getJugador().getNGolpes()*partida.getJugador().getDanoMultiplicador() + " de daño a " + partida.getEnemigos().get(0).getNombre() + "\n"));
    }

}

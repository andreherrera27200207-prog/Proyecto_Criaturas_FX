package com.example.Modelo;

import java.util.List;

public interface InterfaceReaderJugador {

    void guardarJugador(Jugador jugador) throws Exception;

    List<Jugador> leer() throws Exception;

}
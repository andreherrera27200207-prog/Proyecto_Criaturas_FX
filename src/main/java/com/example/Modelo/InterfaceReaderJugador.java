package com.example.Modelo;

import java.util.List;

/**
 * @author Emilio
 * @author Fabricio
 * @author JoseManuel
 */
public interface InterfaceReaderJugador {

    void guardarJugador(Jugador jugador) throws Exception;

    List<Jugador> leer() throws Exception;

}
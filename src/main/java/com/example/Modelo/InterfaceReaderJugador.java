package com.example.Modelo;

import java.util.List;

 /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     * @version 1.0
     * @since 1.0
     */

public interface InterfaceReaderJugador {

    void guardarJugador(Jugador jugador) throws Exception;

    List<Jugador> leer() throws Exception;

}
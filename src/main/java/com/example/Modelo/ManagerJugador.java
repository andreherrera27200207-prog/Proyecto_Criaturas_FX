package com.example.Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
  /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     * @version 1.0
     * @since 1.0
     */


public class ManagerJugador {
    
    private HashMap<String, Jugador> jugadores;

    /**
     * 
     * @return mapa de los jugadores
     */
    public HashMap<String, Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * 
     * @param jugadores
     */
    public void setJugadores(HashMap<String, Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * constructor
     */
    public ManagerJugador() {
        this.jugadores = new HashMap<>();
    }

    /**
     * 
     * @param jugador
     */
    public void guardarJugador(Jugador jugador) {

        jugadores.put(jugador.getNombre(), jugador);
    }

    /**
     * 
     * @param name
     */
    public void eliminarJugador(String name) {
        jugadores.remove(name);
    }

    /**
     * 
     * @param name
     * @return el jugador que se ha buscado con el nombre
     */
    public Jugador buscarJugador(String name) {

        return jugadores.get(name);

    }

    /**
     * funcion que rota los enemigos cuando se ataca a 1.
     */
    public void ordenarEnemigos() {
        List<Jugador> jugadores_ordenados = new ArrayList<>(jugadores.values());
        LinkedHashMap<String, Jugador> mapMezclada = new LinkedHashMap<>();

        Collections.shuffle(jugadores_ordenados);

        for (Jugador jugador : jugadores_ordenados) {
            mapMezclada.put(jugador.getNombre(), jugador);
        }

        setJugadores(mapMezclada);
    }

}

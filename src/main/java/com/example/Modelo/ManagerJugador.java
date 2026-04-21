package com.example.Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ManagerJugador {
    private HashMap<String, Jugador> jugadores;

    public HashMap<String, Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(HashMap<String, Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ManagerJugador() {
        this.jugadores = new HashMap<>();
    }

    public void guardarJugador(Jugador jugador) {

        jugadores.put(jugador.getNombre(), jugador);
    }

    public void eliminarJugador(String name) {
        jugadores.remove(name);
    }

    public Jugador buscarJugador(String name) {

        return jugadores.get(name);

    }

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

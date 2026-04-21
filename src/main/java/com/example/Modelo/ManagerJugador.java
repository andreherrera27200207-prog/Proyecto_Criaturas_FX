package com.example.Modelo;

import java.util.HashMap;

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

    public void guardarJugador(Jugador jugador){

        jugadores.put(jugador.getNombre(), jugador);
    }

    public void eliminarJugador(String name){
        jugadores.remove(name);
    }

    public Jugador buscarJugador(String name){

        return jugadores.get(name);

    }


    
}

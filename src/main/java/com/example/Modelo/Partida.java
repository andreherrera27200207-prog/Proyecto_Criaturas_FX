package com.example.Modelo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Partida {
    private Jugador jugador;
    private List<Jugador> enemigos;
    Map<String, Jugador> personajes;

    public Partida(Jugador jugadorElegido){
        jugador = jugadorElegido;
        this.personajes = cargarPersonajes();
        this.enemigos = new ArrayList<>();

        for (Jugador p : personajes.values()) {
            if (!p.nombre.equals(jugadorElegido.nombre)) {
                this.enemigos.add(p);
            }
        }
        //Para hacer que los enemigos sean los jugadores no elegidos
        
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public List<Jugador> getEnemigos() {
        return this.enemigos;
    }

    public void setEnemigos(List<Jugador> enemigos) {
        this.enemigos = enemigos;
    }

    public Map<String,Jugador> getPersonajes() {
        return this.personajes;
    }

    public void setPersonajes(Map<String,Jugador> personajes) {
        this.personajes = personajes;
    }


    public Map<String, Jugador> cargarPersonajes() {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            // Buscamos el archivo en src/main/resources/personajes.json
            InputStream is = getClass().getResourceAsStream("/personajes.json");
            
            if (is == null) {
                throw new Exception("¡No se encontró el archivo JSON!");
            }

            // 1. Convertimos el JSON en una Lista temporal
            List<Jugador> listaTemporal = mapper.readValue(is, new TypeReference<List<Jugador>>(){});


            Map<String, Jugador> diccionario = listaTemporal.stream()
                .collect(Collectors.toMap(j -> j.nombre, j -> j));

            return diccionario;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
}

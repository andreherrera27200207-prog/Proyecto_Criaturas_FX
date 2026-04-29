package com.example.Modelo;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import com.example.Modelo.Efectos.Gommage;
import com.example.Modelo.Efectos.ParaAquellosQueVenganDespues;
import com.example.Modelo.Efectos.Potenciacion;
import com.example.Modelo.Efectos.Rayo;
import com.example.Modelo.Efectos.Sobrecarga;
import com.example.Modelo.Efectos.TripleGolpe;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Partida {

    private Jugador jugador;
    private List<Jugador> enemigos;
    private Map<String, Jugador> personajes;


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


    public Partida(Jugador jugadorElegido) {

        this.jugador = jugadorElegido;

        ReaderJugador reader = new ReaderJugador();

        try {
            this.personajes = reader.leer()
                .stream()
                .collect(Collectors.toMap(Jugador::getNombre, j -> j));
        } catch (Exception e) {
            e.printStackTrace();
            this.personajes = new HashMap<>();
        }

        this.enemigos = new ArrayList<>();

        if (jugadorElegido != null) {
            for (Jugador p : personajes.values()) {
                if (!p.getNombre().equals(jugadorElegido.getNombre())) {
                    this.enemigos.add(p);
                }
            }
        }
    }
}

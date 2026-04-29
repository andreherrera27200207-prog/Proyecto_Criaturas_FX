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

 /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     * @version 1.0
     * @since 1.0
     */

public class Partida {
    private Jugador jugador;
    private List<Jugador> enemigos;
    private Map<String, Jugador> personajes;
    private boolean juegoAcabado;


    /**
     * 
     * @return devuelve el booleano
     */
    public boolean getJuegoAcabado() {
        return this.juegoAcabado;
    }

    /**
     * 
     * @param juegoAcabado
     */
    public void setJuegoAcabado(boolean juegoAcabado) {
        this.juegoAcabado = juegoAcabado;
    }


    /**
     * 
     * @return el jugador
     */
    public Jugador getJugador() {
        return this.jugador;
    }

    /**
     * 
     * @param jugador
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    /**
     * 
     * @return lista de jugadores que son enemigos
     */
    public List<Jugador> getEnemigos() {
        return this.enemigos;
    }

    /**
     * 
     * @param enemigos
     */
    public void setEnemigos(List<Jugador> enemigos) {
        this.enemigos = enemigos;
    }

    /**
     * 
     * @return los personajes del juego
     */
    public Map<String, Jugador> getPersonajes() {
        return this.personajes;
    }

    /**
     * 
     * @param personajes
     */
    public void setPersonajes(Map<String, Jugador> personajes) {
        this.personajes = personajes;
    }


    /**
     * 
     * @param jugadorElegido
     */
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

    /**
     * 
     * @param lista
     * @return el boleano para ordenarEnemigos
     */
    public List<Jugador> ordenarEnemigos(List<Jugador> lista) {     
        boolean flag = false;
        for(Jugador jugador : lista){
            if(jugador.getVida() > 0)
                flag = true;
        }
        
        while(lista.get(0).getVida() <= 0 && flag){
            Jugador primero = lista.remove(0);
            lista.add(primero);           
        }
        return lista;
    }

    public boolean todosMuertos(List<Jugador> enemigos) {
        for (Jugador e : enemigos) {
            if (e.getVida() > 0) {
                return false;
            }
        }
    return true;
}

    
}

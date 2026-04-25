package com.example.Modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReaderJugador implements InterfaceReaderJugador {
    private Path carpeta;
    private Path fichero;
    private Gson gson;

    public ReaderJugador(String ruta_carpeta, String ruta_fichero) throws IOException {
        this.carpeta = Paths.get(ruta_carpeta);
        if (!Files.exists(carpeta)) {
            Files.createDirectories(carpeta);
        }

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        this.fichero = carpeta.resolve(ruta_fichero);
        if (!Files.exists(fichero)) {

            Files.createFile(fichero);
        }

    }

   
    @Override
    public void guardarJugador(Jugador jugador) throws Exception {

        List<Jugador> lista = leer();

        lista.add(jugador);

        String json = gson.toJson(lista);

        Files.writeString(fichero, json, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void actualizarJSON(List<Jugador> lista_actualizada) throws IOException{
        String json = gson.toJson(lista_actualizada);
        Files.writeString(fichero, json, 
        java.nio.file.StandardOpenOption.CREATE, 
        java.nio.file.StandardOpenOption.TRUNCATE_EXISTING, 
        java.nio.file.StandardOpenOption.WRITE);
    }

   
    @Override
    public List<Jugador> leer() throws Exception {
        if (Files.size(fichero) == 0) {
            return new ArrayList<>();
        }

        String contenido = Files.readString(fichero);

        java.lang.reflect.Type tipoLista = new com.google.gson.reflect.TypeToken<ArrayList<Jugador>>() {
        }.getType();
        List<Jugador> jugadores_json = gson.fromJson(contenido, tipoLista);

        return (jugadores_json != null) ? jugadores_json : new ArrayList<>();
    }

    

}

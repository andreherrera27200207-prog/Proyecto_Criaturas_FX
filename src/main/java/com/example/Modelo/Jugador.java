package com.example.Modelo;

//import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Jugador {

    @JsonProperty("Jugador") 
    public String jugadorTag;

    static int contadorAtaque = 0;
    static String mensaje = "";
    public float vida;
    public String nombre;
    public int monocos;
    public float danoMultiplicador;
    public int segundosVisibles;
    public int monocosPorParry;
    public int turnos; //turnos desde que empezó la partida
    public boolean ftwca; //variable de un ataque
    private int turnoDesactivacion; //variable de un ataque
    public int nGolpes; //variable para varios ataques
    // protected List<String> ataqueString;
    // protected List<Ataque> ataqueLista;
    // protected Ataque ataqueElegido;

    public Jugador(){

    }


    public int getTurnoDesactivacion() {
        return this.turnoDesactivacion;
    }

    public void setTurnoDesactivacion(int turnoDesactivacion) {
        this.turnoDesactivacion = turnoDesactivacion;
    }

    public int getNGolpes() {
        return this.nGolpes;
    }

    public void setNGolpes(int nGolpes) {
        this.nGolpes = nGolpes;
    }

    public void recibirDano(float damage){
        vida-=damage;
    }

    public String getJugadorTag() {
        return this.jugadorTag;
    }

    public void setJugadorTag(String jugadorTag) {
        this.jugadorTag = jugadorTag;
    }

    public int getTurnos() {
        return this.turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public boolean isFtwca() {
        return this.ftwca;
    }

    public boolean getFtwca() {
        return this.ftwca;
    }

    public void setFtwca(boolean ftwca) {
        this.ftwca = ftwca;
    }

    public float getVida() {
        return this.vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonocos() {
        return this.monocos;
    }

    public void setMonocos(int monocos) {
        this.monocos = monocos;
    }

    public float getDanoMultiplicador() {
        return this.danoMultiplicador;
    }

    public void setDanoMultiplicador(float danoMultiplicador) {
        this.danoMultiplicador = danoMultiplicador;
    }

    public int getSegundosVisibles() {
        return this.segundosVisibles;
    }

    public void setSegundosVisibles(int segundosVisibles) {
        this.segundosVisibles = segundosVisibles;
    }

    public int getMonocosPorParry() {
        return this.monocosPorParry;
    }

    public void setMonocosPorParry(int monocosPorParry) {
        this.monocosPorParry = monocosPorParry;
    }

    // public List<String> getAtaqueString() {
    // return this.ataqueString;
    // }
    //
    // public void setAtaqueString(List<String> ataquesString) {
    // this.ataqueString = ataquesString;
    // }

    // public Ataque getAtaqueElegido() {
    // return this.ataqueElegido;
    // }
    //
    // public void setAtaqueElegido(Ataque ataque) {
    // this.ataqueElegido = ataque;
    // }
    //
    // public List<Ataque> getAtaqueLista() {
    // return this.ataqueLista;
    // }
    //
    // public void setAtaqueLista(List<Ataque> ataqueLista) {
    // this.ataqueLista = ataqueLista;
    // }

    public void anadirGolpes(int n){
        nGolpes += n;
    }
    public void Ftwca(int turno){

        turnoDesactivacion = turno + 1;
    }

    public void ejecutarAtaqueEnemigo(int dificultad, int visibilidad, final boolean[] pulsado, TextArea txtArea,
            ManagerJugador mj, ReaderJugador rj)
            throws InterruptedException {

        if (txtArea == null) {
            System.out.println("ERROR: El TextArea no ha llegado al metodo. Revisa el fx:id en Scene Builder.");
            return;
        }

        pulsado[0] = false;

        Thread contadorThread = new Thread(() -> {
            try {
                for (int i = 1; i < dificultad * 2 && !pulsado[0]; i++) {
                    contadorAtaque = i;

                    if (i <= visibilidad) {
                        mensaje = i + "...";
                        Platform.runLater(() -> txtArea.appendText(mensaje));
                    }

                    Thread.sleep(1000);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        contadorThread.start();
        contadorThread.join();

        if (pulsado[0] && contadorAtaque == dificultad) {
            Platform.runLater(() -> txtArea.appendText("\nParry exitoso"));
            Platform.runLater(() -> txtArea.appendText("\nHas conseguido " + monocosPorParry + " Monoco(s)"));
            monocos += monocosPorParry;
        } else {
            Platform.runLater(() -> txtArea.appendText("\nFallaste (" + contadorAtaque + ")"));
            vida -= 3;
            nGolpes=0;
            if (vida < 0)
                vida = 0;
            Platform.runLater(
                    () -> txtArea.appendText("\nHas perdido " + 3 + " de vida. Tienes " + vida + " puntos de vida"));
        }
        if(turnos == turnoDesactivacion){
            danoMultiplicador-=1;
        }
        turnos++;
        mj.ordenarEnemigos();
        Platform.runLater(() -> txtArea.appendText("El ataque ha finalizado y los enemigos han rotado"));



        try{

            mj.guardarJugador(this);
            List<Jugador> lista = new ArrayList<>(mj.getJugadores().values());
            rj.actualizarJSON(lista);

        } catch (Exception e){

            e.printStackTrace();
        }

        

    }

    

    @Override
    public String toString() {
        return "Jugador: " + getNombre() + "\n" +
                "--------------------------\n" +
                "Vida: " + getVida() + " HP\n" +
                "Monocos: " + getMonocos() + "\n" +
                "Multiplicador: " + getDanoMultiplicador() + "x\n" +
                "Segundos Visibles: " + getSegundosVisibles() + "s\n" +
                "Monocos por Parry: " + getMonocosPorParry() + "\n" +
                "--------------------------";
    }
}

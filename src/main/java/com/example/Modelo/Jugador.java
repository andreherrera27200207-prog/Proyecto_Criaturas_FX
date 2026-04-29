package com.example.Modelo;

//import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
 /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     * @version 1.0
     * @since 1.0
     */
    
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
    protected List<Ataque> ataqueLista;
    // protected Ataque ataqueElegido;

    public Jugador() {

    }

    public Jugador(String nombre,float vida,int monocos,float danoMultiplicador,int segundosVisibles,int monocosPorParry,List<Ataque> ataqueLista) {
        this.nombre = nombre;
        this.vida = vida;
        this.monocos = monocos;
        this.danoMultiplicador = danoMultiplicador;
        this.segundosVisibles = segundosVisibles;
        this.monocosPorParry = monocosPorParry;
        this.ataqueLista = ataqueLista;

        this.turnos = 0;
        this.ftwca = false;
        this.nGolpes = 0;
        this.turnoDesactivacion = 0;
    }

    

    /**
     * 
     * @return la lista del ataque
     */
    public List<Ataque> getAtaqueLista() {
        return this.ataqueLista;
    }

    public void setAtaqueLista(List<Ataque> ataqueLista) {
        this.ataqueLista = ataqueLista;
    }


    /**
     * 
     * @return turno
     */
    public int getTurnoDesactivacion() {
        return this.turnoDesactivacion;
    }

    /**
     * 
     * @param turnoDesactivacion
     */
    public void setTurnoDesactivacion(int turnoDesactivacion) {
        this.turnoDesactivacion = turnoDesactivacion;
    }

    /**
     * 
     * @return ngolpes
     */
    public int getNGolpes() {
        return this.nGolpes;
    }

    /**
     * 
     * @param nGolpes
     */
    public void setNGolpes(int nGolpes) {
        this.nGolpes = nGolpes;
    }

    /**
     * 
     * @param damage
     */
    public void recibirDano(float damage) {
        vida -= damage;
    }

    /**
     * 
     * @return el tag del jugador
     */
    public String getJugadorTag() {
        return this.jugadorTag;
    }

    /**
     * 
     * @param jugadorTag
     */
    public void setJugadorTag(String jugadorTag) {
        this.jugadorTag = jugadorTag;
    }

    /**
     * 
     * @return los turnos del jugador
     */
    public int getTurnos() {
        return this.turnos;
    }

    /**
     * 
     * @param turnos
     */
    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    /**
     * 
     * @return ftwca
     */
    public boolean isFtwca() {
        return this.ftwca;
    }

    /**
     * 
     * @return ftwca cambiado
     */
    public boolean getFtwca() {
        return this.ftwca;
    }

    /**
     * 
     * @param ftwca
     */
    public void setFtwca(boolean ftwca) {
        this.ftwca = ftwca;
    }

    /**
     * 
     * @return la vida del jugador
     */
    public float getVida() {
        return this.vida;
    }

    /**
     * 
     * @param vida
     */
    public void setVida(float vida) {
        this.vida = vida;
    }

    /**
     * 
     * @return nombre del jugador
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return monococos del jugador
     */
    public int getMonocos() {
        return this.monocos;
    }

    /**
     * 
     * @param monocos
     */
    public void setMonocos(int monocos) {
        this.monocos = monocos;
    }

    /**
     * 
     * @return el danoMultiplicador del jugador
     */
    public float getDanoMultiplicador() {
        return this.danoMultiplicador;
    }

    /**
     * 
     * @param danoMultiplicador
     */
    public void setDanoMultiplicador(float danoMultiplicador) {
        this.danoMultiplicador = danoMultiplicador;
    }

    /**
     * 
     * @return segundos visibles que tiene el jugador
     */
    public int getSegundosVisibles() {
        return this.segundosVisibles;
    }

    /**
     * 
     * @param segundosVisibles
     */
    public void setSegundosVisibles(int segundosVisibles) {
        this.segundosVisibles = segundosVisibles;
    }

    /**
     * 
     * @return los monococos ganados por un parry
     */
    public int getMonocosPorParry() {
        return this.monocosPorParry;
    }

    /**
     * 
     * @param monocosPorParry
     */
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

    /**
     * 
     * @param n
     */
    public void anadirGolpes(int n){
        nGolpes = nGolpes + n;
    }

    /**
     * 
     * @param turno
     */
    public void Ftwca(int turno) {

        turnoDesactivacion = turno + 1;
    }

    /**
     * 
     * @param dificultad
     * @param visibilidad
     * @param pulsado
     * @param txtArea
     * @param mj
     * @throws InterruptedException
     */
    public void ejecutarAtaqueEnemigo(int dificultad, int visibilidad, final boolean[] pulsado, TextArea txtArea,
            ManagerJugador mj, ReaderJugador rj)
            throws InterruptedException {

        if (txtArea == null) {
            System.out.println("ERROR: El TextArea no ha llegado al metodo. Revisa el fx:id en Scene Builder.");
            return;
        } else {
            Platform.runLater(() -> txtArea.appendText("El ataque es de dificultad: " + dificultad + "\n"));
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

                    Thread.sleep(500);

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
            nGolpes = 0;
            if (vida < 0)
                vida = 0;
            Platform.runLater(
                    () -> txtArea.appendText("\nHas perdido " + 3 + " de vida. Tienes " + vida + " puntos de vida\n"));
        }
        if(turnos == turnoDesactivacion){
            //una movida de un ataque
            danoMultiplicador-=1;
        }
        turnos++;
        //mj.ordenarEnemigos();
        Platform.runLater(() -> txtArea.appendText("\nEl ataque ha finalizado y los enemigos han rotado\n"));



        try{

            mj.guardarJugador(this);
            List<Jugador> lista = new ArrayList<>(mj.getJugadores().values());
            //rj.actualizarJSON(lista);

        } catch (Exception e){

            e.printStackTrace();
        }

        

    }

    /**
     * devuelve los valores del jugador cuando se acceda a el imprimiendo el jugador por pantalla
     */
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

    /**
     * 
     * @param ataqueSeleccionado
     * @param partida
     * @param txt
     */

    public void ejecutarAtaque(Ataque ataqueSeleccionado, Partida partida, TextArea txt) {

        if (ataqueSeleccionado == null) {
        System.out.println("No hay ataque seleccionado");  
        } else {
            ataqueSeleccionado.getEfecto().estrategia(partida, txt);
        }
    }
}

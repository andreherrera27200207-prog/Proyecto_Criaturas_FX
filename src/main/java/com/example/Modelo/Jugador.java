package com.example.Modelo;

//import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class Jugador {
    static int contadorAtaque = 0;
    static String mensaje = "";
    protected float vida;
    protected String nombre;
    protected int monocos;
    protected float danoMultiplicador;
    protected int segundosVisibles;
    protected int monocosPorParry;
    // protected List<String> ataqueString;
    // protected List<Ataque> ataqueLista;
    // protected Ataque ataqueElegido;

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

    public void ejecutarAtaqueEnemigo(int dificultad, int visibilidad, final boolean[] pulsado, TextArea txtArea,
            ManagerJugador mj)
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
            Platform.runLater(() -> txtArea.appendText("Parry exitoso"));
            Platform.runLater(() -> txtArea.appendText("Has conseguido " + monocosPorParry + " Monoco(s)"));
            monocos += monocosPorParry;
        } else {
            Platform.runLater(() -> txtArea.appendText("Fallaste (" + contadorAtaque + ")"));
            vida -= 3;
            if (vida < 0)
                vida = 0;
            Platform.runLater(
                    () -> txtArea.appendText("Has perdido " + 3 + " de vida. Tienes " + vida + " puntos de vida"));
        }

        mj.ordenarEnemigos();
        Platform.runLater(() -> txtArea.appendText("El ataque ha finalizado y los enemigos han rotado"));
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

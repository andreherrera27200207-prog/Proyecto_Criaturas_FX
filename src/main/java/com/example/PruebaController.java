package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import com.example.Modelo.Ataque;
import com.example.Modelo.Jugador;
import com.example.Modelo.ManagerJugador;
import com.example.Modelo.Partida;
import com.example.Modelo.ReaderJugador;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PruebaController implements Initializable {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    final boolean[] verdad = { false };

    private Jugador jugadorGeneral;

    private ManagerJugador mj;
    private ReaderJugador rj;
    private Partida partida;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        
        
        try {
            rj = new ReaderJugador();
            mj = new ManagerJugador();

            List<Jugador> jugadores = rj.leer();

            for (Jugador jugador : jugadores) {
                mj.guardarJugador(jugador);
            }

            

        } catch (IOException e) {

            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }

        

        btnEmpezar.setOnAction(event -> {

            Empezar();
        });

        btnAtaque.setOnAction(event -> {
            Ataque ataque = cmbAtaques.getValue();
            if(jugadorGeneral.getMonocos()>=ataque.getCoste()){
                jugadorGeneral.ejecutarAtaque(ataque, partida, txtArea);
                jugadorGeneral.setMonocos(jugadorGeneral.getMonocos()-ataque.getCoste());
            } else {
                Platform.runLater(() -> txtArea.appendText("No tienes suficientes Monocos!!!"));
            }
            
            lblVida.setText(String.valueOf(jugadorGeneral.getVida()));
            lblMonocos.setText(String.valueOf(jugadorGeneral.getMonocos()));
        });

        btnDetener.setOnAction(event -> {
            verdad[0] = true;
        });

    }

     

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnEmpezar;

    @FXML
    private Button btnAtaque;

    @FXML
    private Button btnDetener;

    @FXML
    private Label lblVida;

    @FXML
    private Label lblMonocos;

    @FXML
    private Label lblJugador;
    
    @FXML
    private ComboBox<Ataque> cmbAtaques;

    public void buscarPorNombre() {
        jugadorGeneral = mj.buscarJugador(txtNombre.getText());
        txtNombre.setText("");
        lblJugador.setText(jugadorGeneral.getNombre());
        
        
    }

    public void cargarDatos(Jugador jugador){
        this.jugadorGeneral = jugador;
        partida = new Partida(jugadorGeneral);
        lblJugador.setText(jugadorGeneral.getNombre());
        cmbAtaques.setItems(FXCollections.observableArrayList(jugadorGeneral.getAtaqueLista()));
        lblVida.setText(String.valueOf(jugadorGeneral.getVida()));
        lblMonocos.setText(String.valueOf(jugadorGeneral.getMonocos()));
        
    }

    public void Empezar() {
        new Thread(() -> {

            try {
                Random random = new Random();
                jugadorGeneral.ejecutarAtaqueEnemigo(random.nextInt(10)+5, jugadorGeneral.getSegundosVisibles(), verdad, txtArea, mj, rj);
                
                Platform.runLater(() -> {
                    lblVida.setText(String.valueOf(jugadorGeneral.getVida()));
                    lblMonocos.setText(String.valueOf(jugadorGeneral.getMonocos()));
                });
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }).start();

        
    }

}

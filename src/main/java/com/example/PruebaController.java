package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.Modelo.Jugador;
import com.example.Modelo.ManagerJugador;
import com.example.Modelo.ReaderJugador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        
        
        try {
            rj = new ReaderJugador("carpeta", "jugadores.json");
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

        btnBuscar.setOnAction(event -> {
            buscarPorNombre();
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
    private Button btnBuscar;

    @FXML
    private Button btnEmpezar;

    @FXML
    private Button btnDetener;

    @FXML
    private Label lblJugador;

    public void buscarPorNombre() {
        jugadorGeneral = mj.buscarJugador(txtNombre.getText());
        txtNombre.setText("");
        lblJugador.setText(jugadorGeneral.getNombre());
        
        
    }

    public void cargarDatos(Jugador jugador){
        this.jugadorGeneral = jugador;
        lblJugador.setText(jugadorGeneral.getNombre());
    }

    public void Empezar() {
        new Thread(() -> {

            try {
                jugadorGeneral.ejecutarAtaqueEnemigo(5, 3, verdad, txtArea, mj, rj);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }).start();
    }

}

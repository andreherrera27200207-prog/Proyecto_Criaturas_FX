package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.Modelo.Jugador;
import com.example.Modelo.ManagerJugador;
import com.example.Modelo.ReaderJugador;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrimaryController implements Initializable {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    final boolean[] verdad = { false };

    private Jugador jugadorGeneral;

    private ManagerJugador mj;
    private ReaderJugador rj;

    @FXML

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

        });

        cbojugador.setItems(FXCollections.observableArrayList("Fabricio_Master", "Entrenador_Pro", "Shadow_Player",
                "SpeedRunner", "Tank_User"));

        cbojugador.setOnAction(event -> {

            String jugador = (String) cbojugador.getValue();
            jugadorGeneral = mj.buscarJugador(jugador);

            if (jugadorGeneral != null) {
                txtjugadorelegido.setText(jugadorGeneral.getNombre());
            }

        });

    }

    @FXML
    private TextField txtjugadorelegido;

    @FXML
    private Button btnEmpezar;

    @FXML
    private ComboBox cbojugador;

    public void Empezar() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/secondary.fxml"));
        // Parent root = loader.load();

        SecondaryController controllerSecond = loader.getController();

        if (jugadorGeneral != null) {
            // controllerSecond.cargarDatos(jugadorGeneral);
            // Scene escena = new Scene(root);
            Stage stage = (Stage) btnEmpezar.getScene().getWindow();
            // stage.setScene(escena);
            stage.show();
        } else {
            btnEmpezar.setText("ERROR: Asegúrate de escribir bien los nombres de los Pokémon.");
        }
    }

}

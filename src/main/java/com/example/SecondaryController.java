package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {
    /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     */
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
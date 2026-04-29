package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
 /**
     * @author Emilio
     * @author Fabricio
     * @author JoseManuel
     * @version 1.0
     * @since 1.0
     */
    
public class SecondaryController {
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
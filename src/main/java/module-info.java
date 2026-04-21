module com.example {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.base;

    opens com.example to javafx.fxml;
    opens com.example.Modelo to com.google.gson;
    exports com.example;
    exports com.example.Modelo;
}

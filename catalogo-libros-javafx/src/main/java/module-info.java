module com.biblioteca.catalogolibrosjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.biblioteca to javafx.fxml;
    opens com.biblioteca.controller to javafx.fxml;

    exports com.biblioteca;
}
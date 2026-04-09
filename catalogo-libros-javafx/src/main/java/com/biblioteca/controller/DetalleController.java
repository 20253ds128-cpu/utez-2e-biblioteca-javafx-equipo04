package com.biblioteca.controller;

import com.biblioteca.model.Libro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class DetalleController {
    @FXML
    private Label lblIsbn;
    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblAutor;
    @FXML
    private Label lblAnio;
    @FXML
    private Label lblGenero;
    @FXML
    private Label lblDisponible;
    @FXML
    private Button btnRegresar;

    public void  setLibro(Libro libro){
        lblIsbn.setText(libro.getIsbn());
        lblTitulo.setText(libro.getTitulo());
        lblAutor.setText(libro.getAutor());
        lblAnio.setText(String.valueOf(libro.getAnio()));
        lblGenero.setText(libro.getGenero());
        lblDisponible.setText(libro.getDisponible() ? "Disponible" : "No disponible");

        if (libro.getDisponible()){
            lblDisponible.setStyle("-fx-background-color: #f0f0f0");
        }else {
            lblDisponible.setStyle("-fx-background-color: #e74c3c");
        }
    }

    @FXML
    private void onRegresar(){
        Stage stage = (Stage) btnRegresar.getScene().getWindow();
        stage.close();
    }
}

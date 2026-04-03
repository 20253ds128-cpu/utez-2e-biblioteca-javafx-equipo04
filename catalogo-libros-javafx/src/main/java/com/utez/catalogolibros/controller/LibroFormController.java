package com.utez.catalogolibros.controller;

import com.utez.catalogolibros.model.Libro;
import com.utez.catalogolibros.repository.LibroRepository;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LibroFormController {

    @FXML
    private TextField txtIsbn;

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtGenero;

    @FXML
    private CheckBox chkDisponible;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;

    private final LibroRepository repository = new LibroRepository();

    @FXML
    private void onGuardar() {
        try {
            String isbn = txtIsbn.getText();
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            int anio = Integer.parseInt(txtAnio.getText());
            String genero = txtGenero.getText();
            boolean disponible = chkDisponible.isSelected();

            Libro libro = new Libro(isbn, titulo, autor, anio, genero, disponible);

            var lista = repository.cargarLibros();

            lista.add(libro);

            repository.guardarLibros(lista);

            Stage stage = (Stage) btnGuardar.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package com.biblioteca;

import com.biblioteca.service.LibroService;

import java.io.IOException;

public class MainApp extends Application {

    private static LibroService libroService;

    @Override
    public void start(Stage primaryStage) throws IOException {
        libroService = new LibroService();
    }
}

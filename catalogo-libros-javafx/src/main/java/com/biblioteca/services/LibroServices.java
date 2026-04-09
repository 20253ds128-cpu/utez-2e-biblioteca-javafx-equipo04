package com.biblioteca.services;

import com.biblioteca.model.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibroServices {

    private static final String ARCHIVO_DATOS = "data/catalogo.csv";
    private static final String ARCHIVO_REPORTE = "data/reporte_catalogo.csv";
    private static final String SEPARADOR = ":";
    private static final int ANIO_MIN = 1500;

    private final List<Libro> catalogo = new ArrayList<>();

    public LibroServices(){
        cargarDesdeArchivo();
    }

    public void agregar(Libro libro) {
        validar(libro);
        if (existeIsbn(libro.getIsbn())) {
            throw new IllegalArgumentException("ya existe un libro con el ISBN:");

        }
        catalogo.add(libro);
        guardarEnArchivo();
    }

    public List<Libro> obetenerTodos(){
        return new ArrayList<>(catalogo);
    }

    public Optional<Libro> busquedaPorIsbn(String  isbn){
        return catalogo.stream().filter(lib-> lib.getIsbn().equalsIgnoreCase(isbn)).findFirst();

    }
    public void actualizar(String isbnOriginal, Libro actualizacion){
        validar(actualizacion);
        if (!isbnOriginal.equalsIgnoreCase((actualizacion.getIsbn()) && existeIsbn(actualizacion.getIsbn()))){
            throw new IllegalArgumentException("ya existe un libro con el ISBN:" + actualizacion.getIsbn());

        }
        for (int i =0; i< catalogo.size();i++){
            if (catalogo.get(i).getIsbn().equalsIgnoreCase(isbnOriginal)){
                catalogo.set(i, actualizacion);
                guadarEnArchivo();
                return;
            }
        }
        throw new IllegalArgumentException("No se encontro el libro con ISBN:"+ isbnOriginal);

    }


}

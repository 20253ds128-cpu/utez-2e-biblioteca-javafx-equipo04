package com.biblioteca.services;

import com.biblioteca.model.Libro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

public void eliminar (String isbn){
        boolean eliminado = catalogo.removeIf(lib-> lib.getIsbn().equalsIgnoreCase(isbn));
        if (!eliminado){
            throw new IllegalArgumentException("No se encontro el libro con ISBN:" + isbn);

        }
        guardarEnArchivo();
}

public void cargarDesdeArchivo(){
        catalogo.clear();
        File archivo = new File (ARCHIVO_DATOS);

        if (!archivo.exists()){
            System.out.println("[LibroServices] Archivo de datos no encontrado. Se iniciara con catalogo vacio");
            return;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null){
                numeroLinea++;
                linea = linea.trim();
                if (linea.isEmpty() || linea.startsWith("#")) continue;

                String[] partes = linea.split(SEPARADOR, -1);
                if (partes.length != 6){
                    System.out.printf("Linea " + numeroLinea + "mal formada , se omite" + linea);
                    continue;
                }
                try {
                    String isbn      = partes[0].trim();
                    String titulo    = partes[1].trim();
                    String autor     = partes[2].trim();
                    int    anio      = Integer.parseInt(partes[3].trim());
                    String genero    = partes[4].trim();
                    boolean disp     = partes[5].trim().equalsIgnoreCase("true");

                    catalogo.add(new Libro(isbn, titulo, autor, anio, genero, disp));
                } catch (NumberFormatException e) {
                    System.err.println("[LibroService] Error de formato en línea " + numeroLinea + ": " + e.getMessage());
                }
            }
            System.out.println("[LibroService] Catálogo cargado: " + catalogo.size() + " libro(s).");

        } catch (IOException e) {
            System.err.println("[LibroService] Error al leer el archivo: " + e.getMessage());
        }
}

            }

}
}

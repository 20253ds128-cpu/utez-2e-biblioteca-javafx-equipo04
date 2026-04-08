package com.biblioteca.model;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String anio;
    private String genero;
    private String disponible;

    public Libro (String isbn,String titulo,String autor,String anio,String genero,String disponible) {
        this.isbn =isbn;
        this.titulo =titulo;
        this.autor =autor;
        this.anio =anio;
        this.genero =genero;
        this.disponible =disponible;

    }

    public Libro(){}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDisponible(){
        this.disponible = disponible;
        return disponible;
    }

    public void setDisponible(boolean disponible){
        this.disponible =disponible;
    }

    @Override
    public String toString(){
        return String.format("Libor{isbn=, titulo=, autor=, anio=, genero=, disponible=%s}", isbn, titulo, autor, anio, genero, disponible);

    }
}

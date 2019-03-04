package com.example.iowner.a12multimedia;

/**
 * Created by iOwner on 01/03/2019.
 */

public class Archivo {
    private String tipo;
    private String nombre;
    private String artista;
    private int id;

    public Archivo(String tipo, String nombre, String artista, int id) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.artista = artista;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo(){
        return tipo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}

package com.example.telassimgomez.studyjam_proyectofinal;

import java.io.Serializable;

public class Colores implements Serializable {
    private String Nombre;
    private String Tipo;
    private int Imagen;
    private String Descripcion;
    private int ImagenDetalle;

    public Colores() {
    }

    public Colores(String nombre) {
        Nombre = nombre;
    }

    public Colores(String nombre, String habilidades) {
        Nombre = nombre;
        Tipo = habilidades;
    }

    public Colores(String nombre, String habilidades, int imagen) {
        Nombre = nombre;
        Tipo = habilidades;
        Imagen = imagen;
    }
    public Colores(String nombre, String habilidades, int imagen, String descripcion){
        Nombre = nombre;
        Tipo = habilidades;
        Imagen = imagen;
        Descripcion = descripcion;
    }

    public Colores(String nombre, String habilidades, int imagen, String descripcion, int imagendetalle){
        Nombre = nombre;
        Tipo = habilidades;
        Imagen = imagen;
        Descripcion = descripcion;
        ImagenDetalle = imagendetalle;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getHabilidades() {
        return Tipo;
    }

    public void setHabilidades(String habilidades) {
        Tipo = habilidades;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getImagenDetalle() {
        return ImagenDetalle;
    }

    public void setImagenDetalle(int imagendetalle) { ImagenDetalle = imagendetalle; }
}

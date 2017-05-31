package com.example.telassimgomez.studyjam_proyectofinal;

import java.io.Serializable;


public class PuntosR implements Serializable {
    private String Nombre;
    private int Imagen;
    private String Ciudad;
    private String Direccion;
    private String Telefono;
    private String Celular;
    public PuntosR() {
    }

    public PuntosR(String nombre) {
        Nombre = nombre;
    }

    public PuntosR(String nombre, int imagen) {
        Nombre = nombre;
        Imagen = imagen;
    }
    public PuntosR(String nombre, int imagen, String ciudad) {
        Nombre = nombre;
        Imagen = imagen;
        Ciudad = ciudad;
    }
    public PuntosR(String nombre, int imagen, String ciudad, String direccion) {
        Nombre = nombre;
        Imagen = imagen;
        Ciudad = ciudad;
        Direccion = direccion;
    }
    public PuntosR(String nombre, int imagen, String ciudad, String direccion, String telefono, String celular) {
        Nombre = nombre;
        Imagen = imagen;
        Ciudad = ciudad;
        Direccion = direccion;
        Telefono = telefono;
        Celular = celular;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getImagenP() {
        return Imagen;
    }

    public void setImagenP(int imagen) {
        Imagen = imagen;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {Ciudad = ciudad; }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }
}

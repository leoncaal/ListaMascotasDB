package com.example.listamascotas.pojo;


public class Mascota {

    private int id;
    private int foto;
    private String nombre;
    private int edad;
    private String raza;
    private int rating;
    private int posicion;

    public Mascota(){

    }

    public Mascota(int id, int foto, String nombre, int edad, String raza, int rating, int posicion) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.rating = rating;
        this.posicion = posicion;

    }

    public Mascota(int foto, int rating) {
        this.foto = foto;
        this.rating = rating;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}

package com.example.listamascotas.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Mascota implements Parcelable {

    private String nombre;
    private int edad;
    private String raza;
    private int rating;
    private int foto;


    public Mascota(int foto, String nombre, int edad, String raza, int rating) {
        this.foto = foto;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.rating = rating;

    }

    public Mascota(int foto, int rating) {
        this.foto = foto;
        this.rating = rating;

    }

    protected Mascota(Parcel in) {
        nombre = in.readString();
        edad = in.readInt();
        raza = in.readString();
        rating = in.readInt();
        foto = in.readInt();
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeInt(edad);
        parcel.writeString(raza);
        parcel.writeInt(rating);
        parcel.writeInt(foto);
    }
}

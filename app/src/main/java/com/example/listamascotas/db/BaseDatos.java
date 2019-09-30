package com.example.listamascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.listamascotas.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATA_BASE_NAME, null, ConstantesBaseDatos.DATA_BASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_EDAD + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_RAZA + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_RATING + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_POSICION + " INTEGER" + ")";

        sqLiteDatabase.execSQL(queryCrearTablaMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        onCreate(sqLiteDatabase);

    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascotaactual = new Mascota();
            mascotaactual.setId(registros.getInt(0));
            mascotaactual.setFoto(registros.getInt(1));
            mascotaactual.setNombre(registros.getString(2));
            mascotaactual.setEdad(registros.getInt(3));
            mascotaactual.setRaza(registros.getString(4));
            mascotaactual.setRating(registros.getInt(5));
            mascotaactual.setPosicion(registros.getInt(6));

            mascotas.add(mascotaactual);

        }

        sqLiteDatabase.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        sqLiteDatabase.close();

    }

    public void insertarLikeMascota(ContentValues contentValues, int i){

        SQLiteDatabase sqLiteDatabase =  this.getWritableDatabase();
        sqLiteDatabase.update(ConstantesBaseDatos.TABLE_MASCOTA, contentValues, ConstantesBaseDatos.TABLE_MASCOTA_ID + " = " + i, null);
        sqLiteDatabase.close();

    }

    public int obtenerLikesMascota (Mascota mascota){

        int likes = 0;

        String query = "SELECT " + ConstantesBaseDatos.TABLE_MASCOTA_RATING + " FROM " + ConstantesBaseDatos.TABLE_MASCOTA + " WHERE " +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " = " + mascota.getId();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        sqLiteDatabase.close();

        return likes;

    }

    public void ponerPosicion(ContentValues contentValues, int i){

        SQLiteDatabase sqLiteDatabase =  this.getWritableDatabase();
        sqLiteDatabase.update(ConstantesBaseDatos.TABLE_MASCOTA, contentValues, ConstantesBaseDatos.TABLE_MASCOTA_ID + " = " + i, null);
        sqLiteDatabase.close();

    }

    public int obtenerUltimaPosicion (){

        int posicionObtenida = 0;

        String query = "SELECT MAX (" + ConstantesBaseDatos.TABLE_MASCOTA_POSICION + ")" + " FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        if (registros.moveToNext()){
            posicionObtenida = registros.getInt(0);
        }

        return posicionObtenida;

    }

    public int obtenerIdUltimaPosicion (){

        int ultimoIdPosicion = 0;

        String query = "SELECT " + ConstantesBaseDatos.TABLE_MASCOTA_ID + " FROM " + ConstantesBaseDatos.TABLE_MASCOTA + " WHERE " +
                ConstantesBaseDatos.TABLE_MASCOTA_POSICION + " = (SELECT MAX (" + ConstantesBaseDatos.TABLE_MASCOTA_POSICION + ")" + " FROM " +
                ConstantesBaseDatos.TABLE_MASCOTA + ")";

        SQLiteDatabase sqLiteDatabase =  this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        if (registros.moveToNext()){
            ultimoIdPosicion = registros.getInt(0);
        }

        return ultimoIdPosicion;
    }

    public ArrayList<Mascota> obtenerCincoMascotas() {

        ArrayList<Mascota> cincoMascotas = new ArrayList<>();

        if (obtenerNumeroMascotasPosicionMayorCero() < 5){

            String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA + " ORDER BY " + ConstantesBaseDatos.TABLE_MASCOTA_POSICION + " DESC LIMIT " + obtenerNumeroMascotasPosicionMayorCero();

            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            Cursor registros = sqLiteDatabase.rawQuery(query, null);

            while (registros.moveToNext()) {
                Mascota mascotaactual = new Mascota();
                mascotaactual.setId(registros.getInt(0));
                mascotaactual.setFoto(registros.getInt(1));
                mascotaactual.setNombre(registros.getString(2));
                mascotaactual.setEdad(registros.getInt(3));
                mascotaactual.setRaza(registros.getString(4));
                mascotaactual.setRating(registros.getInt(5));
                mascotaactual.setPosicion(registros.getInt(6));

                cincoMascotas.add(mascotaactual);
            }

        }else {

            String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA + " ORDER BY " + ConstantesBaseDatos.TABLE_MASCOTA_POSICION + " DESC LIMIT 5";

            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            Cursor registros = sqLiteDatabase.rawQuery(query, null);

            while (registros.moveToNext()) {
                Mascota mascotaactual = new Mascota();
                mascotaactual.setId(registros.getInt(0));
                mascotaactual.setFoto(registros.getInt(1));
                mascotaactual.setNombre(registros.getString(2));
                mascotaactual.setEdad(registros.getInt(3));
                mascotaactual.setRaza(registros.getString(4));
                mascotaactual.setRating(registros.getInt(5));
                mascotaactual.setPosicion(registros.getInt(6));

                cincoMascotas.add(mascotaactual);
            }
        }




        return cincoMascotas;

    }

   public int obtenerNumeroMascotasPosicionMayorCero(){

        int noMascotasPosicionMayorCero = 0;

        String query = "SELECT COUNT(*) FROM " + ConstantesBaseDatos.TABLE_MASCOTA + " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_POSICION + " > 0";

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null);

        if (registros.moveToNext()){
            noMascotasPosicionMayorCero = registros.getInt(0);
        }

        return noMascotasPosicionMayorCero;
    }
}

package com.example.listamascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.listamascotas.R;
import com.example.listamascotas.pojo.Mascota;

import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;
    private String file = "RegistrosInsertados";
    private String[] archivos;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos baseDatos = new BaseDatos(context);
        archivos = context.fileList();

        if (existe(archivos, file)){

        } else {

            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(file, Context.MODE_PRIVATE));
                outputStreamWriter.write("RegistrosOK");
                outputStreamWriter.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            insertarMascotas(baseDatos);
        }

        return baseDatos.obtenerTodasLasMascotas();

    }

    public boolean existe(String[] archivos, String archbusca) {
        for (int f = 0; f < archivos.length; f++)
            if (archbusca.equals(archivos[f]))
                return true;
            return false;
    }


    public void insertarMascotas (BaseDatos baseDatos){

        ContentValues contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.alaska);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rintintin");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Alaska");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.bulldog);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Max");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 4);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Bulldog");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.chihuahua);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rocky");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Chihuahua");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dalmata);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Snup");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 9);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Dalmata");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.doberman);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Brutus");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 12);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Doberman");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.labrador);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Loqui");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Labrador");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.poodle);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Apolo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 15);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Poodle");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.pug);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Black");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Pug");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.rottweiler);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Sanzon");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 18);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "Rottweiler");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.sanbernardo);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Beethoven");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, 10);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RAZA, "San Bernardo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, 0);

        baseDatos.insertarMascota(contentValues);

    }

    public void darLikeMascota (Mascota mascota){

        int idMascota = 0;

        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_RATING, obtenerLikesMascota(mascota) + 1);
        idMascota = mascota.getId();
        baseDatos.insertarLikeMascota(contentValues , idMascota);

    }

    public int obtenerLikesMascota(Mascota mascota){

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerLikesMascota(mascota);

    }

    public void ponerPosicion (Mascota mascota){

        int idMascota = 0;

        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_POSICION, obtenerUltimaPosicion(mascota) + 1);
        idMascota = mascota.getId();
        baseDatos.ponerPosicion(contentValues, idMascota);

    }

    public int obtenerUltimaPosicion (Mascota mascota){

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerUltimaPosicion();
    }

    public int obtenerIdUltimaPosicion (Mascota mascota){

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerIdUltimaPosicion();

    }

    public ArrayList<Mascota> obtenerCincoMascotas(){
        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerCincoMascotas();
    }
}

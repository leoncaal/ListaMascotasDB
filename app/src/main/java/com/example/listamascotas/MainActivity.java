package com.example.listamascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <Mascota> mascotas;
    private RecyclerView listaMascotas;
    ArrayList<Mascota> cincoMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionbar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.cincoMas:


                //Toast.makeText(this, "Hiciste click en la estrella", Toast.LENGTH_LONG).show();
                //Intent i = new Intent(this, CincoMascotas.class);
                //startActivity(i);

                cincoMascotas = new ArrayList<Mascota>();

                int iterador;


                for (iterador = 0; mascotas.size() > iterador; iterador ++){

                    if (mascotas.get(iterador).getRating() >= 1) {

                        cincoMascotas.add(new Mascota(mascotas.get(iterador).getFoto(), mascotas.get(iterador).getNombre(), mascotas.get(iterador).getEdad(), mascotas.get(iterador).getRaza(), mascotas.get(iterador).getRating()));
                        Toast.makeText(this, "Tiene " + mascotas.get(iterador).getRating() + " likes " + mascotas.get(iterador).getNombre(), Toast.LENGTH_SHORT).show();
                    }
                }

                Intent i = new Intent(this, CincoMascotas.class);
                i.putParcelableArrayListExtra("CincoMascotas", cincoMascotas);
                startActivity(i);

                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }

    public MascotaAdapter adaptador;

    public void inicializarAdaptador(){
        adaptador = new MascotaAdapter(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.chihuahua, "Rintintin", 3, "Chihuahua",0));
        mascotas.add(new Mascota(R.drawable.dalmata, "Scooby", 1, "Dalmata",0));
        mascotas.add(new Mascota(R.drawable.poodle, "Rocky", 5, "Poodle",0));
        mascotas.add(new Mascota(R.drawable.pug, "Peluso", 8, "Pug",0));
        mascotas.add(new Mascota(R.drawable.rottweiler, "Snup", 2, "Rottweiler",0));
    }

}

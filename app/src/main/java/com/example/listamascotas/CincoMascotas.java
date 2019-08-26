package com.example.listamascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.listamascotas.adapter.MascotaAdapter;
import com.example.listamascotas.pojo.Mascota;

import java.util.ArrayList;

public class CincoMascotas extends AppCompatActivity {

    private RecyclerView listaCincoMascotas;
    private ArrayList<Mascota> lista;
    private ArrayList<Mascota> cincoMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinco_mascotas);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionbar2);
        setSupportActionBar(miActionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        listaCincoMascotas = (RecyclerView) findViewById(R.id.rvCincoMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listaCincoMascotas.setLayoutManager(llm);

        lista = new ArrayList<Mascota>();

        lista = getIntent().getParcelableArrayListExtra("CincoMascotas");

        //inicializarListaMascotas();
        inicializarAdaptador2();

    }

    public MascotaAdapter adaptador2;

    public void inicializarAdaptador2(){
        adaptador2 = new MascotaAdapter(lista, this);
        listaCincoMascotas.setAdapter(adaptador2);
    }

    public void inicializarListaMascotas(){

        cincoMascotas = new ArrayList<Mascota>();

        cincoMascotas.add(new Mascota(R.drawable.rottweiler, "Snup", 2, "Rottweiler",5));
        cincoMascotas.add(new Mascota(R.drawable.dalmata, "Scooby", 1, "Dalmata",8));
        cincoMascotas.add(new Mascota(R.drawable.chihuahua, "Rintintin", 3, "Chihuahua",10));
        cincoMascotas.add(new Mascota(R.drawable.pug, "Peluso", 8, "Pug",7));
        cincoMascotas.add(new Mascota(R.drawable.poodle, "Rocky", 5, "Poodle",15));
    }
}

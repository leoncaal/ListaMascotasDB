package com.example.listamascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class CincoMascotas extends AppCompatActivity {

    private RecyclerView listaCincoMascotas;

    ArrayList<Mascota> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinco_mascotas);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaCincoMascotas = (RecyclerView) findViewById(R.id.rvCincoMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listaCincoMascotas.setLayoutManager(llm);

        lista = new ArrayList<Mascota>();

        lista = getIntent().getParcelableArrayListExtra("CincoMascotas");

        inicializarAdaptador2();

    }

    public MascotaAdapter adaptador2;

    public void inicializarAdaptador2(){
        adaptador2 = new MascotaAdapter(lista, this);
        listaCincoMascotas.setAdapter(adaptador2);
    }
}

package com.example.listamascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.listamascotas.adapter.MascotaAdapter;
import com.example.listamascotas.fragment.IRecyclerViewFragmentView;
import com.example.listamascotas.pojo.Mascota;
import com.example.listamascotas.presentador.RecyclerViewCincoMascotasPresenter;
import com.example.listamascotas.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class CincoMascotas extends AppCompatActivity implements IRecyclerViewFragmentView {

    private RecyclerView listaCincoMascotas;
    private RecyclerViewCincoMascotasPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinco_mascotas);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionbar2);
        setSupportActionBar(miActionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaCincoMascotas = (RecyclerView) findViewById(R.id.rvCincoMascotas);
        presenter = new RecyclerViewCincoMascotasPresenter(this, getBaseContext());

    }

    @Override
    public void generarLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listaCincoMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {

        MascotaAdapter adaptador = new MascotaAdapter(mascotas, this);

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter mascotaAdapter) {

        listaCincoMascotas.setAdapter(mascotaAdapter);

    }
}

package com.example.listamascotas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listamascotas.R;
import com.example.listamascotas.adapter.MascotaAdapter;
import com.example.listamascotas.pojo.Mascota;

import java.util.ArrayList;

public class ReciclerviewFragment extends Fragment {

    public static ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return view;
    }

    public MascotaAdapter adaptador;

    public void inicializarAdaptador(){
        adaptador = new MascotaAdapter(mascotas, getActivity());
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

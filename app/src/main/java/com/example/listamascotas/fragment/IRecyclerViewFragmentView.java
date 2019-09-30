package com.example.listamascotas.fragment;

import com.example.listamascotas.adapter.MascotaAdapter;
import com.example.listamascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLayoutVertical();

    public MascotaAdapter crearAdaptador (ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV (MascotaAdapter mascotaAdapter);

}

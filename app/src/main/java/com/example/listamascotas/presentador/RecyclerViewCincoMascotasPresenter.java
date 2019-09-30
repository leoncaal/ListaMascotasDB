package com.example.listamascotas.presentador;

import android.content.Context;

import com.example.listamascotas.db.ConstructorMascotas;
import com.example.listamascotas.fragment.IRecyclerViewFragmentView;
import com.example.listamascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewCincoMascotasPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewCincoMascotasPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerCincoMascotas();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {

        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLayoutVertical();

    }
}

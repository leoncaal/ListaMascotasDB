package com.example.listamascotas.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.listamascotas.R;
import com.example.listamascotas.adapter.MascotaAdapter;
import com.example.listamascotas.adapter.MascotaAdapterPics;
import com.example.listamascotas.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> picMascota;
    private RecyclerView listaPicsMascota;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaPicsMascota = (RecyclerView) view.findViewById(R.id.rvPicsMascota);

        GridLayoutManager llm = new GridLayoutManager(getContext(), 3);

        listaPicsMascota.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return view;
    }

    public MascotaAdapterPics adaptador;

    public void inicializarAdaptador(){
        adaptador = new MascotaAdapterPics(picMascota, getActivity());
        listaPicsMascota.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        picMascota = new ArrayList<Mascota>();

        picMascota.add(new Mascota(R.drawable.chihuahua,8));
        picMascota.add(new Mascota(R.drawable.chihuahua,10));
        picMascota.add(new Mascota(R.drawable.chihuahua,3));
        picMascota.add(new Mascota(R.drawable.chihuahua,5));
        picMascota.add(new Mascota(R.drawable.chihuahua,1));
        picMascota.add(new Mascota(R.drawable.chihuahua,12));
        picMascota.add(new Mascota(R.drawable.chihuahua,4));
        picMascota.add(new Mascota(R.drawable.chihuahua,2));
        picMascota.add(new Mascota(R.drawable.chihuahua,13));
        picMascota.add(new Mascota(R.drawable.chihuahua,6));
        picMascota.add(new Mascota(R.drawable.chihuahua,3));
        picMascota.add(new Mascota(R.drawable.chihuahua,17));

    }

}

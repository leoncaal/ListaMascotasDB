package com.example.listamascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listamascotas.pojo.Mascota;
import com.example.listamascotas.R;

import java.util.ArrayList;

public class MascotaAdapterPics extends RecyclerView.Adapter<MascotaAdapterPics.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapterPics(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_pic, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.fotoMascota.setImageResource(mascota.getFoto());
        holder.rankingMascota.setText(String.valueOf(mascota.getRating()));

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoMascota;
        private TextView rankingMascota;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            rankingMascota = (TextView) itemView.findViewById(R.id.txtRanking);

        }
    }

}
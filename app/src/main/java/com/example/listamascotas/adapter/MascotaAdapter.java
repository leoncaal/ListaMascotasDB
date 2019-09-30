package com.example.listamascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listamascotas.db.ConstructorMascotas;
import com.example.listamascotas.pojo.Mascota;
import com.example.listamascotas.R;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.fotoMascota.setImageResource(mascota.getFoto());
        holder.nombreMascota.setText(mascota.getNombre());
        holder.rankingMascota.setText(String.valueOf(mascota.getRating()));

        holder.huesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);

                holder.rankingMascota.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));

                if (constructorMascotas.obtenerUltimaPosicion(mascota) > 0) {

                    if (constructorMascotas.obtenerIdUltimaPosicion(mascota) != mascota.getId()) {
                        constructorMascotas.ponerPosicion(mascota);
                    }

                }else {

                    constructorMascotas.ponerPosicion(mascota);

                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoMascota;
        private TextView nombreMascota;
        private TextView rankingMascota;
        private ImageView huesoBlanco;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            nombreMascota = (TextView) itemView.findViewById(R.id.txtNombre);
            rankingMascota = (TextView) itemView.findViewById(R.id.txtRanking);
            huesoBlanco = (ImageView) itemView.findViewById(R.id.imgHuesoB);

        }
    }

}

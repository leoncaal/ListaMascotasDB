package com.example.listamascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.listamascotas.adapter.PageAdapter;
import com.example.listamascotas.fragment.PerfilFragment;
import com.example.listamascotas.fragment.ReciclerviewFragment;
import com.example.listamascotas.pojo.Mascota;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView star;
    private ArrayList<Mascota> cincoMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        star = (ImageView) findViewById(R.id.cincoMas);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionbar);

        setupViewPager();

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calcula();

            }

        });


        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    public void calcula(){

        cincoMascotas = new ArrayList<Mascota>();

        int iterador;

        for (iterador = 0; ReciclerviewFragment.mascotas.size() > iterador; iterador ++){

            if (ReciclerviewFragment.mascotas.get(iterador).getRating() >= 1) {

                cincoMascotas.add(new Mascota(ReciclerviewFragment.mascotas.get(iterador).getFoto(), ReciclerviewFragment.mascotas.get(iterador).getNombre(), ReciclerviewFragment.mascotas.get(iterador).getEdad(), ReciclerviewFragment.mascotas.get(iterador).getRaza(), ReciclerviewFragment.mascotas.get(iterador).getRating()));
                Toast.makeText(getBaseContext(), "Tiene " + ReciclerviewFragment.mascotas.get(iterador).getRating() + " likes " + ReciclerviewFragment.mascotas.get(iterador).getNombre(), Toast.LENGTH_SHORT).show();
            }
        }

        Intent i = new Intent(getBaseContext(), CincoMascotas.class);
        i.putParcelableArrayListExtra("CincoMascotas", cincoMascotas);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.acerca_de:

                Intent i = new Intent(this, AcercaDe.class);
                startActivity(i);

                return true;

            case R.id.contacto:

                Intent i2 = new Intent(this, Formulario.class);
                startActivity(i2);

                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new ReciclerviewFragment());
        fragments.add(new PerfilFragment());

        return fragments;

    }

    private void setupViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);


    }
}

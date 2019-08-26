package com.example.listamascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.listamascotas.email.Configuracion;
import com.example.listamascotas.email.EnviarMail;


public class Formulario extends AppCompatActivity {

    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.miActionbar2);
        setSupportActionBar(miActionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendEmail();

            }

        });

    }

    private void sendEmail() {

        // obteniendo el contenido del email
        EditText nombre = (EditText) findViewById(R.id.intxt_Nombre);
        EditText correoc = (EditText) findViewById(R.id.intxt_Correo);
        EditText comentario = (EditText) findViewById(R.id.intxt_Mensaje);

        // Crearmos el objeto para enviar el email
        EnviarMail envialMail = new EnviarMail(this, Configuracion.EMAIL, correoc.getText().toString(), nombre.getText().toString() + "\n" + comentario.getText().toString());

        // Executar enviar email
        envialMail.execute();
    }
}

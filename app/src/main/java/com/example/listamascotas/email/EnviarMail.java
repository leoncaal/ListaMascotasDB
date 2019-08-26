package com.example.listamascotas.email;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.listamascotas.email.Configuracion;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarMail extends AsyncTask<Void,Void,Void> {

    //Declaracion de variables
    private Context context;
    private Session session;

    //Variables para envio del email
    private String email;
    private String subject;
    private String message;

    //Barra de progreso cuando se este enviando el email
    private ProgressDialog progressDialog;

    public EnviarMail(Context context, String email, String subject, String message){
        //Initializing variables
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Showing progress dialog while sending email
        progressDialog = ProgressDialog.show(context,"Enviando Mensaje","Espera por favor...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        //Dismissing the progress dialog
        progressDialog.dismiss();
        //Showing a success message

        Toast.makeText(context,"Mensaje Enviado",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //Creating properties
        Properties props = new Properties();

        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        props.put("mail.smtp.host", Configuracion.HOST);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", Configuracion.PUERTO);

        //Creating a new session
        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    //Authenticating the password
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Configuracion.EMAIL, Configuracion.PASSWORD);
                    }
                });

        try {
            //Creating MimeMessage object
            MimeMessage mm = new MimeMessage(session);

            //Setting sender address
            mm.setFrom(new InternetAddress(Configuracion.EMAIL));
            //Adding receiver
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //Adding subject
            mm.setSubject(subject);
            //Adding message
            mm.setText(message);

            //Sending email

            Transport transport = session.getTransport("smtps");
            transport.connect(Configuracion.HOST, Configuracion.EMAIL, Configuracion.PASSWORD);
            transport.sendMessage(mm, mm.getAllRecipients());
            transport.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

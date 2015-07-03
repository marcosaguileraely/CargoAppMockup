package com.cargo.cargoapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class Coordinador_RegistroActivity extends ActionBarActivity {

    EditText name, lastname, dni, pass, repass, email;
    Button   guardar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinador_activity_registro);

        name     = (EditText) findViewById(R.id.nombres);
        lastname = (EditText) findViewById(R.id.apellidos);
        dni      = (EditText) findViewById(R.id.no_cedula);
        pass     = (EditText) findViewById(R.id.clave);
        repass   = (EditText) findViewById(R.id.re_clave);
        email    = (EditText) findViewById(R.id.correo);
        guardar  = (Button) findViewById(R.id.guardar_button);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usertxt   = dni.getText().toString();
                final String passtxt   = pass.getText().toString();
                final String emailtxt  = email.getText().toString();
                final String nametxt   = name.getText().toString();
                final String lasttxt   = lastname.getText().toString();

                ParseUser user = new ParseUser();
                user.setUsername(String.valueOf(usertxt));  //1
                user.setPassword(String.valueOf(passtxt));  //2
                user.setEmail(String.valueOf(emailtxt));    //3
                user.put("nombres", nametxt);               //4
                user.put("apellidos", lasttxt);             //5
                user.put("dni", Integer.parseInt(usertxt)); //6
                user.put("tipo_dni", "Cédula Ciudadanía");  //7
                user.put("tipo_usuario", "coordinador");    //8

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if(e == null) {
                            Toast.makeText(getApplicationContext(), "Registro exitoso. Enviando notificación...", Toast.LENGTH_LONG).show();
                            //SendMail sendMail =  new SendMail();
                            //sendMail.sendEmailNotification(emailtxt, fullname, usertxt, passtxt, now, citytxt);
                            Intent intent = new Intent(Coordinador_RegistroActivity.this, Coordinador_LoginActivity.class);
                            startActivity(intent);
                        }else {
                            Log.d("Action", e.toString());
                            Toast.makeText(getApplicationContext(), "¡Ups! intentalo nuevamente. @" + e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
    }


}

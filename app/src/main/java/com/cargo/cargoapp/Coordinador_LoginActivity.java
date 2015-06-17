package com.cargo.cargoapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Coordinador_LoginActivity extends ActionBarActivity {

    Button acceso, registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinador_activity_login);

        registro    = (Button) findViewById(R.id.registro_button);
        acceso      = (Button) findViewById(R.id.acceso_button);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegistro = new Intent(Coordinador_LoginActivity.this, Coordinador_RegistroActivity.class);
                startActivity(goToRegistro);
            }
        });

        acceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}

package com.cargo.cargoapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button coordinador, conductor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinador = (Button) findViewById(R.id.coordinador_button);
        conductor   = (Button) findViewById(R.id.conductor_button);

        coordinador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCoordinador =  new Intent(MainActivity.this, Coordinador_LoginActivity.class);
                startActivity(goToCoordinador);
            }
        });

        conductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToConductor = new Intent(MainActivity.this, Conductor_LoginActivity.class);
                startActivity(goToConductor);
            }
        });
    }

}

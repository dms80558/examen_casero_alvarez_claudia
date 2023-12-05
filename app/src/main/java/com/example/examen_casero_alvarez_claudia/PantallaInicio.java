package com.example.examen_casero_alvarez_claudia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

    }


    public void irCronometro(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void salir(View v){
        finishAffinity();
        System.exit(0);
    }
}

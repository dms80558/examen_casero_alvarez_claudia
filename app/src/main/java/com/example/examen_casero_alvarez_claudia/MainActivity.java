package com.example.examen_casero_alvarez_claudia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    Button butplay,butrecord, butpausa;
    Context context;
    List<Segundos> s = new ArrayList<>();
    boolean pausar = false;
    boolean pausarecord = false;
    TextView textcontador;
    BigInteger contador = new BigInteger("0");
    int contadort =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butplay = findViewById(R.id.buttplay);
        butrecord = findViewById(R.id.butrecord);
        butpausa = findViewById(R.id.butpausa);

        textcontador = findViewById(R.id.contador);
    }



    public void incrementar(View v) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

                executor.execute(() -> {
                    //Background work here
                    while (pausar==false) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        contador = contador.add(BigInteger.valueOf(1));
                        handler.post(() -> {
                            //UI Thread work here
                            textcontador.setText(contador.toString());
                        });
                    }
                });
            if(pausar==true){
                pausar = false;
            }
    }


    public void pausar(View v){
    pausar = true;


    }

    public void mostrar(View v){
        RecyclerView rv = (RecyclerView) findViewById(R.id.rec);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            //Background work here
            while (pausarecord==false) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                contadort += 1;
                handler.post(() -> {
                    //UI Thread work here
                   // textcontador.setText(contador.toString());


                });
            }
        });


        if(pausarecord==true){
            s.add(new Segundos(contadort));
            pausarecord = false;
        }


        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Adapter(context,s));
    }
}
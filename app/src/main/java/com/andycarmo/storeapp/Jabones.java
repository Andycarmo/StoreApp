package com.andycarmo.storeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.realm.Realm;

public class Jabones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jabones);

    }
    public void almacen(View view){
        Intent a = new Intent(this, almacen.class);
        startActivity(a);
    }

    public void bandas(View view){
        Intent b = new Intent(this, bandas.class);
        startActivity(b);
    }

    public void lubricantes(View view){
        Intent l = new Intent(this, lubricantes.class);
        startActivity(l);
    }

    public void calculadora(View view){
        Intent c = new Intent(this, calculadora.class);
        startActivity(c);
    }

 //   public void listaRepuestos(View view){
 //       Intent l = new Intent(this, lista.class);
 //       startActivity(l);
 //   }

    public void bombas(View view){
        Intent b = new Intent(this, Pumps.class);
        startActivity(b);
    }

}
package com.andycarmo.storeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class calculadora extends AppCompatActivity {

    private EditText n1;
    private EditText n2;
    private TextView rs;
    private RadioButton rb1;
    private RadioButton rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        n1 = findViewById(R.id.txtN1);
        n2 = findViewById(R.id.txtN2);
        rs = findViewById(R.id.txtResultado);
        rb1 = findViewById(R.id.radioSumar);
        rb2 = findViewById(R.id.radioRestar);

    }

    public void volver2(View view) {
        Intent j2 = new Intent(this, Jabones.class);
        startActivity(j2);
    }

    // >>>>>>   Metodo de sumar  <<<<<<<<  //

    /**
     * public void sumar(View view){
     * String sumando1 = n1.getText().toString();
     * String sumando2 = n2.getText().toString();
     * <p>
     * int numero1 = Integer.parseInt(sumando1);
     * int numero2 = Integer.parseInt(sumando2);
     * <p>
     * int result = numero1 + numero2;
     * rs.setText(result+"");
     * }
     **/

    public void operacion(View view) {
        String valor1 = n1.getText().toString();
        String valor2 = n2.getText().toString();

        int numero1 = Integer.parseInt(valor1);
        int numero2 = Integer.parseInt(valor2);

        if (rb1.isChecked()) {
            int suma = numero1 + numero2;
            rs.setText(suma + "");
        } else {
            if (rb2.isChecked()) {
                int resta = numero1 - numero2;
                rs.setText(resta + "");
            } else {
                Toast.makeText(this, "No selecciono ninguna operacion", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
package com.andycarmo.storeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btn = (Button) findViewById(R.id.btnInicio);
        btn.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        return false;
    }

    public void abrirAlmacen(View view){
        Intent i = new Intent(this, Jabones.class);
        startActivity(i);
    }

    ///  >>>  Metodo para enlazar el Activity P/pal con el Activity de Menu <<<
    /**public boolean onCreateOptionsMenu(Menu menu){
     getMenuInflater().inflate(R.menu.overflow,menu);
     return  true;
     }

     /// >>> Metodo para seleccionar los Items del menu
     public boolean onOptionsItemSelected(MenuItem item){
     int id= item.getItemId();
     if (id==R.id.item1){
     Toast.makeText(this, "Presiono item 1", Toast.LENGTH_SHORT).show();
     }
     if (id==R.id.item2){
     Toast.makeText(this, "Presiono item 2", Toast.LENGTH_SHORT).show();
     }
     if (id==R.id.item3){
     Toast.makeText(this, "Presiono item 3", Toast.LENGTH_SHORT).show();
     }
     return super.onOptionsItemSelected(item);
     }**/
}
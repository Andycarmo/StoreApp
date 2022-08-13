package com.andycarmo.storeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import modelo.Bomba;

public class bomba extends AppCompatActivity {

    private RecyclerView rvBombas;

    ArrayList<Bomba> bombas = new ArrayList<>();

    Bomba b1 = new Bomba(001, "Bba de lejia P/pal", "SIHI", "Wakesha","DRES34234","0378267TR", R.drawable.bba_centrifuga_80px);
    Bomba b2 = new Bomba(002, "Bba de caldera", "SIHI", "GEA", "FS3454DSF","342AS342", R.drawable.bba_lobular_inoxpa_80px);
    Bomba b3 = new Bomba (003, "Bba de grasas", "Null", "KUKA","ERWR5334","354EFDRGE", R.drawable.bba_centrifuga_monobloc);

    String [] repuestos = {"Tornillo Acero M5 x 20", "arandela", "tuerca", "broca"};
    double [] precio = {500, 200, 100, 4000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bomba);

    }

    public void newPump(View view){
        Intent nP = new Intent(this, newPump.class);
        startActivity(nP);
    }

}
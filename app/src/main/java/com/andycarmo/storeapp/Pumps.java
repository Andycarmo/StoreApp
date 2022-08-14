package com.andycarmo.storeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import modelo.Bomba;

public class Pumps extends AppCompatActivity {

    private RecyclerView rvPumpsList;

    ArrayList<Bomba> bombasAll = new ArrayList<>();

    Bomba b1 = new Bomba(001, "Bba de lejia P/pal", "SIHI", "Wakesha","DRES34234","0378267TR", R.drawable.bba_centrifuga_80px);
    Bomba b2 = new Bomba(002, "Bba de caldera", "SIHI", "GEA", "FS3454DSF","342AS342", R.drawable.bba_lobular_inoxpa_80px);
    Bomba b3 = new Bomba (003, "Bba de grasas", "Null", "KUKA","ERWR5334","354EFDRGE", R.drawable.bba_centrifuga_monobloc);

    String [] repuestos = {"Tornillo Acero M5 x 20", "arandela", "tuerca", "broca"};
    double [] precio = {500, 200, 100, 4000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pumps);

        rvPumpsList = findViewById(R.id.rvPumps);

        bombasAll.add(b1);
        bombasAll.add(b2);
        bombasAll.add(b3);

        LinearLayoutManager LLM2 = new LinearLayoutManager(this);
        rvPumpsList.setLayoutManager(LLM2);
        rvPumpsList.setAdapter(new AdaptadorPumps());
    }
        class AdaptadorPumps extends RecyclerView.Adapter <AdaptadorPumps.AdaptadorPumpsHolder> {
            @NonNull
            @Override
            public AdaptadorPumpsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new AdaptadorPumpsHolder(getLayoutInflater().inflate(R.layout.itembomba,parent,false));
            }

        @Override
            public void onBindViewHolder(@NonNull AdaptadorPumpsHolder holder, int position) {
                holder.imprimir(position);
            }


        @Override
        public int getItemCount() {return bombasAll.size();
        }

        private class AdaptadorPumpsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            TextView tv1;
            TextView tv2;
            TextView tv3;
            TextView tv4;
            ImageView imv;

            public AdaptadorPumpsHolder(@NonNull View itemView) {
                super(itemView);

                tv1 = itemView.findViewById(R.id.tvNombre);
                tv2 = itemView.findViewById(R.id.tvMarca);
                tv3 = itemView.findViewById(R.id.tvTipo);
                tv4 = itemView.findViewById(R.id.tvOtro);
                imv = itemView.findViewById(R.id.ImagenBomba);

            }

            public void imprimir(int position) {
                imv.setImageResource(bombasAll.get(position).getImagen());
                tv1.setText(bombasAll.get(position).getNombre());
                tv2.setText(bombasAll.get(position).getMarca());
                tv3.setText(bombasAll.get(position).getTipo());
                tv4.setText(bombasAll.get(position).getReferencia());
            }

            @Override
            public void onClick(View view) {

                Toast.makeText(Pumps.this, "Bba Seleccionada", Toast.LENGTH_SHORT).show();
            }
        }
    }

                public void newPump(View view){
                    Intent nP = new Intent(this, newPump.class);
                    startActivity(nP);
                }


}
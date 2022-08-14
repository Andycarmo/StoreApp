package com.andycarmo.storeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import modelo.Bomba;

public class lista extends AppCompatActivity {

    private RecyclerView rv;

    ArrayList <Bomba> bombas = new ArrayList<>();

    Bomba b1 = new Bomba(001, "Bba de lejia P/pal", "SIHI", "Wakesha","DRES34234","0378267TR", R.drawable.bba_centrifuga_80px);
    Bomba b2 = new Bomba(002, "Bba de caldera", "SIHI", "GEA", "FS3454DSF","342AS342", R.drawable.bba_lobular_inoxpa_80px);
    Bomba b3 = new Bomba (003, "Bba de grasas", "Null", "KUKA","ERWR5334","354EFDRGE", R.drawable.bba_centrifuga_monobloc);

    String [] repuestos = {"Tornillo Acero M5 x 20", "arandela", "tuerca", "broca"};
    double [] precio = {500, 200, 100, 4000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        rv = findViewById(R.id.rv);

        bombas.add(b1);
        bombas.add(b2);
        bombas.add(b3);

        LinearLayoutManager LLM = new LinearLayoutManager(this);
        rv.setLayoutManager(LLM);
        rv.setAdapter(new AdaptadorBombas());

        //ArrayAdapter adapter = new ArrayAdapter(this, R.layout.menuitem, bombas);
       // lista.setAdapter(adapter);


        /// >>>>>>  Codigo para adaptar un menu personalizado a la ListView  <<<<<<<<<   ///

   /**     ArrayAdapter<String> adapter= new ArrayAdapter<>(this, R.layout.menuitem, repuestos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemLista.setText("El repuesto es "+ repuestos[i]+ ", vale "+ precio [i]);
                }
        });
    }   **/

      //  >>>>>  Codigo Picasso para cargar imagen con URL  <<<<<<   //
      // Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imv);

      //  >>>>>  Codigo Picasso para cargar imagen localmente  <<<<<<   //
      //  Picasso.get().load(R.drawable.bba_diafragma).into(imv);


    }

    class AdaptadorBombas extends RecyclerView.Adapter <AdaptadorBombas.AdaptadorBombasHolder> {
        @NonNull
        @Override
        public AdaptadorBombasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorBombasHolder(getLayoutInflater().inflate(R.layout.itembomba,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorBombasHolder holder, int position) {
            holder.imprimir(position);
        }


        @Override
        public int getItemCount() {
            return bombas.size();
        }

        private class AdaptadorBombasHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            TextView tv1;
            TextView tv2;
            TextView tv3;
            TextView tv4;
            ImageView imv;

            public AdaptadorBombasHolder(@NonNull View itemView) {
                super(itemView);

                tv1 = itemView.findViewById(R.id.tvNombre);
                tv2 = itemView.findViewById(R.id.tvTipo);
                tv3 = itemView.findViewById(R.id.tvMarca);
                tv4 = itemView.findViewById(R.id.tvOtro);
                imv = itemView.findViewById(R.id.ImagenBomba);

            }

        public void imprimir(int position) {
            imv.setImageResource(bombas.get(position).getImagen());
            tv1.setText(bombas.get(position).getNombre());
            tv2.setText(bombas.get(position).getMarca());
            tv3.setText(bombas.get(position).getTipo());
            tv4.setText(bombas.get(position).getReferencia());
        }

            @Override
            public void onClick(View view) {

                Toast.makeText(lista.this, "Bba Seleccionada", Toast.LENGTH_SHORT).show();
            }
        }


    }
}

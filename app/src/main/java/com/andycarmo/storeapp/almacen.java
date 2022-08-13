package com.andycarmo.storeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import modelo.Repuesto;

public class almacen extends AppCompatActivity {

    private RecyclerView rvRepuestoslist;
    //TextView tvAlmac;
    //EditText edtxCeco, edtxUbicacion, edtxDescripcion;
    //Button btnRegistrar;
    //FirebaseFirestore mFirestore;

    //DatabaseReference DatabaseReference = FirebaseDatabase.getInstance().getReference();
   // DatabaseReference myRowC = DatabaseReference.child("txt");

    ArrayList <Repuesto> repuestosAll = new ArrayList<>();

    Repuesto r1 = new Repuesto("85370590", "ACOPOS", "2-C-0");
 /*   Repuesto r2 = new Repuesto(85370591, "ACOPOS", "2-C-0");
    Repuesto r3 = new Repuesto(85370598, "I", "2-G-0");
    Repuesto r4 = new Repuesto(85290423, "T","6-A-7");
    Repuesto r5 = new Repuesto(85290424, "Y", "6-A-6");
    Repuesto r6 = new Repuesto(1000358881, "as", "ESTIBA");
    Repuesto r7 = new Repuesto(85359617, "1G222", "9-B-6");
    Repuesto r8 = new Repuesto(85359614, "1G327", "9-B-6");
    Repuesto r9 = new Repuesto(85359615, "1G327", "9-B-6");
    Repuesto r10 = new Repuesto(85280077, "3FV", "9-F-5");
    Repuesto r11 = new Repuesto(85293927, "CORREA", "7-C-3");

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacen);

        //>>>>>  TextView para el Realtime Database  <<<< ///
        //tvAlmac = findViewById(R.id.tvAlmacen);
        //edtxCeco = findViewById(R.id.etCeCo);
        //edtxUbicacion= findViewById(R.id.etUbicacion);
        //edtxDescripcion = findViewById(R.id.etDescripcion);
        //btnRegistrar = findViewById(R.id.btnRegistrar);
        //mFirestore = FirebaseFirestore.getInstance();

        //>>>>>  Recycler View  <<<< ///
        rvRepuestoslist = findViewById(R.id.rvAlmacen);

        repuestosAll.add(r1);
  /*      repuestosAll.add(r2);
        repuestosAll.add(r3);
        repuestosAll.add(r4);
        repuestosAll.add(r5);
        repuestosAll.add(r6);
        repuestosAll.add(r7);
        repuestosAll.add(r8);
        repuestosAll.add(r9);
        repuestosAll.add(r10);
*/
        LinearLayoutManager LLMRepuestos = new LinearLayoutManager(this);
        rvRepuestoslist.setLayoutManager(LLMRepuestos);
        rvRepuestoslist.setAdapter(new AdaptadorRepuestos());


        /** btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(almacen.this, "Repuesto Registrado!!!", Toast.LENGTH_LONG).show();
                registrar();
            }
        });   **/

    }

    class AdaptadorRepuestos extends RecyclerView.Adapter <AdaptadorRepuestos.AdaptadorRepuestosHolder>{
        @NonNull
        @Override
        public AdaptadorRepuestosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdaptadorRepuestosHolder(getLayoutInflater().inflate(R.layout.itemrepuestos,parent, false));

        }

        @Override
        public void onBindViewHolder(@NonNull AdaptadorRepuestosHolder holder, int position) {
            holder.imprimir(position);
        }

        @Override
        public int getItemCount() {
            return repuestosAll.size();
        }

        private class AdaptadorRepuestosHolder extends RecyclerView.ViewHolder {

            TextView tvRep1;
            TextView tvRep2;
            TextView tvRep3;

            public AdaptadorRepuestosHolder(@NonNull View itemView){
                super(itemView);

                tvRep1 = findViewById(R.id.tvRepuesto);
                tvRep2 = findViewById(R.id.tvCeco);
                tvRep3 = findViewById(R.id.tvUbicacion);

            }

            public void imprimir(int position){
                tvRep1.setText(repuestosAll.get(position).getNombre());
                tvRep2.setText(repuestosAll.get(position).getCeco());
                tvRep3.setText(repuestosAll.get(position).getUbicacion());

            }

        }

    }


  /**  public void registrar() {
        Map<String, Object> repuesto = new HashMap<>();

        repuesto.put("CeCo",edtxCeco.getText().toString());
        repuesto.put("Ubicación", edtxUbicacion.getText().toString());
        repuesto.put("Descripción", edtxDescripcion.getText().toString());

        mFirestore.collection("Repuestos").document().set(repuesto);

    }

    public void volver(View view){
        Intent j = new Intent(this, Jabones.class);
        startActivity(j);
    }

    @Override
    protected void onStart() {
        super.onStart();

        myRowC.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String texto = Objects.requireNonNull(snapshot.getValue().toString());
                tvAlmac.setText(texto);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });  **/


    }


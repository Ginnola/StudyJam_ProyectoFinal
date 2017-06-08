package com.example.telassimgomez.studyjam_proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CodigoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lvDatos;
    private Activity activity;
    private CustomAdapter adaptador;
    private ArrayList<Colores> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_codigo);

        lvDatos = (ListView) findViewById(R.id.lvLista);
        activity = this;
        datos = new ArrayList<Colores>();

        llenarArrayList();

        adaptador = new CustomAdapter(activity, datos);

        lvDatos.setAdapter(adaptador);
        lvDatos.setOnItemClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    public void llenarArrayList() {
        Resources resources = getResources();
        String[] arrayNombres = resources.getStringArray(R.array.nombre);
        String[] arrayTipos = resources.getStringArray(R.array.tipos);
        TypedArray imgs = resources.obtainTypedArray(R.array.image);
        String[] arrayDescripcion = resources.getStringArray(R.array.descripcion);
        TypedArray imgdetalle = resources.obtainTypedArray(R.array.imagedetalle);
        for(int i=0; i < arrayNombres.length; i++) {
            datos.add(new Colores(arrayNombres[i],
                    arrayTipos[i], imgs.getResourceId(i, -1), arrayDescripcion[i],imgdetalle.getResourceId(i, -1)));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Colores colores = datos.get(position);
        Intent i = new Intent(getApplicationContext(), DetallecodigoActivity.class);
        i.putExtra("colores", colores);
        startActivity(i);
    }
}

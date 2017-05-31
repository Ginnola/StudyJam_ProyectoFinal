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

public class PuntosReciclajeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lvDatos;
    private Activity activity;
    private CustomAdapterP adaptador;
    private ArrayList<PuntosR> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_puntos_reciclaje);

        lvDatos = (ListView) findViewById(R.id.lvListaP);
        activity = this;
        datos = new ArrayList<PuntosR>();

        llenarArrayList();

        adaptador = new CustomAdapterP(activity, datos);

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
        String[] arrayNombres = resources.getStringArray(R.array.nombrep);
        TypedArray imgs = resources.obtainTypedArray(R.array.imagep);
        String[] arrayCiudad = resources.getStringArray(R.array.ciudadp);
        String[] arrayDireccion = resources.getStringArray(R.array.direccion);
        String[] arrayTelefono = resources.getStringArray(R.array.telefono);
        String[] arrayCelular= resources.getStringArray(R.array.celular);
        for(int i=0; i < arrayNombres.length; i++) {
            datos.add(new PuntosR(arrayNombres[i], imgs.getResourceId(i, -1), arrayCiudad[i], arrayDireccion[i], arrayTelefono[i], arrayCelular[i]));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PuntosR puntos = datos.get(position);
        Intent i = new Intent(getApplicationContext(), DetallepuntosActivity.class);
        i.putExtra("puntos", puntos);
        startActivity(i);
    }
}

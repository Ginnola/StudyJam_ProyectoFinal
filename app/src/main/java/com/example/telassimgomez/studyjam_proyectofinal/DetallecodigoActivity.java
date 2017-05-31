package com.example.telassimgomez.studyjam_proyectofinal;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallecodigoActivity extends AppCompatActivity {

    private ImageView ivImagen;
    private TextView tvNombre;
    private TextView tvHAbilidades;
    private TextView tvDescripcion;

    private Typeface tf_thing;
    private Typeface tf_bold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_detallecodigo);

        ivImagen = (ImageView) findViewById(R.id.ivDetalleImagen);
        tvNombre = (TextView) findViewById(R.id.tvDetalleNombre);
        tvHAbilidades = (TextView) findViewById(R.id.tvDetalleHabilidades);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

//        tf_thing = Typeface.createFromAsset(
//                getAssets(), "fonts/roboto_thin.ttf");
//        tf_bold = Typeface.createFromAsset(
//                getAssets(), "fonts/roboto_black.ttf");

        tvNombre.setTypeface(tf_bold);
        tvHAbilidades.setTypeface(tf_thing);

        Colores colores = (Colores) getIntent().getSerializableExtra("colores");
        tvNombre.setText(colores.getNombre().toString());
        tvHAbilidades.setText(colores.getHabilidades().toString());
        ivImagen.setImageResource(colores.getImagenDetalle());
        tvDescripcion.setText(colores.getDescripcion().toString());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}

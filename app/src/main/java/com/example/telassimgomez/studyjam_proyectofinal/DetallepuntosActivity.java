package com.example.telassimgomez.studyjam_proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallepuntosActivity extends AppCompatActivity {

    private ImageView ivImagen;
    private TextView tvNombre;
    private TextView tvDetalleCiudad;
    private TextView tvDetalleDireccion;
    private TextView tvTelefono;
    private TextView tvCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_detallepuntos);

        ivImagen = (ImageView) findViewById(R.id.ivDetalleImagenP);
        tvNombre = (TextView) findViewById(R.id.tvDetalleNombreP);
        tvDetalleCiudad = (TextView) findViewById(R.id.tvDetalleCiudad);
        tvDetalleDireccion = (TextView) findViewById(R.id.tvDetalleDireccion);
        tvTelefono = (TextView) findViewById(R.id.tvDetalleTelefono);
        tvCelular = (TextView) findViewById(R.id.tvDetalleCelular);

        PuntosR puntos = (PuntosR) getIntent().getSerializableExtra("puntos");
        tvNombre.setText(puntos.getNombre().toString());
        ivImagen.setImageResource(puntos.getImagenP());
        tvDetalleCiudad.setText(puntos.getCiudad());
        tvDetalleDireccion.setText(puntos.getDireccion());
        tvTelefono.setText(puntos.getTelefono());
        tvCelular.setText(puntos.getCelular());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}

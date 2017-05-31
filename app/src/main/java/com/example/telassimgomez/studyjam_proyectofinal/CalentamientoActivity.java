package com.example.telassimgomez.studyjam_proyectofinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class CalentamientoActivity extends AppCompatActivity {

    private ImageView imgcal1;
    private ImageView imgcal2;
    private Animation animacion;
    private Animation animacion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_calentamiento);

        imgcal1 = (ImageView) findViewById(R.id.imgcal1);
        imgcal2 = (ImageView) findViewById(R.id.imgcal2);

        animacion = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animacion2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        imgcal1.startAnimation(animacion2);
        imgcal2.startAnimation(animacion);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}

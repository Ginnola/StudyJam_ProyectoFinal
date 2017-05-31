package com.example.telassimgomez.studyjam_proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ImageView imgp1;
    private ImageView imgp2;
    private Animation animacion;
    private Animation animacion2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Animacion imagen
//        imgp1 = (ImageView) findViewById(R.id.imgp1);
//        imgp2 = (ImageView) findViewById(R.id.imgp2);
//
//        animacion = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
//        animacion2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
//        imgp1.startAnimation(animacion2);
//        imgp2.startAnimation(animacion);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Boolean fragseleccionado = false;

        if (id == R.id.calentamiento_global) {
            // Handle the camera action
            Intent intent = new Intent(getApplicationContext(), CalentamientoActivity.class);
            startActivity(intent);

        } else if (id == R.id.razones) {
            Intent intent = new Intent(getApplicationContext(), RazonesActivity.class);
            startActivity(intent);

        } else if (id == R.id.cod_colores) {
            Intent intent = new Intent(getApplicationContext(), CodigoActivity.class);
            startActivity(intent);

        } else if (id == R.id.ubicacion) {
            Intent intent = new Intent(getApplicationContext(), UbicacionActivity.class);
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            startActivity(intent);

        } else if (id == R.id.puntos) {
            Intent intent = new Intent(getApplicationContext(), PuntosReciclajeActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.about) {
            Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);
        }

        if(fragseleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.principal, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}

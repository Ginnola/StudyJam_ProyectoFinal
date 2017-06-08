package com.example.telassimgomez.studyjam_proyectofinal;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class UbicacionActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMaps;
    private Marker marcador;
    private double latitud;
    private double longitud;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        //Para manejar el tipo de mapa
        //mMap.setMapType(googleMap.MAP_TYPE_NORMAL);

        mMap.getUiSettings().setZoomControlsEnabled(true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 15000, 0, locationListener);

        //Marcadores de Puntos de Reciclaje
        mMap.addMarker(new MarkerOptions().position(new LatLng(-16.506052480302383, -68.13049075396725)).title("Agencia de Recolección").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-16.49362774028574, -68.14054807175825)).title("Chatarreria San Miguel").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-16.50067333461596, -68.1351898325409)).title("Reciclaje La Paz").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-16.5956941, -68.18808869999998)).title("Acopiadora de Papel Acopiapel S.R.L.").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.8202002, -63.21880010000001)).title("Alberts Import Export Comercial").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.7868116, -63.1863429)).title("Anserco Anaconda Service Corporation S.R.L.").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.8532163, -63.1820285)).title("Arthild Import Export").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.735469, -63.17407430000003)).title("Candy").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.766498814496934, -63.18549094365534)).title("Cavibru").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.7511799, -63.16825929999999)).title("Cobra Met - Av Nicolas Suárez").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.764200487841727, -63.07178312170413)).title("Cobra Met - Carretera a Cotoca").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.7705957, -63.07178312170413)).title("Comercial Du Lin").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.7552251, -63.153237399999966)).title("El Chatarrero Import Export").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.7725856, -63.18247539999999)).title("Import Export Cristalpet S.R.L.").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.7549357636686, -63.18920608465578)).title("Reciclallantas").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.3927098, -66.19709820000003)).title("Acodematrv").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.4422164, -66.1270801)).title("Acopiadora Boliviana Limitada - Acobol S.R.L.").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.3848415, -66.1483786)).title("Dipolba").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.3915352, -66.07188180000003)).title("Ecoplastic S.R.L.").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-17.9692542, -67.11411559999999)).title("Masquis").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-21.5250623, -64.7208324)).title("Zarate Rosado Sandra Pilar").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_punto_reciclaje)));

    }

    private void agregarMarcador(double lat, double lng){
        LatLng coordenadas = new LatLng(lat, lng);
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 13);
        if(marcador != null)
            marcador.remove();
        marcador = mMap.addMarker(new MarkerOptions().position(coordenadas).title("Tu Posicion Actual").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_ubicacion)));
        mMap.animateCamera(miUbicacion);
    }

    private void actualizarUbicacion(Location location){
        if(location != null){
            latitud = location.getLatitude();
            longitud = location.getLongitude();
            agregarMarcador(latitud,longitud);
        }
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actualizarUbicacion(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.d("debug", "LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(getApplicationContext(),"GPS Desactivado", Toast.LENGTH_LONG).show();
        }
    };

    private void miUbicacion(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation (LocationManager.GPS_PROVIDER);
        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 15000, 0, locationListener);
    }
}

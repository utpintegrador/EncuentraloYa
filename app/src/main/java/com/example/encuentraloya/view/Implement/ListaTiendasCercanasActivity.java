package com.example.encuentraloya.view.Implement;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.encuentraloya.Adaptador.INegocioCercanoAdapterView;
import com.example.encuentraloya.Adaptador.NegocioCercanoAdapter;
import com.example.encuentraloya.R;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.MyLocation;
import com.example.encuentraloya.comun.MyLocationDetails;
import com.example.encuentraloya.comun.UbicacionGPS.IMyLocationService;
import com.example.encuentraloya.comun.UbicacionGPS.Localizacion;
import com.example.encuentraloya.comun.UbicacionGPS.MyLocationService;
import com.example.encuentraloya.entidad.NegocioDto;
import com.example.encuentraloya.model.Implement.TiendasCercanasInteractor;
import com.example.encuentraloya.presenter.TiendaCercanaPresenter;
import com.example.encuentraloya.view.IMyLocation;
import com.example.encuentraloya.view.Interfaces.ITiendaCercanaView;

import java.util.List;

public class ListaTiendasCercanasActivity extends AppCompatActivity
        implements IMyLocationService, ITiendaCercanaView , INegocioCercanoAdapterView , View.OnClickListener{

    TiendaCercanaPresenter presenter;
    NegocioCercanoAdapter adapter;

    ImageButton btn_back;
    ImageButton btn_actualizar;
    RecyclerView rvTiendasCercanas;
    ImageView img_ver;
    TextView tvDistancia;
    TextView tvTienda;
    ProgressBar progressBar;



    MyLocationService myLocationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tiendas_cercanas);

        img_ver = (ImageView) findViewById(R.id.imageVer);
        tvDistancia = (TextView)  findViewById(R.id.tvDistancia);
        tvTienda = (TextView)  findViewById(R.id.tvTienda);
        btn_back =(ImageButton)findViewById(R.id.btn_back);
        btn_actualizar=(ImageButton)findViewById(R.id.btn_actualizar);
        progressBar = (ProgressBar)findViewById(R.id.progress_tiendas_cercanas);


        //listener
        img_ver.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_actualizar.setOnClickListener(this);

        //LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        rvTiendasCercanas  =(RecyclerView) findViewById(R.id.rvTiendasCercanas);
        //rvTiendasCercanas.setHasFixedSize(true);
        //rvTiendasCercanas.setLayoutManager(layoutManager);

        //presenter
        presenter = new TiendaCercanaPresenter(this, new TiendasCercanasInteractor());

        //myLocationService= new MyLocationService(this,this);

        //INICIALIZA GPS
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,},
                    1000);

        } else {
            iniciarLocalizacion();
        }


    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_back:
                    startActivity(new Intent(this,HomeActivity.class));
                    finish();
                    break;
                case R.id.btn_actualizar:
                    rvTiendasCercanas.setVisibility(View.GONE);
                    presenter.getAllTiendasCercanas();
                    break;
                case R.id.img_ver:
                    break;
            }
    }



    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showTiendasCercanas(List<NegocioDto> lista) {
             rvTiendasCercanas.setVisibility(View.VISIBLE);
        rvTiendasCercanas.setLayoutManager(new LinearLayoutManager(this));
        rvTiendasCercanas.setHasFixedSize(true);
        adapter=null;
        rvTiendasCercanas.setAdapter(null);
        adapter = new NegocioCercanoAdapter(this, lista,this);
        rvTiendasCercanas.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void updateNegocioSelected(String nombreNegocio, String distanciaNegocio) {
        tvDistancia.setText(distanciaNegocio);
        tvTienda.setText(nombreNegocio);


    }

    @Override
    public void updateCheckNegocioSelectedAntiguo(int position) {
       // adapter.notifyItemChanged(position);

    }


    @Override
    public void showMensajeGPS(String mensaje) {

    }

    @Override
    public void showCoordanadas(double latitude, double longitude) {
        Constantes.LATITUD_VALUE = latitude;
        Constantes.LONGITUD_VALUE = longitude;
        presenter.getAllTiendasCercanas();
    }

   /* @Override
    public void showMyLocation() {
        location=null;
        locationDetails = new MyLocationDetails(this, Constantes.LATITUD_VALUE,Constantes.LONGITUD_VALUE);
        tvDistancia.setText(locationDetails.getDireccion());
        locationDetails=null;

    }*/


    //GPS
    private void iniciarLocalizacion() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Localizacion localizacion = new Localizacion();
        localizacion.setMainActivity(this, this);

        final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if(!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);

        }

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, localizacion);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, localizacion);

        //locationText.setText("Localizacion agregada");
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if(requestCode == 1000) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                iniciarLocalizacion();
                return;
            }
        }

    }




}

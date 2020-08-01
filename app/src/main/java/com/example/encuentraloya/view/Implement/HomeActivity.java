package com.example.encuentraloya.view.Implement;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.encuentraloya.Adaptador.CategoriaAdapter;
import com.example.encuentraloya.R;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.UbicacionGPS.IMyLocationService;
import com.example.encuentraloya.comun.UbicacionGPS.Localizacion;
import com.example.encuentraloya.comun.UbicacionGPS.MyLocationService;
import com.example.encuentraloya.entidad.CategoriaDto;
import com.example.encuentraloya.model.Implement.HomeInteractor;
import com.example.encuentraloya.presenter.HomePresenter;
import com.example.encuentraloya.view.Interfaces.IHomeView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, IHomeView , IMyLocationService {

    Button navegation_inicio;
    Button navegation_buscar;
    Button navegation_carrito;
    Button navegation_perfil;

    TextView tv_tiendas_cercanas;

    RecyclerView rvCategoria;
    ProgressBar progressBar;

    RelativeLayout navegation_tiendas_cercanas;
    //BARRA
    BarChart barChart;


    HomePresenter presenter;
    CategoriaAdapter catAdapter;

    MyLocationService myLocationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        tv_tiendas_cercanas = (TextView)this.findViewById(R.id.tv_tiendas_cercanas);

        navegation_inicio =(Button) this.findViewById(R.id.btn_inicio);
        navegation_buscar=(Button) this.findViewById(R.id.btn_buscar);
        navegation_carrito=(Button) this.findViewById(R.id.btn_carrito);
        navegation_perfil =(Button) this.findViewById(R.id.btn_perfil);

        navegation_tiendas_cercanas=(RelativeLayout)  this.findViewById(R.id.rl_tiendas_cercanas);
        progressBar =(ProgressBar)  this.findViewById(R.id.progress_home_categoria);

        barChart =(BarChart) findViewById(R.id.barChart) ;

        ////
        LinearLayoutManager layoutManager =
                new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);

        rvCategoria=(RecyclerView) this.findViewById(R.id.rvCategoria);
        rvCategoria.setHasFixedSize(true);
        rvCategoria.setLayoutManager(layoutManager);

        //set listener
        navegation_inicio.setOnClickListener(this);
        navegation_buscar.setOnClickListener(this);
        navegation_carrito.setOnClickListener(this);
        navegation_perfil.setOnClickListener(this);
        navegation_tiendas_cercanas.setOnClickListener(this);

        //Init
        presenter = new HomePresenter(this, new HomeInteractor());

        presenter.getAllCategoria();

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
            case R.id.btn_inicio:
                startActivity(new Intent(HomeActivity.this,HomeActivity.class));
                finish();
                break;
            case R.id.btn_buscar:
                startActivity(new Intent(HomeActivity.this,BuscarProductoActivity.class));
                finish();
                break;
            case R.id.btn_carrito:
                startActivity(new Intent(HomeActivity.this,CarritoActivity.class));
                finish();
                break;
            case R.id.btn_perfil:
                startActivity(new Intent(HomeActivity.this,PerfilActivity.class));
                finish();
                break;
            case R.id.rl_tiendas_cercanas:
                startActivity(new Intent(HomeActivity.this,ListaTiendasCercanasActivity.class));
                finish();
                break;
        }
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRecyclerView() {
        rvCategoria.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showCategoria(List<CategoriaDto> listaCategoria) {
        catAdapter=new CategoriaAdapter(listaCategoria,this);
        rvCategoria.setAdapter(catAdapter);
    }

    @Override
    public void showMessage(String message) {
        Toast toast = Toast.makeText(this, message,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showGastoUltimosMeses(ArrayList<BarEntry> values, ArrayList<String> labels) {
        BarDataSet dataset = new BarDataSet(values, "# Gasto general de los últimos 5 meses");
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.TOP);
        BarData data = new BarData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setDescription("");
        barChart.setData(data);
        barChart.animateY(3000);
    }

    @Override
    public void showCantidadDisponibleTiendas(String mensaje) {
         tv_tiendas_cercanas.setText(mensaje);
    }


    @Override
    public void showMensajeGPS(String mensaje) {

    }

    @Override
    public void showCoordanadas(double latitude, double longitude) {
        Constantes.LATITUD_VALUE = latitude;
        Constantes.LONGITUD_VALUE = longitude;
        presenter.getAllCantidadTiendasCercanas();
        //myLocationService=null;
    }



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

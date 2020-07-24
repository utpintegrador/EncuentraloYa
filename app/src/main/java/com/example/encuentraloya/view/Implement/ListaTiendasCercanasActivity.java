package com.example.encuentraloya.view.Implement;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.encuentraloya.Adaptador.INegocioCercanoAdapterView;
import com.example.encuentraloya.Adaptador.NegocioCercanoAdapter;
import com.example.encuentraloya.R;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.MyLocation;
import com.example.encuentraloya.comun.MyLocationDetails;
import com.example.encuentraloya.entidad.NegocioDto;
import com.example.encuentraloya.model.Implement.TiendasCercanasInteractor;
import com.example.encuentraloya.presenter.TiendaCercanaPresenter;
import com.example.encuentraloya.view.IMyLocation;
import com.example.encuentraloya.view.Interfaces.ITiendaCercanaView;

import java.util.List;

public class ListaTiendasCercanasActivity extends AppCompatActivity
        implements IMyLocation , ITiendaCercanaView , INegocioCercanoAdapterView , View.OnClickListener{

    TiendaCercanaPresenter presenter;
    NegocioCercanoAdapter adapter;

    ImageButton btn_back;
    ImageButton btn_actualizar;
    RecyclerView rvTiendasCercanas;
    ImageView img_ver;
    TextView tvDistancia;
    TextView tvTienda;
    MyLocation location;
    MyLocationDetails locationDetails;

    ProgressBar progressBar;
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

        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        rvTiendasCercanas  =(RecyclerView) findViewById(R.id.rvTiendasCercanas);
        rvTiendasCercanas.setHasFixedSize(true);
        rvTiendasCercanas.setLayoutManager(layoutManager);


        //mi ubicación
        location = new MyLocation(this,this  );

        //presenter
        presenter = new TiendaCercanaPresenter(this, new TiendasCercanasInteractor());
        presenter.getAllTiendasCercanas(Constantes.LONGITUD_VALUE, Constantes.LATITUD_VALUE);



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
                    presenter.getAllTiendasCercanas(Constantes.LONGITUD_VALUE, Constantes.LATITUD_VALUE);
                    break;
                case R.id.img_ver:
                    break;
            }
    }

    @Override
    public void showMyLocation() {
        location=null;
        locationDetails = new MyLocationDetails(this, Constantes.LATITUD_VALUE,Constantes.LONGITUD_VALUE);
        tvDistancia.setText(locationDetails.getDireccion());
        locationDetails=null;

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
        adapter = new NegocioCercanoAdapter(this, lista,this);
        rvTiendasCercanas.setAdapter(adapter);


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
        adapter.notifyItemChanged(position);

        //System.out.println(position+ " vista");//////

    }


}

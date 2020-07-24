package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.encuentraloya.R;
import com.example.encuentraloya.RegistaraNegocioActivity;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.MyLocation;
import com.example.encuentraloya.comun.MyLocationDetails;
import com.example.encuentraloya.model.Implement.MyNegocioInteractor;
import com.example.encuentraloya.presenter.MyNegocioPresenter;
import com.example.encuentraloya.view.Interfaces.IMyNegocioView;

public class MyNegocioActivity extends AppCompatActivity implements  View.OnClickListener, IMyNegocioView {
    MyNegocioPresenter presenter;

    ImageButton btn_back;
    Button btn_verMapa;
    Button btn_actualizar;
    TextView tv_NombreTienda;
    TextView tv_DireccionTienda;
    ProgressBar progressBar;
    EditText ed_mi_negocio_titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_negocio);

        btn_back = (ImageButton) findViewById(R.id.btn_back);
        btn_verMapa = (Button) findViewById(R.id.btn_ver_mapa);
        btn_actualizar=(Button)findViewById(R.id.btn_actualizar_ubicacion_negocio);
        tv_NombreTienda = (TextView) findViewById(R.id.tvTienda);
        tv_DireccionTienda = (TextView) findViewById(R.id.tvDireccion);
        ed_mi_negocio_titulo = (EditText)  findViewById(R.id.et_titulo_negocio);
        progressBar = (ProgressBar) findViewById(R.id.progress_actualizar_ubicacion);


        //set listener
        btn_verMapa.setOnClickListener(this);
        btn_actualizar.setOnClickListener(this);
        btn_back.setOnClickListener(this);

        //init
        presenter = new MyNegocioPresenter(this, new MyNegocioInteractor());

        //inicializa negocio
        presenter.getUbicacionNegocioPorId();

    }


    public void setActualizarInformacion(){
        //if(Constantes.RETURN_MAP_LONGITUD!=0 && Constantes.RETURN_MAP_LATITUD!=0 ){
            presenter.setDetalleTienda(Constantes.RETURN_MAP_LATITUD,Constantes.RETURN_MAP_LONGITUD,ed_mi_negocio_titulo.getText().toString());
        //}
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_actualizar_ubicacion_negocio:
                setActualizarInformacion();
                break;
            case R.id.btn_ver_mapa:
                startActivity(new Intent(this, RegistaraNegocioActivity.class));
                //finish();
                break;
            case R.id.btn_back:
                startActivity(new Intent(this, PerfilActivity.class));
                finish();
                break;

        }
    }


    @Override
    public void showMyNegocio(String nombreNegocio, double latitud, double longitud) {

        if(longitud!=0 && latitud!=0){
            MyLocationDetails locationDetails = new MyLocationDetails(this,latitud,longitud);
            ed_mi_negocio_titulo.setText(nombreNegocio);
            tv_NombreTienda.setText(locationDetails.getCiudad());
            tv_DireccionTienda.setText(locationDetails.getDireccion());
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
    public void showMessage(String message) {
        Toast toast = Toast.makeText(this, message,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onResume() {
        //Verificar
        if(Constantes.RETURN_MAP_LONGITUD!=0 && Constantes.RETURN_MAP_LATITUD!=0 ){
            MyLocationDetails locationDetails = new MyLocationDetails(this,Constantes.RETURN_MAP_LATITUD,Constantes.RETURN_MAP_LONGITUD);
            tv_NombreTienda.setText(locationDetails.getCiudad());
            tv_DireccionTienda.setText(locationDetails.getDireccion());
        }
        super.onResume();

    }

}




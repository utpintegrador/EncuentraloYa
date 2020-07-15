package com.example.encuentraloya.view.Implement;


import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.encuentraloya.R;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.MyLocation;
import com.example.encuentraloya.comun.MyLocationDetails;
import com.example.encuentraloya.view.IMyLocation;

public class ListaTiendasCercanasActivity extends AppCompatActivity
        implements IMyLocation {


    ImageView img_ver;
    TextView tvDistancia;
    MyLocation location;
    MyLocationDetails locationDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tiendas_cercanas);


        img_ver = (ImageView) findViewById(R.id.imageVerd);
        tvDistancia = (TextView)  findViewById(R.id.tvDistancia);

        location = new MyLocation(this,this  );

    }


    @Override
    public void showMyLocation() {
        location=null;
        locationDetails = new MyLocationDetails(this, Constantes.LATITUD_VALUE,Constantes.LONGITUD_VALUE);
        tvDistancia.setText(locationDetails.getDireccion());
        locationDetails=null;

    }
}

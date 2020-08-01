package com.example.encuentraloya.comun.UbicacionGPS;


import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Localizacion implements LocationListener{


    Activity mainActivity;
   // TextView tvMensaje;
    IMyLocationService listener;

    public void setMainActivity(Activity mainActivity, IMyLocationService listener) {
        this.mainActivity = mainActivity;
        //this.tvMensaje = tvMensaje;
        this.listener = listener;
    }

    @Override
    public void onLocationChanged(Location location) {
        // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
        String texto = "Mi ubicación es: \n" +
                "Latitud = " + location.getLatitude() + "\n" +
                "Longitud = " + location.getLongitude();

       // tvMensaje.setText(texto);

        listener.showCoordanadas(location.getLatitude(),location.getLongitude());

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
        //tvMensaje.setText("GPS Activado");
        listener.showMensajeGPS("GPS Activad");
    }

    @Override
    public void onProviderDisabled(String provider) {
        //tvMensaje.setText("GPS Desactivado");
        listener.showMensajeGPS("GPS Desactivado");
    }

}

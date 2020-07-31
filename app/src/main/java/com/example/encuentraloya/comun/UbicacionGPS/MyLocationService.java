package com.example.encuentraloya.comun.UbicacionGPS;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class MyLocationService implements LocationListener {
    Context context;
    LocationManager locationManager;
    IMyLocationService iMyLocationService;


    public MyLocationService(Context context, IMyLocationService iMyLocationService) {
        this.context = context;
        this.iMyLocationService =iMyLocationService;

        int permissionCheck = ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION);

        if(permissionCheck != PackageManager.PERMISSION_GRANTED) {
            // solicitar permso
            ActivityCompat.requestPermissions( (Activity) context,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    99);
        }

        //activo detección de mi ubicación
        getLocation();


    }

    public void getLocation(){
        try{

            if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                            PackageManager.PERMISSION_GRANTED) {

                locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,5,this);

            } else {
                iMyLocationService.showMensajeGPS("Error de permiso");
            }


        }catch (SecurityException e){
            e.printStackTrace();
            iMyLocationService.showMensajeGPS("Error de permiso");
        }
    }


    @Override
    public void onLocationChanged(Location location) {
        iMyLocationService.showCoordanadas(location.getLatitude(),location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}

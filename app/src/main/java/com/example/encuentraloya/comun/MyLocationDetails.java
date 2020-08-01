package com.example.encuentraloya.comun;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MyLocationDetails {
    Context context;

    String direccion;
    String ciudad;
    String estado;
    String pais;
    String codigoPostal;

    public MyLocationDetails(Context context, double latitud, double longitud) {
        this.context = context;

        Geocoder geocoder;
        List<Address> direccionDetalle;
        geocoder = new Geocoder(context, Locale.getDefault());
        try {
            direccionDetalle =  geocoder.getFromLocation(latitud, longitud, 1);
            direccion=direccionDetalle.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            ciudad=direccionDetalle.get(0).getLocality();
            estado=direccionDetalle.get(0).getAdminArea();
            pais = direccionDetalle.get(0).getCountryName();
            codigoPostal = direccionDetalle.get(0).getPostalCode();;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
}

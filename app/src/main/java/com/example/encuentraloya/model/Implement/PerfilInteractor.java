package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.model.Interfaces.OnPerfilFinishedListener;

public class PerfilInteractor {


    public void getPerfilData(final OnPerfilFinishedListener listener){
        String nombre = SharedPreferencesManager.getStringValue(Constantes.PREF_NOMBRE);
        String apellido = SharedPreferencesManager.getStringValue(Constantes.PREF_APELLIDO);
        String correo = SharedPreferencesManager.getStringValue(Constantes.PREF_CORREOELECTRONICO);
        String nombreCompleto = nombre + " " + apellido;
        listener.onSuccesGetPerfilData(nombre,correo);
    }

}

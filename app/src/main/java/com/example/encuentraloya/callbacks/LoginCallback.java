package com.example.encuentraloya.callbacks;

import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.LoginInformationResponse;
import com.example.encuentraloya.model.Interfaces.OnLoginFinishedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginCallback implements Callback<LoginInformationResponse> {

    private OnLoginFinishedListener listener;
    private String username;
    private boolean recordarCuenta;

    public LoginCallback(OnLoginFinishedListener listener, String username, boolean recordarCuenta) {
        this.listener = listener;
        this.username = username;
        this.recordarCuenta = recordarCuenta;
    }

    @Override
    public void onResponse(Call<LoginInformationResponse> call, Response<LoginInformationResponse> response) {
        if (response.isSuccessful()) {
            LoginInformationResponse loginResponse = response.body();
            if (loginResponse.getToken() != null) {
                //si se tiene activo el check de recordar cuenta, se guarda sharepreferences
                if (recordarCuenta) {
                    SharedPreferencesManager.setBooleanValue(Constantes.PREF_RECORDAR_ACCESO, recordarCuenta);
                    SharedPreferencesManager.setStringValue(Constantes.PREF_USERNAME, username);
                }
                listener.onSuccess();
            } else {
                listener.onError("El usuario ingresado no es válido");
            }
        } else {
            listener.onError(response.message().toString());
        }
    }

    @Override
    public void onFailure(Call<LoginInformationResponse> call, Throwable t) {
        listener.onError(t.getMessage());
    }
}
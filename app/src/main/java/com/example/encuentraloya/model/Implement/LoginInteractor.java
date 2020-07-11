package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.Servicios.APIService;
import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.callbacks.LoginCallback;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.LoginInformationRequest;
import com.example.encuentraloya.model.Interfaces.OnLoginFinishedListener;

public class LoginInteractor {
    private APIService mAPIService;

    public void login(final String username, final String password, final boolean recordarCuenta, final OnLoginFinishedListener listener) {
        LoginInformationRequest objUsu = new LoginInformationRequest();
        objUsu.setEmail(username);
        objUsu.setContrasenia(password);

        mAPIService = ApiUtils.getAPIService();

        mAPIService.login(objUsu).enqueue(new LoginCallback(listener, username, recordarCuenta));
    }

    public void verificaCuentaSiRecordar(final OnLoginFinishedListener listener) {
        boolean accesoValido = SharedPreferencesManager.getBooleanValue(Constantes.PREF_RECORDAR_ACCESO);

        if (!accesoValido) {
            listener.offRecordarCuenta();
        } else if (accesoValido) {
            listener.onSuccess();
        }
    }

}

package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.Servicios.APIService;
import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.Request.LoginInformationRequest;
import com.example.encuentraloya.entidad.Response.LoginInformationResponse;
import com.example.encuentraloya.model.Interfaces.OnLoginFinishedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor {
    private APIService mAPIService;

    public void login(final String username, final String password, final boolean recordarCuenta , final OnLoginFinishedListener listener) {
        LoginInformationRequest objUsu = new LoginInformationRequest();
        objUsu.setCorreoElectronico(username);
        objUsu.setContrasenia(password);

        mAPIService = ApiUtils.getAPIService();

        mAPIService.login(objUsu).enqueue(new Callback<LoginInformationResponse>() {
            @Override
            public void onResponse(Call<LoginInformationResponse> call, Response<LoginInformationResponse> response) {
                if(response.isSuccessful()) {
                    LoginInformationResponse loginResponse = response.body();
                    if (loginResponse.getToken() != null){
                        //si se tiene activo el check de recordar cuenta, se guarda sharepreferences
                        if(recordarCuenta==true){
                            SharedPreferencesManager.setBooleanValue(Constantes.PREF_RECORDAR_ACCESO,recordarCuenta);
                            SharedPreferencesManager.setStringValue(Constantes.PREF_USERNAME,username);
                        }
                        listener.onSuccess();
                    }else{
                        listener.onError("El usuario ingresado no es válido");
                    }

                }else{
                    listener.onError(response.message().toString());
                }
            }

            @Override
            public void onFailure(Call<LoginInformationResponse> call, Throwable t) {
                listener.onError(t.getMessage().toString());
            }
        });




    }

    public void verificaCuentaSiRecordar(final OnLoginFinishedListener listener){
       boolean accesoValido = SharedPreferencesManager.getBooleanValue(Constantes.PREF_RECORDAR_ACCESO);

       if(accesoValido==false){
            listener.offRecordarCuenta();
       }else if(accesoValido==true){
           listener.onSuccess();
       }

    }


}

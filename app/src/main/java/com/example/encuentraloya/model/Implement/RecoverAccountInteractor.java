package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.Servicios.APIService;
import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.Request.RecuperarCuentaRequest;
import com.example.encuentraloya.entidad.Response.LoginInformationResponse;
import com.example.encuentraloya.entidad.Response.RecuperarCuentaResponse;
import com.example.encuentraloya.model.Interfaces.OnRecoverAccountFinishedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecoverAccountInteractor {
    private APIService mAPIService;

    public  void getSolicitarPassword(final String correoElectronico, final OnRecoverAccountFinishedListener listener){

        final RecuperarCuentaRequest entity = new RecuperarCuentaRequest();
        entity.setCorreoElectronico(correoElectronico);

        mAPIService = ApiUtils.getAPIService();


        mAPIService.recuperarContrasenia(entity).enqueue(new Callback<RecuperarCuentaResponse>() {
            @Override
            public void onResponse(Call<RecuperarCuentaResponse> call, Response<RecuperarCuentaResponse> response) {
                if(response.isSuccessful()) {
                    RecuperarCuentaResponse entityResponse = response.body();
                    listener.onMessage(entityResponse.getCuerpo().getDescripcionRespuesta());
                }
            }

            @Override
            public void onFailure(Call<RecuperarCuentaResponse> call, Throwable t) {
                listener.onMessage(t.getMessage().toString());
            }
        });



    }



}

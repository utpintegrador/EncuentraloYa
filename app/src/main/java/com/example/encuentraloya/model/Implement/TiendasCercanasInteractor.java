package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.INegocioService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.NegocioDto;
import com.example.encuentraloya.entidad.Request.ObtenerTiendasCercanasRequest;
import com.example.encuentraloya.entidad.Response.ObtenerTiendasCercanasResponse;
import com.example.encuentraloya.model.Interfaces.OnTiendasCercanasFinishedListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TiendasCercanasInteractor {
    INegocioService negocioService;

    public void getAllTiendasCercanas(final OnTiendasCercanasFinishedListener listener ){

        ObtenerTiendasCercanasRequest entity = new ObtenerTiendasCercanasRequest();
        entity.setIdUsuario(SharedPreferencesManager.getIntValue(Constantes.PREF_IDUSUARIOAUTENTICADO));
        entity.setBuscar("");
        entity.setUbicacionLatitudInicio(Constantes.LATITUD_VALUE);
        entity.setUbicacionLongitudInicio(Constantes.LONGITUD_VALUE);
        entity.setCantidadKilometros(1000);

        negocioService = ApiUtils.getAPIServiceNegocio();
        negocioService.ObtenerNegociosCercanos(entity).enqueue(new Callback<ObtenerTiendasCercanasResponse>() {
            @Override
            public void onResponse(Call<ObtenerTiendasCercanasResponse> call, Response<ObtenerTiendasCercanasResponse> response) {
                if(response.isSuccessful() && response.body().getProcesadoOk()== Constantes.SUCCESS_RESULT){
                    List<NegocioDto> lista = response.body().getCuerpo();
                    listener.onListaTiendasCercanasSuccess(lista);
                }
            }

            @Override
            public void onFailure(Call<ObtenerTiendasCercanasResponse> call, Throwable t) {
                listener.onMessage("Al parecer hubo un error");
            }
        });


    }

}

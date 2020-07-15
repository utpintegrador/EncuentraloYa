package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.Servicios.APIService;
import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.IUbicacionNegocioService;
import com.example.encuentraloya.entidad.Request.UbicacionNegocioRequest;
import com.example.encuentraloya.entidad.Response.ObtenerUbicacionNegocioPorIdResponse;
import com.example.encuentraloya.entidad.Response.UbicacionNegocioResponse;
import com.example.encuentraloya.entidad.UbicacionNegocioDto;
import com.example.encuentraloya.model.Interfaces.OnMyNegocioFinishedListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyNegocioInteractor {
    private APIService mAPIService;
    private IUbicacionNegocioService UbicacionService;

    public void setDetalleTienda(final double latitud, final double longitud, final String tituloNegocio, final OnMyNegocioFinishedListener listener){
        final UbicacionNegocioRequest entity = new UbicacionNegocioRequest();
        entity.setLatitud(latitud);
        entity.setLongitud(longitud);
        entity.setTitulo(tituloNegocio);
        entity.setDescripcion("");
        entity.setIdNegocio(21);

        mAPIService = ApiUtils.getAPIService();
        mAPIService.negocioUbicacion(entity).enqueue(new Callback<UbicacionNegocioResponse>() {
            @Override
            public void onResponse(Call<UbicacionNegocioResponse> call, Response<UbicacionNegocioResponse> response) {
                if(response.isSuccessful()){
                    UbicacionNegocioResponse entityResponse = response.body();
                    if(entityResponse.getIdGenerado()>0){
                        listener.onSuccesSaveUbicacion();

                    }
                }

            }

            @Override
            public void onFailure(Call<UbicacionNegocioResponse> call, Throwable t) {
                listener.onMensaje("Al parecer hubo un error");
            }
        });

    }


    public void getUbicacionNegocioPorId(final OnMyNegocioFinishedListener listener){

        UbicacionService = ApiUtils.getAPIServiceaUbicacionNegocio();
        UbicacionService.ObtenerPorId(7).enqueue(new Callback<ObtenerUbicacionNegocioPorIdResponse>() {
            @Override
            public void onResponse(Call<ObtenerUbicacionNegocioPorIdResponse> call, Response<ObtenerUbicacionNegocioPorIdResponse> response) {
                if(response.isSuccessful()){
                    ObtenerUbicacionNegocioPorIdResponse entityResponse =response.body();

                    String negocioTitulo="";
                    double latitud=0;
                    double longitud=0;

                    if(response.body().getProcesadoOk().equals(1)){
                        UbicacionNegocioDto entity =  response.body().getCuerpo();
                        negocioTitulo=entity.getTitulo();
                        latitud=entity.getLatitud();
                        longitud=entity.getLongitud();
                    }

                    listener.onSuccesGetDetalleTiendas(negocioTitulo,"",latitud,longitud);

                }
            }

            @Override
            public void onFailure(Call<ObtenerUbicacionNegocioPorIdResponse> call, Throwable t) {
                listener.onMensaje("Al parecer hubo un error");
            }
        });

    }


}

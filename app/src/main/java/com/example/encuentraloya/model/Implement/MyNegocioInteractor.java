package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.Servicios.APIService;
import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.IUbicacionNegocioService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.Request.UbicacionNegocioRequest;
import com.example.encuentraloya.entidad.Response.ObtenerUbicacionNegocioPorIdResponse;
import com.example.encuentraloya.entidad.Response.UbicacionNegocioResponse;
import com.example.encuentraloya.entidad.Response.genericListError;
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

        if (getIdNegocioUbicacionSharedPreferences()!= 0) { //caso este almacenado en sharedpreferences

            final UbicacionNegocioDto obj = new UbicacionNegocioDto();
            obj.setIdNegocioUbicacion(getIdNegocioUbicacionSharedPreferences());
            obj.setTitulo(tituloNegocio);
            obj.setDescripcion("");
            obj.setPredeterminado(true);
            if(latitud!= 0 && longitud != 0){
                obj.setLatitud(latitud);
                obj.setLongitud(longitud);
            }else {
                obj.setLatitud( Double.parseDouble(SharedPreferencesManager.getStringValue(Constantes.PREF_LATITUD_NEGOCIO)));
                obj.setLongitud( Double.parseDouble(SharedPreferencesManager.getStringValue(Constantes.PREF_LONGITUD_NEGOCIO)));
            }

            //actualizar
            UbicacionService =ApiUtils.getAPIServiceaUbicacionNegocio();
            UbicacionService.negocioUbicacionActualizaar(obj).enqueue(new Callback<genericListError>() {
                @Override
                public void onResponse(Call<genericListError> call, Response<genericListError> response) {
                    if(response.isSuccessful()){
                        if(response.body().getProcesadoOk()==1){
                            SharedPreferencesManager.setStringValue(Constantes.PREF_LATITUD_NEGOCIO,String.valueOf(obj.getLatitud()));
                            SharedPreferencesManager.setStringValue(Constantes.PREF_LONGITUD_NEGOCIO,String.valueOf(obj.getLongitud()));
                            SharedPreferencesManager.setStringValue(Constantes.PREF_TITULO_NEGOCIO,obj.getTitulo());
                             listener.onSuccesSaveUbicacion();
                        }
                    }
                }

                @Override
                public void onFailure(Call<genericListError> call, Throwable t) {
                    listener.onMensaje("Al parecer hubo un error");
                }
            });

        }else{
            //nuevo
            final UbicacionNegocioRequest entity = new UbicacionNegocioRequest();
            entity.setLatitud(latitud);
            entity.setLongitud(longitud);
            entity.setTitulo(tituloNegocio);
            entity.setDescripcion("");
            entity.setIdNegocio(getIdNegocioSharedPreferences()); // OBTIENE DEL SHAREPREFERENCES


            mAPIService = ApiUtils.getAPIService();
            mAPIService.negocioUbicacion(entity).enqueue(new Callback<UbicacionNegocioResponse>() {
                @Override
                public void onResponse(Call<UbicacionNegocioResponse> call, Response<UbicacionNegocioResponse> response) {
                    if(response.isSuccessful()){
                        UbicacionNegocioResponse entityResponse = response.body();
                        if(entityResponse.getIdGenerado()>0){

                            SharedPreferencesManager.setStringValue(Constantes.PREF_LATITUD_NEGOCIO,String.valueOf(entity.getLatitud()));
                            SharedPreferencesManager.setStringValue(Constantes.PREF_LONGITUD_NEGOCIO,String.valueOf(entity.getLongitud()));
                            SharedPreferencesManager.setIntValue(Constantes.PREF_ID_UBICACION_NEGOCIO,entityResponse.getIdGenerado());
                            SharedPreferencesManager.setStringValue(Constantes.PREF_TITULO_NEGOCIO,entity.getTitulo());
                            SharedPreferencesManager.setStringValue(Constantes.PREF_DESCRIPCION_NEGOCIO, entity.getDescripcion());

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



    }


    public void getUbicacionNegocioPorId(final OnMyNegocioFinishedListener listener){


        if (getIdNegocioUbicacionSharedPreferences()!= 0){ //caso este almacenado en sharedpreferences

            String tituloNegocio = SharedPreferencesManager.getStringValue(Constantes.PREF_NOMBRENEGOCIO);
            double latitud = Double.parseDouble(SharedPreferencesManager.getStringValue(Constantes.PREF_LATITUD_NEGOCIO));
            double longitud = Double.parseDouble(SharedPreferencesManager.getStringValue(Constantes.PREF_LONGITUD_NEGOCIO));
            listener.onSuccesGetDetalleTiendas(tituloNegocio,"",latitud,longitud);

        }else{

            UbicacionService = ApiUtils.getAPIServiceaUbicacionNegocio();
            UbicacionService.ObtenerPorId(getIdNegocioUbicacionSharedPreferences()).enqueue(new Callback<ObtenerUbicacionNegocioPorIdResponse>() {
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


    public int getIdNegocioUbicacionSharedPreferences(){
        int id;
        id= SharedPreferencesManager.getIntValue(Constantes.PREF_ID_UBICACION_NEGOCIO);
        return  id;

    }

    public int getIdNegocioSharedPreferences(){
        int id;
        id= SharedPreferencesManager.getIntValue(Constantes.PREF_IDNEGOCIO);
        return  id;

    }
}

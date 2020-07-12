package com.example.encuentraloya.model.Implement;


import com.example.encuentraloya.Servicios.APIService;
import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.entidad.CategoriaDto;
import com.example.encuentraloya.entidad.Request.CategoriaRequest;
import com.example.encuentraloya.entidad.Response.CategoriaResponse;
import com.example.encuentraloya.model.Interfaces.IOnHomeFinishedListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteractor {
    private APIService mAPIService;


    public void getAllCategoria(final IOnHomeFinishedListener listener){

        final CategoriaRequest entity = new CategoriaRequest();
        entity.setBuscar("");
        entity.setCantidadRegistros(0);
        entity.setColumnaOrden("");
        entity.setDireccionOrden("");
        entity.setIdEstado(0);
        entity.setNumeroPagina(0);



        mAPIService = ApiUtils.getAPIService();

        mAPIService.obtenerCategorias(entity).enqueue(new Callback<CategoriaResponse>() {
            @Override
            public void onResponse(Call<CategoriaResponse> call, Response<CategoriaResponse> response) {

                if(response.isSuccessful()) {
                    if (response.body().getCantidadTotalRegistros()>0){
                        List<CategoriaDto> listaCategoria =  response.body().getCategoriaDto();
                        listener.onCategoriaSucces(listaCategoria);
                    }


                }
            }

            @Override
            public void onFailure(Call<CategoriaResponse> call, Throwable t) {
                listener.onMessage(t.getMessage().toString());
            }
        });


    }


}

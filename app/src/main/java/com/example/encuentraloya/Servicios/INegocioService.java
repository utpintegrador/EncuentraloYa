package com.example.encuentraloya.Servicios;

import com.example.encuentraloya.entidad.Response.ObtenerNegociosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface INegocioService {

    @GET("Negocio/ObtenerCombo/{idUsuario}")
    Call<ObtenerNegociosResponse> ObtenerPorIdUsuario(@Path("idUsuario") long idNegocio);

}

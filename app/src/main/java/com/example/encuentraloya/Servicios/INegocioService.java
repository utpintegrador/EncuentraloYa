package com.example.encuentraloya.Servicios;

import com.example.encuentraloya.entidad.Request.ObtenerTiendasCercanasRequest;
import com.example.encuentraloya.entidad.Request.PedidoObtenerRequest;
import com.example.encuentraloya.entidad.Response.ObtenerNegociosResponse;
import com.example.encuentraloya.entidad.Response.ObtenerTiendasCercanasResponse;
import com.example.encuentraloya.entidad.Response.PedidoObtenerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface INegocioService {

    @GET("Negocio/ObtenerCombo/{idUsuario}")
    Call<ObtenerNegociosResponse> ObtenerPorIdUsuario(@Path("idUsuario") long idNegocio);

    @POST("Negocio/ObtenerCercanos")
    Call<ObtenerTiendasCercanasResponse> ObtenerNegociosCercanos(@Body ObtenerTiendasCercanasRequest entity);
}

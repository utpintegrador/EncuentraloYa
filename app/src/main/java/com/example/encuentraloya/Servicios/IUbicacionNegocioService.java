package com.example.encuentraloya.Servicios;

import com.example.encuentraloya.entidad.Request.ObtenerProdByNegocioRequest;
import com.example.encuentraloya.entidad.Request.UbicacionNegocioRequest;
import com.example.encuentraloya.entidad.Response.ObtenerUbicacionNegocioPorIdNegocioResponse;
import com.example.encuentraloya.entidad.Response.ObtenerUbicacionNegocioPorIdResponse;
import com.example.encuentraloya.entidad.Response.UbicacionNegocioResponse;
import com.example.encuentraloya.entidad.Response.genericListError;
import com.example.encuentraloya.entidad.UbicacionNegocioDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IUbicacionNegocioService {
    @POST("NegocioUbicacion")
    Call<UbicacionNegocioResponse> negocioUbicacion(@Body UbicacionNegocioRequest entity);

    @GET("NegocioUbicacion/{id}")
    Call<ObtenerUbicacionNegocioPorIdResponse> ObtenerPorId(@Path("id") long idNegocioUbicacion);

    @PUT("NegocioUbicacion")
    Call<genericListError> negocioUbicacionActualizaar(@Body UbicacionNegocioDto entity);

    @POST("NegocioUbicacion/ObtenerPorIdNegocio")
    Call<ObtenerUbicacionNegocioPorIdNegocioResponse> ObtenerPorIdNegocio(@Body ObtenerProdByNegocioRequest entity);

}

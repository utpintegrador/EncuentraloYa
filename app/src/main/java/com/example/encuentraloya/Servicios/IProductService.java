package com.example.encuentraloya.Servicios;

import com.example.encuentraloya.entidad.Request.ObtenerProdByNegocioRequest;
import com.example.encuentraloya.entidad.Response.ObtenerProdByNegocioResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IProductService {
    @POST("Producto/ObtenerPorIdNegocio")
    Call<ObtenerProdByNegocioResponse> obtenerPorIdNegocio(@Body ObtenerProdByNegocioRequest entity);

}

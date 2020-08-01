package com.example.encuentraloya.Servicios;



import com.example.encuentraloya.entidad.PedidoDto;
import com.example.encuentraloya.entidad.Request.GraficoCompraRequest;
import com.example.encuentraloya.entidad.Request.PedidoDetalleResponse;
import com.example.encuentraloya.entidad.Request.PedidoObtenerRequest;
import com.example.encuentraloya.entidad.Response.GraficoCompraResponse;
import com.example.encuentraloya.entidad.Response.PedidoObtenerResponse;
import com.example.encuentraloya.entidad.Response.genericListError;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IPedidoService {

    @POST("Pedido/ObtenerPorIdNegocioComprador")
    Call<PedidoObtenerResponse> ObtenerPorIdNegocioComprador(@Body PedidoObtenerRequest entity);

    @GET("Pedido/ObtenerPorIdConDetalles/{id}")
    Call<PedidoDetalleResponse> ObtenerPorIdConDetalles(@Path("id") long idPedido);

    @POST("Pedido")
    Call<genericListError> guardarPedido(@Body PedidoDto entity);

    @POST("GraficoMovil/ObtenerResumenCompras")
    Call<GraficoCompraResponse> ObtenerResumenCompras(@Body GraficoCompraRequest entity);

}

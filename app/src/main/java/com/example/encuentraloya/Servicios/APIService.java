package com.example.encuentraloya.Servicios;


import com.example.encuentraloya.entidad.Request.CategoriaRequest;
import com.example.encuentraloya.entidad.Request.CreateUserRequest;
import com.example.encuentraloya.entidad.Request.RecuperarCuentaRequest;
import com.example.encuentraloya.entidad.Request.UbicacionNegocioRequest;
import com.example.encuentraloya.entidad.Response.CategoriaResponse;
import com.example.encuentraloya.entidad.Response.CreateUserResponse;
import com.example.encuentraloya.entidad.Request.LoginInformationRequest;
import com.example.encuentraloya.entidad.Response.LoginInformationResponse;
import com.example.encuentraloya.entidad.Response.RecuperarCuentaResponse;
import com.example.encuentraloya.entidad.Response.UbicacionNegocioResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface APIService {

    @POST("Login")
    Call<LoginInformationResponse> login(@Body LoginInformationRequest loginInformation);

    @POST("Usuario")
    Call<CreateUserResponse> registrar(@Body CreateUserRequest createUser);

    @POST("RecuperacionContrasenia")
    Call<RecuperarCuentaResponse> recuperarContrasenia(@Body RecuperarCuentaRequest entity);

    @POST("Categoria/Obtener")
   Call<CategoriaResponse> obtenerCategorias(@Body CategoriaRequest entity);


    @POST("NegocioUbicacion")
    Call<UbicacionNegocioResponse> negocioUbicacion(@Body UbicacionNegocioRequest entity);




}
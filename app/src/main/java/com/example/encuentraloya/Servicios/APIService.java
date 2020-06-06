package com.example.encuentraloya.Servicios;


import com.example.encuentraloya.entidad.CreateUserRequest;
import com.example.encuentraloya.entidad.CreateUserResponse;
import com.example.encuentraloya.entidad.LoginInformationRequest;
import com.example.encuentraloya.entidad.LoginInformationResponse;
import com.example.encuentraloya.entidad.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface APIService {

    @POST("Login")
    Call<LoginInformationResponse> login(@Body LoginInformationRequest loginInformation);



    @POST("Usuario")
    Call<CreateUserResponse> registrar(@Body CreateUserRequest createUser);

}
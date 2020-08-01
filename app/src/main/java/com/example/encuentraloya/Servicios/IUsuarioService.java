package com.example.encuentraloya.Servicios;

import com.example.encuentraloya.entidad.Response.UsuarioSubirImagenResponseDto;
import com.example.encuentraloya.entidad.Response.genericListError;
import com.example.encuentraloya.entidad.Usuario;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface IUsuarioService {
    @PUT("Usuario/ModificarContrasenia")
    Call<genericListError> modificarContrasenia(@Body Usuario entity);

    @Multipart
    @POST("Usuario/ImagenMetodo3")
    Call<UsuarioSubirImagenResponseDto> SubirImagen(@Part MultipartBody.Part archivo,
                                                    @Part("IdUsuario") RequestBody idUsuario);
    //Usuario/ImagenMetodo3
}

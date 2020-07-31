package com.example.encuentraloya.model.Implement;

import android.util.Log;

import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.IUsuarioService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.Response.UsuarioSubirImagenResponseDto;
import com.example.encuentraloya.model.Interfaces.OnPerfilFinishedListener;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilInteractor {
    private IUsuarioService usuarioService;

    public void getPerfilData(final OnPerfilFinishedListener listener){
        String nombre = SharedPreferencesManager.getStringValue(Constantes.PREF_NOMBRE);
        String apellido = SharedPreferencesManager.getStringValue(Constantes.PREF_APELLIDO);
        String correo = SharedPreferencesManager.getStringValue(Constantes.PREF_CORREOELECTRONICO);
        String urlImagenPerfil = SharedPreferencesManager.getStringValue(Constantes.PREF_URLIMAGENUSUARIO);
        String nombreCompleto = nombre + " " + apellido;
        listener.onSuccesGetPerfilData(nombre,correo,urlImagenPerfil);
    }

    public  void setClearSharedPreferences(final OnPerfilFinishedListener listener){
        if(SharedPreferencesManager.clearSharedPreferences()){
            listener.onCerrarSesion();
        }
    }

    public void SubirImagen(String rutaArchivo, final OnPerfilFinishedListener listener){
        String idUsuarioAutenticado =  String.valueOf(SharedPreferencesManager.getIntValue(Constantes.PREF_IDUSUARIOAUTENTICADO));

        File file = new File(rutaArchivo);
        RequestBody photoContent = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        RequestBody idUsuario = RequestBody.create(MediaType.parse("text/plain"), idUsuarioAutenticado);

        MultipartBody.Part photo = MultipartBody.Part.createFormData("Archivo", file.getName(), photoContent);
        usuarioService = ApiUtils.getAPIUsuarioService();

       Call<UsuarioSubirImagenResponseDto> call = usuarioService.SubirImagen(photo,idUsuario);
       call.enqueue(new Callback<UsuarioSubirImagenResponseDto>() {
           @Override
           public void onResponse(Call<UsuarioSubirImagenResponseDto> call, Response<UsuarioSubirImagenResponseDto> response) {
               if(response.isSuccessful()){
                   listener.onMensaje("");
               }
           }

           @Override
           public void onFailure(Call<UsuarioSubirImagenResponseDto> call, Throwable t) {
               listener.onMensaje(t.getMessage());
           }
       });






    }



}

package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.Servicios.APIService;
import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.INegocioService;
import com.example.encuentraloya.Servicios.IUbicacionNegocioService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.NegocioDto;
import com.example.encuentraloya.entidad.Request.LoginInformationRequest;
import com.example.encuentraloya.entidad.Request.ObtenerProdByNegocioRequest;
import com.example.encuentraloya.entidad.Response.LoginInformationResponse;
import com.example.encuentraloya.entidad.Response.ObtenerNegociosResponse;
import com.example.encuentraloya.entidad.Response.ObtenerUbicacionNegocioPorIdNegocioResponse;
import com.example.encuentraloya.entidad.UbicacionNegocioDto;
import com.example.encuentraloya.model.Interfaces.OnLoginFinishedListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor {
    private APIService mAPIService;
    private INegocioService negocioService;
    private IUbicacionNegocioService unegocioService;

    public void login(final String username, final String password, final boolean recordarCuenta, final OnLoginFinishedListener listener) {
        LoginInformationRequest objUsu = new LoginInformationRequest();
        objUsu.setCorreoElectronico(username);
        objUsu.setContrasenia(password);

        mAPIService = ApiUtils.getAPIService();

        mAPIService.login(objUsu).enqueue(new Callback<LoginInformationResponse>() {
            @Override
            public void onResponse(Call<LoginInformationResponse> call, Response<LoginInformationResponse> response) {
                if (response.isSuccessful()) {
                    LoginInformationResponse loginResponse = response.body();
                    if (loginResponse.getToken() != null) {
                        SharedPreferencesManager.setStringValue(Constantes.PREF_TOKEN, loginResponse.getToken());
                        SharedPreferencesManager.setIntValue(Constantes.PREF_IDUSUARIOAUTENTICADO, loginResponse.getIdUsuario());
                        SharedPreferencesManager.setStringValue(Constantes.PREF_NOMBRE, loginResponse.getNombre());
                        SharedPreferencesManager.setStringValue(Constantes.PREF_APELLIDO, loginResponse.getApellido());
                        SharedPreferencesManager.setStringValue(Constantes.PREF_CORREOELECTRONICO, loginResponse.getCorreoElectronico());
                        SharedPreferencesManager.setStringValue(Constantes.PREF_URLIMAGENUSUARIO, loginResponse.getUrlImagen());
                        obtenerNegocioByIdUsuario(loginResponse.getIdUsuario(), listener);
                        listener.onSuccess();
                    } else {
                        listener.onError("El usuario ingresado no es válido");
                    }

                } else {
                    listener.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<LoginInformationResponse> call, Throwable t) {
                listener.onError(t.getMessage().toString());
            }
        });
    }

    public void obtenerNegocioByIdUsuario(int idUsuario, final OnLoginFinishedListener listener) {
        negocioService = ApiUtils.getAPIServiceNegocio();
        negocioService.ObtenerPorIdUsuario(idUsuario).enqueue(new Callback<ObtenerNegociosResponse>() {
            @Override
            public void onResponse(Call<ObtenerNegociosResponse> call, Response<ObtenerNegociosResponse> response) {
                if (response.isSuccessful()) {
                    List<NegocioDto> entitys = response.body().getCuerpo();
                    if (entitys.size() > 0) {
                        NegocioDto entityResponse = entitys.get(0);
                        SharedPreferencesManager.setIntValue(Constantes.PREF_IDNEGOCIO, entityResponse.getIdNegocio());
                        SharedPreferencesManager.setStringValue(Constantes.PREF_NOMBRENEGOCIO, entityResponse.getNombre());
                        obtenerUbicacionNegocioByIdNegocio(entityResponse.getIdNegocio());
                        listener.onSuccess();
                    }
                }
            }

            @Override
            public void onFailure(Call<ObtenerNegociosResponse> call, Throwable t) {

            }
        });
    }

    public void obtenerUbicacionNegocioByIdNegocio(int idNegocio) {
        ObtenerProdByNegocioRequest entity = new ObtenerProdByNegocioRequest();
        entity.setIdBusiness(idNegocio);

        unegocioService = ApiUtils.getAPIServiceaUbicacionNegocio();
        unegocioService.ObtenerPorIdNegocio(entity).enqueue(new Callback<ObtenerUbicacionNegocioPorIdNegocioResponse>() {
            @Override
            public void onResponse(Call<ObtenerUbicacionNegocioPorIdNegocioResponse> call, Response<ObtenerUbicacionNegocioPorIdNegocioResponse> response) {
                if (response.isSuccessful()) {
                    List<UbicacionNegocioDto> entitys = response.body().getCuerpo();
                    if (entitys.size() > 0) {
                        UbicacionNegocioDto entityResponse = entitys.get(0);
                        SharedPreferencesManager.setStringValue(Constantes.PREF_LATITUD_NEGOCIO, entityResponse.getLatitud().toString());
                        SharedPreferencesManager.setStringValue(Constantes.PREF_LONGITUD_NEGOCIO, entityResponse.getLongitud().toString());
                        SharedPreferencesManager.setIntValue(Constantes.PREF_ID_UBICACION_NEGOCIO, entityResponse.getIdNegocioUbicacion());
                        SharedPreferencesManager.setStringValue(Constantes.PREF_TITULO_NEGOCIO, entityResponse.getTitulo());
                        SharedPreferencesManager.setStringValue(Constantes.PREF_DESCRIPCION_NEGOCIO, entityResponse.getDescripcion());
                    }
                    //listener.onSuccess();
                }
            }

            @Override
            public void onFailure(Call<ObtenerUbicacionNegocioPorIdNegocioResponse> call, Throwable t) {

            }
        });
    }

    public void verificaCuentaSiRecordar(final OnLoginFinishedListener listener) {
        boolean accesoValido = SharedPreferencesManager.getBooleanValue(Constantes.PREF_RECORDAR_ACCESO);

        if (accesoValido == false) {
            listener.offRecordarCuenta();
        } else if (accesoValido == true) {
            listener.onSuccess();
        }

    }

}

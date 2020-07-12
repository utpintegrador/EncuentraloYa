package com.example.encuentraloya.model.Implement;
import com.example.encuentraloya.Servicios.APIService;
import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.entidad.Request.CreateUserRequest;
import com.example.encuentraloya.entidad.Response.CreateUserResponse;
import com.example.encuentraloya.model.Interfaces.OnRegisterUsuarioFinishedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterUsuarioInteractor {

    private APIService mAPIService;

    public void registrar(final String nombre, final String apellido, final String correcoElectronico, final String contrasenia
            ,final OnRegisterUsuarioFinishedListener listener) {

        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setEmail(correcoElectronico);
        userRequest.setName(nombre);
        userRequest.setLastName(apellido);
        userRequest.setPassword(contrasenia);

        mAPIService = ApiUtils.getAPIService();

        mAPIService.registrar(userRequest).enqueue(new Callback<CreateUserResponse>() {
            @Override
            public void onResponse(Call<CreateUserResponse> call, Response<CreateUserResponse> response) {
                // Valida estado del response
                if (response.isSuccessful()) {
                    CreateUserResponse createUserResponse = response.body();
                    listener.onSuccess();
                } else {
                    listener.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<CreateUserResponse> call, Throwable t) {
                listener.onError("Unable to submit to apu");
            }
        });
    }
}

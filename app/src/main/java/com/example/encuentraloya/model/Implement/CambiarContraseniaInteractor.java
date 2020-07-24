package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.IUsuarioService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.Response.genericListError;
import com.example.encuentraloya.entidad.Usuario;
import com.example.encuentraloya.model.Interfaces.OnCambiarContraseniaFinishedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CambiarContraseniaInteractor {
private IUsuarioService usuarioService;

public  void  setContrasenia(String contrasenia, final OnCambiarContraseniaFinishedListener listener){
    usuarioService = ApiUtils.getAPIUsuarioService();

    Usuario entity = new Usuario();
    entity.setContrasenia(contrasenia);
    entity.setIdUsuario(SharedPreferencesManager.getIntValue(Constantes.PREF_IDUSUARIOAUTENTICADO));

    usuarioService.modificarContrasenia(entity).enqueue(new Callback<genericListError>() {
        @Override
        public void onResponse(Call<genericListError> call, Response<genericListError> response) {
            if(response.isSuccessful() && response.body().getProcesadoOk()==1) {
                listener.onSucces();
            }else{
                listener.onShowMesaje("Al parecer hubo un error, Intentelo nuevamente");
            }
        }

        @Override
        public void onFailure(Call<genericListError> call, Throwable t) {
            listener.onShowMesaje("Al parecer hubo un error, Intentelo nuevamente");
        }
    });

}



}

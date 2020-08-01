package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.model.Interfaces.OnSplashFinishedListener;

public class SplashInteractor {

    public void validarExistenLogin(final OnSplashFinishedListener listener){
        int idUsuarioAutentificado = SharedPreferencesManager.getIntValue(Constantes.PREF_IDUSUARIOAUTENTICADO);

        if (idUsuarioAutentificado>0){
            listener.onLoginOn(true);
        }else{
            listener.onLoginOn(false);
        }

    }

}

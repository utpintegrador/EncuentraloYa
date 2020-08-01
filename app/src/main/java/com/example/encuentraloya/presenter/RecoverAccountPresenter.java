package com.example.encuentraloya.presenter;

import com.example.encuentraloya.model.Implement.RecoverAccountInteractor;
import com.example.encuentraloya.model.Interfaces.OnRecoverAccountFinishedListener;
import com.example.encuentraloya.view.Interfaces.IRecuperarAccountView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecoverAccountPresenter implements OnRecoverAccountFinishedListener {
    private IRecuperarAccountView view;
    private RecoverAccountInteractor interactor;


    public RecoverAccountPresenter(IRecuperarAccountView view, RecoverAccountInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void getSolicitarPassword(String correoElectronico){
        if (view != null) {
            view.showProgress();
        }

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher =pattern.matcher(correoElectronico);

        if(correoElectronico.isEmpty()){
            onCorreoElectronico("Falta ingresar el correo");
        }else if(!matcher.find()){
            onCorreoElectronico("El correo Ingresaro no es válido");
        }else{
            interactor.getSolicitarPassword(correoElectronico,this);
        }

    }

    @Override
    public void onCorreoElectronico(String message) {
        if (view != null) {
            view.setErrorCorreoElectronico(message);
            view.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (view != null) {
            view.showMessage("Su contraseña ha sido enviado a su correo.");
            view.hideProgress();
        }
    }

    @Override
    public void onMessage(String message) {
        if (view != null) {
            view.showMessage(message);
            view.hideProgress();
        }
    }
}

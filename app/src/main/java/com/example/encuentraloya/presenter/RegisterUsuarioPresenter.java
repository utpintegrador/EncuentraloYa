package com.example.encuentraloya.presenter;

import com.example.encuentraloya.model.Interfaces.OnRegisterUsuarioFinishedListener;
import com.example.encuentraloya.model.Implement.RegisterUsuarioInteractor;
import com.example.encuentraloya.view.Interfaces.IRegisterUsuarioView;

public class RegisterUsuarioPresenter implements OnRegisterUsuarioFinishedListener {
    private IRegisterUsuarioView registerView;
    private RegisterUsuarioInteractor registerInteractor;

    public RegisterUsuarioPresenter(IRegisterUsuarioView registerView, RegisterUsuarioInteractor registerInteractor) {
        this.registerView = registerView;
        this.registerInteractor = registerInteractor;
    }

    public void registerUser(String usuario, String correoElectronioco, String contrasenia, String nombre, String apellido) {
        if (registerView != null) {
            registerView.showProgress();
        }
        registerInteractor.registrar(correoElectronioco, nombre, apellido, contrasenia, usuario, this);
    }

    @Override
    public void onCorreoElectronicoError() {

    }

    @Override
    public void onUsernameError() {

    }

    @Override
    public void onNombreeError() {

    }

    @Override
    public void onApellidoError() {

    }

    @Override
    public void onContraseniasError() {

    }

    @Override
    public void onSuccess() {
        if (registerView != null) {
            //registerView.navigateToHome();
            registerView.hideProgress();
        }
    }

    @Override
    public void onError(String ErrorMessage) {
        registerView.hideProgress();
    }
}

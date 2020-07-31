package com.example.encuentraloya.presenter;

import com.example.encuentraloya.comun.Generico;
import com.example.encuentraloya.model.Implement.LoginInteractor;
import com.example.encuentraloya.model.Interfaces.OnLoginFinishedListener;
import com.example.encuentraloya.view.Interfaces.ILoginView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginPresenter implements OnLoginFinishedListener {
    private ILoginView loginView;
    private LoginInteractor loginInteractor;


    public LoginPresenter(ILoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void validateCredentials(String username, String password, boolean recordarCuenta) {
        if (loginView != null) {
            loginView.showProgress();
        }

        if (username.isEmpty()) {
            onUsernameError("El Correo esta vacío");
        }else if(!Generico.ValidarMail(username)){
            onUsernameError("El Correo no es válido");
        }else if (password.isEmpty()){
             onPasswordError("La Contraseña esta vacía");
        }else if (password.length()<8){
            onPasswordError("La Contraseña carece se seguridad, contacte con el admistrador.");
        }else{
            loginInteractor.login(username, password,recordarCuenta, this);
        }

    }

    public void verificarSiCuentaRecordar(){
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.verificaCuentaSiRecordar(this);
    }


    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError(String mensaje) {
        if (loginView != null) {
            loginView.setUsernameError(mensaje);
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError(String mensaje) {
        if (loginView != null) {
            loginView.setPasswordError(mensaje);
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
            loginView.hideProgress();
        }
    }

    @Override
    public void onError(String ErrorMessage) {
        if (loginView != null) {
            loginView.setError(ErrorMessage);
            loginView.hideProgress();
        }
    }

    @Override
    public void offRecordarCuenta() {
        if (loginView != null) {
            loginView.hideProgress();
        }
    }
}

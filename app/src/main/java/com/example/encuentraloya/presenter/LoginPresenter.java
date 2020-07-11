package com.example.encuentraloya.presenter;

import com.example.encuentraloya.model.Implement.LoginInteractor;
import com.example.encuentraloya.model.Interfaces.OnLoginFinishedListener;
import com.example.encuentraloya.view.Interfaces.ILoginView;


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

        loginInteractor.login(username, password, recordarCuenta, this);
    }

    public void verificarSiCuentaRecordar() {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.verificaCuentaSiRecordar(this);
    }

    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
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

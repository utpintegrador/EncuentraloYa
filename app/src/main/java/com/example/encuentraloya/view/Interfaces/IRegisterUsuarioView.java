package com.example.encuentraloya.view.Interfaces;

public interface IRegisterUsuarioView {
    void showProgress();
    void hideProgress();

    void setCorreoElectronicoError();
    void setUsernameError();
    void setNombreeError();
    void setApellidoError();
    void setContraseniasError();

    void navigateToHome();

    void onClearText();
    void setError(String ErrorMessage);



}

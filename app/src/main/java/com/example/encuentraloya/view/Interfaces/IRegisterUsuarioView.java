package com.example.encuentraloya.view.Interfaces;

public interface IRegisterUsuarioView {
    void showProgress();
    void hideProgress();

    void setCorreoElectronicoError(String message);
    void setNombreeError(String message);
    void setApellidoError(String message);
    void setContraseniaError(String message);
    void setConfirmarContraseniaError(String message);

    void navigateToHome();

    void onClearText();
    void setError(String ErrorMessage);



}


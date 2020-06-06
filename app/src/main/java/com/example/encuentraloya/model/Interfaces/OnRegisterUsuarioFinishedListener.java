package com.example.encuentraloya.model.Interfaces;

public interface OnRegisterUsuarioFinishedListener {

    void onCorreoElectronicoError();
    void onUsernameError();
    void onNombreeError();
    void onApellidoError();
    void onContraseniasError();

    void onSuccess();
    void onError(String ErrorMessage);

}

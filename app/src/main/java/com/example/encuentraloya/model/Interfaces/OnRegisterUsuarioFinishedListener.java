package com.example.encuentraloya.model.Interfaces;

public interface OnRegisterUsuarioFinishedListener {

    void onCorreoElectronicoError(String message);
    void onNombreeError(String message);
    void onApellidoError(String message);
    void onContraseniasError(String message);
    void onConfirmarContraseniasError(String message);

    void onSuccess();
    void onError(String ErrorMessage);

}

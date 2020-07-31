package com.example.encuentraloya.model.Interfaces;

public interface OnLoginFinishedListener {
    void onUsernameError(String mensaje);

    void onPasswordError(String mensaje);

    void onSuccess();

    void onError(String ErrorMessage);

    void offRecordarCuenta();

}

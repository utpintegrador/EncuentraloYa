package com.example.encuentraloya.model.Interfaces;

public interface OnLoginFinishedListener {
    void onUsernameError();

    void onPasswordError();

    void onSuccess();

    void onError(String ErrorMessage);

    void offRecordarCuenta();

}

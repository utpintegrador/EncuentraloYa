package com.example.encuentraloya.model.Interfaces;

public interface OnRecoverAccountFinishedListener {
    void onCorreoElectronico(String message);
    void onSuccess();
    void onMessage(String message);
}

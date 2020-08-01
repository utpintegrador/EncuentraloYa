package com.example.encuentraloya.view.Interfaces;

public interface IMyNegocioView {
    void showMyNegocio(String nombreNegocio ,double latitud, double longitud);
    void showProgress();
    void hideProgress();
    void showMessage(String message);
}

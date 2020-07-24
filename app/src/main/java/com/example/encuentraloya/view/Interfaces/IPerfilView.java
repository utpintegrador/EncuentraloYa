package com.example.encuentraloya.view.Interfaces;

public interface IPerfilView {
    void showProgress();
    void hideProgress();
    void showPerfilDatos(String nombreCompleto, String correoElectronico, String urlImagenPerfil);
    void showNavegationLogin();
    void showImagenPerfil(String urlImagenPerfil);
    void showMensaje(String mensaje);
}

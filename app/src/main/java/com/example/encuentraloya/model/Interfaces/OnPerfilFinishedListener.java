package com.example.encuentraloya.model.Interfaces;

public interface OnPerfilFinishedListener {
    void onSuccesGetPerfilData(String nombreCompleto, String correoElectronico, String urlImagenPerfil);
    void onCerrarSesion();
    void onSuccesSaveImage(String urlImagen);
    void onMensaje(String mensaje);

}

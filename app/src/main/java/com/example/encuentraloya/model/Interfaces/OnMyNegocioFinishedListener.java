package com.example.encuentraloya.model.Interfaces;

public interface OnMyNegocioFinishedListener {
    void onSuccesSaveUbicacion();
    void onSuccesGetDetalleTiendas(String tituloNegocio, String descripcion ,double latitud, double longitud);
    void onMensaje(String message);
}

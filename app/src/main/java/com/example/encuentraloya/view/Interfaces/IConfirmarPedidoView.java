package com.example.encuentraloya.view.Interfaces;

public interface IConfirmarPedidoView {
    void showProgress();
    void hideProgress();
    void showMensaje(String mensaje);
    void showSuccesPedido();

    void setNumeroCelularError(String mensaje);
}

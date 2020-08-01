package com.example.encuentraloya.view.Interfaces;

import com.example.encuentraloya.entidad.ProductDto;

import java.util.List;

public interface ICarritoView {
    void showMensaje(String mensaje);
    void showProgress();
    void hideProgress();
    void showRecyclerView();
    void hideRecyclerView();
    void showListaCarrito( List<ProductDto> lista);
    void showTotal(String total);
    void setOperation(int operation, int idPedido, double cantidad);
    void nagevationContinuar();


}

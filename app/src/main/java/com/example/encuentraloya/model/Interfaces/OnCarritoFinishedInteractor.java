package com.example.encuentraloya.model.Interfaces;

import com.example.encuentraloya.entidad.ProductDto;

import java.util.List;

public interface OnCarritoFinishedInteractor {
    void onMensaje(String mensaje);
    void onListaCarrito( List<ProductDto> lista);
    void onEliminadoProducto(String mensaje);
    void onActualizadoProducto(String mensaje);
}

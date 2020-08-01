package com.example.encuentraloya.model.Interfaces;

import com.example.encuentraloya.entidad.ProductBusinessDto;

import java.util.List;

public interface OnSearchProductFinishedListener {
    void onSuccess(List<ProductBusinessDto> list_productBusinessDto);

    void onSuccessAddProducto(String mensaje);
    void onMensaje(String mensaje);
}

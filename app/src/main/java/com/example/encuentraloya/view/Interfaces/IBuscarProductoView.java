package com.example.encuentraloya.view.Interfaces;

import com.example.encuentraloya.entidad.ProductBusinessDto;

import java.util.List;

public interface IBuscarProductoView {

    void showProgress();

    void hideProgress();

    void showProducts(List<ProductBusinessDto> list_productBusinessDto);

    void showEmpty();

    void hideEmpty();
}

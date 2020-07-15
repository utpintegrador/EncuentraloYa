package com.example.encuentraloya.view.Interfaces;

import com.example.encuentraloya.entidad.CategoriaDto;

import java.util.List;

public interface IHomeView {

    void showProgress();
    void hideProgress();
    void showRecyclerView();

    void showCategoria(List<CategoriaDto> listaCategoria);
    void showMessage(String message);

}

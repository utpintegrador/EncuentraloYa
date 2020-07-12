package com.example.encuentraloya.model.Interfaces;

import com.example.encuentraloya.entidad.CategoriaDto;

import java.util.List;

public interface IOnHomeFinishedListener {
    void onCategoriaSucces(List<CategoriaDto> listaCategoria);
    void onMessage(String message);
}

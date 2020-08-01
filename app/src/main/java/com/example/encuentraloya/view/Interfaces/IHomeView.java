package com.example.encuentraloya.view.Interfaces;

import com.example.encuentraloya.entidad.CategoriaDto;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public interface IHomeView {

    void showProgress();
    void hideProgress();
    void showRecyclerView();

    void showCategoria(List<CategoriaDto> listaCategoria);
    void showMessage(String message);
    void showGastoUltimosMeses(ArrayList<BarEntry> values, ArrayList<String> labels);

    void showCantidadDisponibleTiendas(String mensaje);
}

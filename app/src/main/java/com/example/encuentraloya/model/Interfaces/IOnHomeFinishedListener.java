package com.example.encuentraloya.model.Interfaces;

import com.example.encuentraloya.entidad.CategoriaDto;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public interface IOnHomeFinishedListener {
    void onCategoriaSucces(List<CategoriaDto> listaCategoria);
    void onMessage(String message);
    void onGastoUltimosMeses(ArrayList<BarEntry> values, ArrayList<String> labels);
    void onCantidadDisponibleTiendas(int cantidadTiendasCercanas);
}

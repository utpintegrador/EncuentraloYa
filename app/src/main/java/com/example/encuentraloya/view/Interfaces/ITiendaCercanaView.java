package com.example.encuentraloya.view.Interfaces;

import com.example.encuentraloya.entidad.NegocioDto;
import com.example.encuentraloya.entidad.PedidoDto;

import java.util.List;

public interface ITiendaCercanaView {
    void showProgress();
    void hideProgress();
    void showTiendasCercanas(List<NegocioDto> lista);
    void showMessage(String message);
}

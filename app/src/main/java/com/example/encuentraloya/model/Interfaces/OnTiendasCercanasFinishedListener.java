package com.example.encuentraloya.model.Interfaces;

import com.example.encuentraloya.entidad.NegocioDto;

import java.util.List;

public interface OnTiendasCercanasFinishedListener {
    void onListaTiendasCercanasSuccess(List<NegocioDto> listaPedido);
    void onMessage(String message);
}

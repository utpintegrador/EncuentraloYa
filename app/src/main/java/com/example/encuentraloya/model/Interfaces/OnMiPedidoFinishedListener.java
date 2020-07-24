package com.example.encuentraloya.model.Interfaces;

import com.example.encuentraloya.entidad.PedidoDto;

import java.util.List;

public interface OnMiPedidoFinishedListener {

    void onPedidosSuccess(List<PedidoDto> listaPedido);
    void onMessage(String message);

}

package com.example.encuentraloya.model.Interfaces;

import com.example.encuentraloya.entidad.PedidoDto;

public interface OnDetallePedidoFinishedListener {
    void onDetallePedidosSuccess(PedidoDto pedido);
    void onMessage(String message);

}

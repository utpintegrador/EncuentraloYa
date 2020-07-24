package com.example.encuentraloya.view.Interfaces;

import com.example.encuentraloya.entidad.PedidoDto;

public interface IDetallePedidoView {
    void showProgress();
    void hideProgress();
    void showPedidos(PedidoDto pedido);
    void showMessage(String message);
}

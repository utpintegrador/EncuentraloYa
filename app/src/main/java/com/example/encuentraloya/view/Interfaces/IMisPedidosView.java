package com.example.encuentraloya.view.Interfaces;

import com.example.encuentraloya.entidad.PedidoDto;

import java.util.List;

public interface IMisPedidosView {
    void showProgress();
    void hideProgress();
    void showPedidos(List<PedidoDto> listaPedido);
    void showMessage(String message);

}

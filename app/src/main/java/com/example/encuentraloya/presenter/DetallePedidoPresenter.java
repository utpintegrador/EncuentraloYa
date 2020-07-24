package com.example.encuentraloya.presenter;

import com.example.encuentraloya.entidad.PedidoDto;
import com.example.encuentraloya.model.Implement.DetallePedidoInteractor;
import com.example.encuentraloya.model.Interfaces.OnDetallePedidoFinishedListener;
import com.example.encuentraloya.view.Interfaces.IDetallePedidoView;

public class DetallePedidoPresenter implements OnDetallePedidoFinishedListener {
    private IDetallePedidoView view;
    private DetallePedidoInteractor interactor;

    public DetallePedidoPresenter(IDetallePedidoView view, DetallePedidoInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }


    public void getAllPedidos(int idPedido){
        if (view != null) {
            view.showProgress();
        }
        interactor.getDetallePedido(idPedido,this);
    }


    @Override
    public void onDetallePedidosSuccess(PedidoDto pedido) {
        if (view != null) {
            view.hideProgress();
            view.showPedidos(pedido);
        }
    }

    @Override
    public void onMessage(String message) {
        if (view != null) {
            view.hideProgress();
            view.showMessage(message);
        }
    }
}

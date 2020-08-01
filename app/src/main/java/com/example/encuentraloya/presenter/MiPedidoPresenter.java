package com.example.encuentraloya.presenter;

import com.example.encuentraloya.entidad.PedidoDto;
import com.example.encuentraloya.model.Implement.MiPedidoInteractor;
import com.example.encuentraloya.model.Interfaces.OnMiPedidoFinishedListener;
import com.example.encuentraloya.view.Interfaces.IMisPedidosView;

import java.util.List;

public class MiPedidoPresenter implements OnMiPedidoFinishedListener {
    private IMisPedidosView view;
    private MiPedidoInteractor interactor;

    public MiPedidoPresenter(IMisPedidosView view, MiPedidoInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void getAllPedidos(){
        if (view != null) {
            view.showProgress();
        }
        interactor.getAllPedidos(this);
    }


    @Override
    public void onPedidosSuccess(List<PedidoDto> listaPedido) {
        if (view != null) {
            view.hideProgress();
            view.showPedidos(listaPedido);
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

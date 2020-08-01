package com.example.encuentraloya.presenter;

import com.example.encuentraloya.model.Implement.ConfirmarPedidoInteractor;
import com.example.encuentraloya.model.Interfaces.OnConfirmarPedidoFinishedListener;
import com.example.encuentraloya.view.Interfaces.IConfirmarPedidoView;

public class ConfirmarPedidoPresenter implements OnConfirmarPedidoFinishedListener {
    IConfirmarPedidoView view;
    ConfirmarPedidoInteractor interactor;

    public ConfirmarPedidoPresenter(IConfirmarPedidoView view, ConfirmarPedidoInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public  void savePedido(String numeroCelular, String referencia, String observacion){
        if (view != null) {

            if(numeroCelular.isEmpty()){
                view.setNumeroCelularError("El Número celular esta vacío");
            }else if(numeroCelular.length()  !=9){
                view.setNumeroCelularError("El Número celular inválido");
            }else {
                String letra =numeroCelular.substring(0,1);
                if("9".equals(letra)){
                    view.showProgress();
                    interactor.savePedido(numeroCelular,referencia,observacion,this);
                }else{
                    view.setNumeroCelularError("El Número celular inválido");
                }


            }

        }
    }


    @Override
    public void onMessage(String message) {
        if (view != null) {
            view.hideProgress();
            view.showMensaje(message);
        }
    }

    @Override
    public void onSuccessPedido() {
        if (view != null) {
            view.hideProgress();
            view.showSuccesPedido();
        }
    }
}

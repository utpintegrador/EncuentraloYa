package com.example.encuentraloya.presenter;

import com.example.encuentraloya.model.Implement.MyNegocioInteractor;
import com.example.encuentraloya.model.Interfaces.OnMyNegocioFinishedListener;
import com.example.encuentraloya.view.Interfaces.IMyNegocioView;

public class MyNegocioPresenter implements OnMyNegocioFinishedListener {
    private IMyNegocioView view;
    private MyNegocioInteractor interactor;


    public MyNegocioPresenter(IMyNegocioView view, MyNegocioInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void getUbicacionNegocioPorId(){
        if (view != null) {
            view.showProgress();
        }
        interactor.getUbicacionNegocioPorId(this);
    }

    public void setDetalleTienda(double latitud, double longitud, String negocioTitulo){
        if (view != null) {
            view.showProgress();
        }
        interactor.setDetalleTienda(latitud,longitud,negocioTitulo,this);
    }


    @Override
    public void onSuccesSaveUbicacion() {
        if (view != null) {
            view.hideProgress();
            view.showMessage("Los datos han sido guardados!");
        }
    }

    @Override
    public void onSuccesGetDetalleTiendas(String tituloNegocio, String descripcion ,double latitud, double longitud) {
        if (view != null) {
            view.showMyNegocio(tituloNegocio,latitud,longitud);
            view.hideProgress();
        }
    }

    @Override
    public void onMensaje(String message) {
        if (view != null) {
            view.showMessage(message);
            view.hideProgress();
        }
    }
}

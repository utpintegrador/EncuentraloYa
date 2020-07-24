package com.example.encuentraloya.presenter;

import com.example.encuentraloya.entidad.NegocioDto;
import com.example.encuentraloya.model.Implement.TiendasCercanasInteractor;
import com.example.encuentraloya.model.Interfaces.OnTiendasCercanasFinishedListener;
import com.example.encuentraloya.view.Interfaces.ITiendaCercanaView;

import java.util.List;

public class TiendaCercanaPresenter implements OnTiendasCercanasFinishedListener {

    private ITiendaCercanaView view;
    private TiendasCercanasInteractor interactor;


    public TiendaCercanaPresenter(ITiendaCercanaView view, TiendasCercanasInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void getAllTiendasCercanas(double longitud, double latitud){
        if (view != null) {
            view.showProgress();
        }
        interactor.getAllTiendasCercanas(longitud,latitud, this);
    }

    @Override
    public void onListaTiendasCercanasSuccess(List<NegocioDto> listaPedido) {
        if (view != null) {
            view.hideProgress();
            view.showTiendasCercanas(listaPedido);
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

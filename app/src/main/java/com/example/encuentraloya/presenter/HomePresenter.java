package com.example.encuentraloya.presenter;

import com.example.encuentraloya.entidad.CategoriaDto;
import com.example.encuentraloya.model.Implement.HomeInteractor;
import com.example.encuentraloya.model.Interfaces.IOnHomeFinishedListener;
import com.example.encuentraloya.view.Interfaces.IHomeView;

import java.util.List;

public class HomePresenter implements IOnHomeFinishedListener {
    private IHomeView view;
    private HomeInteractor interactor;

    public HomePresenter(IHomeView view, HomeInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void getAllCategoria(){
        if (view != null) {
            view.showProgress();
        }
        interactor.getAllCategoria(this);
    }

    @Override
    public void onCategoriaSucces(List<CategoriaDto> listaCategoria) {
        if (view != null) {
            view.hideProgress();
            view.showCategoria(listaCategoria);
            view.showRecyclerView();
        }

    }

    @Override
    public void onMessage(String message) {
        if (view != null) {
            view.showMessage(message);
            view.hideProgress();
        }
    }
}

package com.example.encuentraloya.presenter;

import com.example.encuentraloya.entidad.CategoriaDto;
import com.example.encuentraloya.model.Implement.HomeInteractor;
import com.example.encuentraloya.model.Interfaces.IOnHomeFinishedListener;
import com.example.encuentraloya.view.Interfaces.IHomeView;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
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
        interactor.getAllGastoUltimos_5Meses(this);
    }

    public void getAllCantidadTiendasCercanas(){
        if (view != null) {
            //view.showProgress();
        }
        interactor.getNeogcioCercano(this);
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

    @Override
    public void onGastoUltimosMeses(ArrayList<BarEntry> values, ArrayList<String> labels) {
        if (view != null) {
            view.showGastoUltimosMeses(values,labels);
        }
    }

    @Override
    public void onCantidadDisponibleTiendas(int cantidadTiendasCercanas) {
        String mensaje="";
        if(cantidadTiendasCercanas==1){
            mensaje="Hay 1 tienda disponible cerca de tu ubicación.";
        }else if(cantidadTiendasCercanas>1){
            mensaje="Hay " + cantidadTiendasCercanas + " tiendas disponibles cerca de tu ubicación.";
        }else{
            mensaje="NO hay tiendas disponible cerca de tu ubicación";
        }
        view.showCantidadDisponibleTiendas(mensaje);
    }
}

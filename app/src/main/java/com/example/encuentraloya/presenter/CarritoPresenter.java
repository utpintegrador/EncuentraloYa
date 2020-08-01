package com.example.encuentraloya.presenter;

import com.example.encuentraloya.entidad.ProductDto;
import com.example.encuentraloya.model.Implement.CarritoInteractor;
import com.example.encuentraloya.model.Interfaces.OnCarritoFinishedInteractor;
import com.example.encuentraloya.view.Interfaces.ICarritoView;

import java.util.List;

public class CarritoPresenter implements OnCarritoFinishedInteractor{
    ICarritoView view;
    CarritoInteractor interactor;

    public CarritoPresenter(ICarritoView view, CarritoInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }
    public  void  listarCarrito(){
        if (view != null) {
            view.showProgress();
            view.hideRecyclerView();
        }
        interactor.listarCarrito( this);
    }


    public void moveContinuar(){
        if(view != null){
            if(interactor.getExisteProductos()>0){
                view.nagevationContinuar();
            }else{
                view.showMensaje("No existen productos a confirmar!");
            }
        }
    }

    public void setActualizarProducto(int idPedido, double cantidad ){
        if (view != null) {

        }
        interactor.actualizarrProducto(idPedido,cantidad,this);
    }
    public void setEliminarProducto(int idPedido ){
        if (view != null) {

        }
        interactor.eliminarProducto(idPedido,this);
    }

    @Override
    public void onMensaje(String mensaje) {
        if (view != null) {
            view.hideProgress();
            view.showMensaje(mensaje);
        }

    }

    @Override
    public void onListaCarrito( List<ProductDto> lista) {
        if (view != null) {
            view.hideProgress();
            view.showListaCarrito(lista);
            view.showTotal(interactor.getTotal());
            view.showRecyclerView();
        }
    }

    @Override
    public void onEliminadoProducto(String mensaje) {
        if (view != null) {
            view.showTotal(interactor.getTotal());
        }
    }

    @Override
    public void onActualizadoProducto(String mensaje) {
        if (view != null) {
            view.showTotal(interactor.getTotal());
        }
    }
}

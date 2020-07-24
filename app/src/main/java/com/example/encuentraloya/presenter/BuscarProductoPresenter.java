package com.example.encuentraloya.presenter;

import com.example.encuentraloya.entidad.ProductBusinessDto;
import com.example.encuentraloya.model.Implement.BuscarProductoInteractor;
import com.example.encuentraloya.model.Interfaces.OnSearchProductFinishedListener;
import com.example.encuentraloya.view.Interfaces.IBuscarProductoView;

import java.util.List;

public class BuscarProductoPresenter implements OnSearchProductFinishedListener {
    private IBuscarProductoView buscarProductoView;
    private BuscarProductoInteractor buscarProductoInteractor;


    public BuscarProductoPresenter(IBuscarProductoView buscarProductoView, BuscarProductoInteractor buscarProductoInteractor) {
        this.buscarProductoView = buscarProductoView;
        this.buscarProductoInteractor = buscarProductoInteractor;
    }

    public void searchProductsByIdBusiness(Integer idBusiness, String search, Integer idState, Integer idMoney,
                                           Integer idCategory, Integer numberPage, Integer totalRecords, String orderColumn, String orderDirection) {

        if (buscarProductoView != null) {
            buscarProductoView.showProgress();
            buscarProductoView.hideRecyclerView();
        }
        buscarProductoInteractor.searchProducts(idBusiness, search, idState, idMoney, idCategory, numberPage, totalRecords, orderColumn, orderDirection, this);
    }

    public  void agregarProducto(int idProducto, double cantidad, String descripcion, double precio, String urlImagen ){
        if (buscarProductoView != null) {

        }

        buscarProductoInteractor.agregarProducto( idProducto,  cantidad,  descripcion,  precio,  urlImagen, this );
    }


    @Override
    public void onSuccess(List<ProductBusinessDto> list_productBusinessDto) {
        buscarProductoView.hideProgress();
        buscarProductoView.showRecyclerView();
        buscarProductoView.showProducts(list_productBusinessDto);
    }

    @Override
    public void onSuccessAddProducto(String mensaje) {
        if (buscarProductoView != null) {

            buscarProductoView.showSuccesAddProducto(mensaje);
        }
    }

    @Override
    public void onMensaje(String mensaje) {
        if (buscarProductoView != null) {
            buscarProductoView.hideProgress();
            buscarProductoView.showMensaje(mensaje);
        }
    }

}

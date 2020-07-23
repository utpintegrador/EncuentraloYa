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
    }
        buscarProductoInteractor.searchProducts(idBusiness, search, idState, idMoney, idCategory, numberPage, totalRecords, orderColumn, orderDirection, this);
}

    @Override
    public void onSuccess(List<ProductBusinessDto> list_productBusinessDto) {
        buscarProductoView.hideProgress();
        buscarProductoView.showProducts(list_productBusinessDto);
    }
}

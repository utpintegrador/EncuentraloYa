package com.example.encuentraloya.model.Implement;

import android.app.FragmentManager;
import android.widget.Toast;

import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.IProductService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.Request.ObtenerProdByNegocioRequest;
import com.example.encuentraloya.entidad.Response.ObtenerProdByNegocioResponse;
import com.example.encuentraloya.entidad.UbicacionNegocioDto;
import com.example.encuentraloya.model.Interfaces.OnSearchProductFinishedListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuscarProductoInteractor {

    private IProductService iProductService;
    private OnSearchProductFinishedListener listener;

    public void searchProducts(final Integer idBusiness, final String search, final Integer idState, final Integer idMoney,
                               final Integer idCategory, final Integer numberPage, final Integer totalRecords, final String orderColumn,
                               final String orderDirection, final OnSearchProductFinishedListener listener) {
        ObtenerProdByNegocioRequest obtenerProdByNegocioRequest = new ObtenerProdByNegocioRequest();

        obtenerProdByNegocioRequest.setIdBusiness(idBusiness);
        obtenerProdByNegocioRequest.setSearch(search);
        obtenerProdByNegocioRequest.setIdState(idState);
        obtenerProdByNegocioRequest.setIdMoney(idMoney);
        obtenerProdByNegocioRequest.setIdCategory(idCategory);
        obtenerProdByNegocioRequest.setNumberPage(numberPage);
        obtenerProdByNegocioRequest.setTotalRecords(totalRecords);
        obtenerProdByNegocioRequest.setOrderColumn(orderColumn);
        obtenerProdByNegocioRequest.setOrderDirection(orderDirection);

        //getAPIServiceProduct
        iProductService = ApiUtils.getAPIServiceProduct();

        iProductService.obtenerPorIdNegocio(obtenerProdByNegocioRequest).enqueue(new Callback<ObtenerProdByNegocioResponse>() {
            @Override
            public void onResponse(Call<ObtenerProdByNegocioResponse> call, Response<ObtenerProdByNegocioResponse> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess();
                }
            }

            @Override
            public void onFailure(Call<ObtenerProdByNegocioResponse> call, Throwable t) {

            }
        });
    }

}

package com.example.encuentraloya.model.Implement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.IProductService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.PedidoSQLite;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.ProductBusinessDto;
import com.example.encuentraloya.entidad.Request.ObtenerProdByNegocioRequest;
import com.example.encuentraloya.entidad.Response.ObtenerProdByNegocioResponse;
import com.example.encuentraloya.model.Interfaces.OnSearchProductFinishedListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuscarProductoInteractor {

    private IProductService iProductService;
   Context context;

    public BuscarProductoInteractor(Context context) {
        this.context = context;
    }

    public void searchProducts(final Integer idBusiness, final String search, final Integer idState, final Integer idMoney,
                               final Integer idCategory, final Integer numberPage, final Integer totalRecords, final String orderColumn,
                               final String orderDirection, final OnSearchProductFinishedListener listener) {

        int idNegocio = SharedPreferencesManager.getIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO);

        ObtenerProdByNegocioRequest obtenerProdByNegocioRequest = new ObtenerProdByNegocioRequest();
        obtenerProdByNegocioRequest.setIdBusiness(idNegocio);
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
                    List<ProductBusinessDto> list_productBusinessDto =  response.body().getList_ProductBusiness();
                    listener.onSuccess(list_productBusinessDto);
                }
            }

            @Override
            public void onFailure(Call<ObtenerProdByNegocioResponse> call, Throwable t) {
                listener.onMensaje("Al parecer hubo un error");

            }
        });
    }



    public void agregarProducto(int idProducto, double cantidad, String descripcion, double precio, String urlImagen,
                                final OnSearchProductFinishedListener listener ){
        PedidoSQLite db = new PedidoSQLite(context);

       if(db.agregarProducto(idProducto,cantidad,descripcion,precio,urlImagen)){
            listener.onSuccessAddProducto("El producto ha sido agregado");
        }else{
            listener.onMensaje("Al parecer hubo un error");
        }

    }

}

package com.example.encuentraloya.model.Implement;

import android.content.Context;

import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.IPedidoService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.PedidoSQLite;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.PedidoDto;
import com.example.encuentraloya.entidad.Response.genericListError;
import com.example.encuentraloya.model.Interfaces.OnConfirmarPedidoFinishedListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmarPedidoInteractor {

    IPedidoService service;
    Context context;

    public ConfirmarPedidoInteractor(Context context) {
        this.context = context;
    }

    public  void savePedido(final String numeroCelular, String referencia, String observacion ,final OnConfirmarPedidoFinishedListener listener){
        final PedidoSQLite dataLite = new PedidoSQLite(context);

        PedidoDto entity = new PedidoDto();
        entity.setIdNegocioVendedor(SharedPreferencesManager.getIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO));
        //entity.setIdNegocioVendedor(29);
        entity.setIdNegocioComprador(SharedPreferencesManager.getIntValue(Constantes.PREF_IDNEGOCIO));
        entity.setDireccion(referencia);
        entity.setNumeroCelular(numeroCelular);
        entity.setObservaciones(observacion);
        entity.setIdMoneda(1);
        entity.setIdUsuarioRegistro(SharedPreferencesManager.getIntValue(Constantes.PREF_IDUSUARIOAUTENTICADO));
        entity.setListaPedidoDetalle(dataLite.ListarDetalleProductos());

        if(entity.getListaPedidoDetalle().size()==0){
            listener.onMessage("No hay productos disponibles a confirmar!");
        }else{

            service = ApiUtils.getAPIPedidoService();
            service.guardarPedido(entity).enqueue(new Callback<genericListError>() {
                @Override
                public void onResponse(Call<genericListError> call, Response<genericListError> response) {
                    if(response.isSuccessful() && response.body().getProcesadoOk()== Constantes.SUCCESS_RESULT){
                        dataLite.eliminarTodoProducto();
                        listener.onSuccessPedido();
                    }else{
                        listener.onMessage("Al parecer hubo un error, intenelo de nuevamente.");
                    }

                }

                @Override
                public void onFailure(Call<genericListError> call, Throwable t) {
                    listener.onMessage("Al parecer hubo un error, intenelo de nuevamente.");
                }
            });

        }
    }
}

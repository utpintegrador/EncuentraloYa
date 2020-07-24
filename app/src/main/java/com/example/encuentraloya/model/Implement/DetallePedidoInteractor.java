package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.IPedidoService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.entidad.PedidoDto;
import com.example.encuentraloya.entidad.Request.PedidoDetalleResponse;
import com.example.encuentraloya.model.Interfaces.OnDetallePedidoFinishedListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetallePedidoInteractor {
    private IPedidoService pedidoService;

    public void getDetallePedido(final int idPedido, final OnDetallePedidoFinishedListener listener){
        pedidoService = ApiUtils.getAPIPedidoService();
        pedidoService.ObtenerPorIdConDetalles(idPedido).enqueue(new Callback<PedidoDetalleResponse>() {
            @Override
            public void onResponse(Call<PedidoDetalleResponse> call, Response<PedidoDetalleResponse> response) {
                if(response.isSuccessful() && response.body().getProcesadoOk()== Constantes.SUCCESS_RESULT){
                    PedidoDto pedidoDto = response.body().getCuerpo();
                    listener.onDetallePedidosSuccess(pedidoDto);
                }
            }

            @Override
            public void onFailure(Call<PedidoDetalleResponse> call, Throwable t) {
                listener.onMessage("Al parecer hubo un error");
            }
        });

    }

}

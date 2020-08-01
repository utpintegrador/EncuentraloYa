package com.example.encuentraloya.model.Implement;

import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.IPedidoService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.PedidoDto;
import com.example.encuentraloya.entidad.Request.PedidoObtenerRequest;
import com.example.encuentraloya.entidad.Response.PedidoObtenerResponse;
import com.example.encuentraloya.model.Interfaces.OnMiPedidoFinishedListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MiPedidoInteractor {
    private IPedidoService pedidoService;

    public void getAllPedidos(final OnMiPedidoFinishedListener listener){

        int idNegocio = SharedPreferencesManager.getIntValue(Constantes.PREF_IDNEGOCIO) ;
        PedidoObtenerRequest enttity = new PedidoObtenerRequest();
        enttity.setIdNegocioComprador(idNegocio);

        pedidoService = ApiUtils.getAPIPedidoService();
        pedidoService.ObtenerPorIdNegocioComprador(enttity).enqueue(new Callback<PedidoObtenerResponse>() {
            @Override
            public void onResponse(Call<PedidoObtenerResponse> call, Response<PedidoObtenerResponse> response) {
                if(response.isSuccessful() && response.body().getProcesadoOk()== Constantes.SUCCESS_RESULT){
                    List<PedidoDto> lista = response.body().getCuerpo();
                    listener.onPedidosSuccess(lista);
                }
            }

            @Override
            public void onFailure(Call<PedidoObtenerResponse> call, Throwable t) {
                listener.onMessage("Al parecer hubo un error");
            }
        });
    }

}

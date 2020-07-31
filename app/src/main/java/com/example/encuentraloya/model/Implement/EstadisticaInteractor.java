package com.example.encuentraloya.model.Implement;


import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.IPedidoService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.DataGraficoDto;
import com.example.encuentraloya.entidad.Request.GraficoCompraRequest;
import com.example.encuentraloya.entidad.Response.GraficoCompraResponse;
import com.example.encuentraloya.model.Interfaces.OnEstadisticaFinishedListener;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EstadisticaInteractor {

    private IPedidoService pedidoService;

    public void getEstadistiacBarra(final OnEstadisticaFinishedListener listener){

        GraficoCompraRequest entity = new GraficoCompraRequest();
        entity.setCantidadMesesAtras(5);
        entity.setIdUsuario(SharedPreferencesManager.getIntValue(Constantes.PREF_IDUSUARIOAUTENTICADO));

        pedidoService = ApiUtils.getAPIPedidoService();
        pedidoService.ObtenerResumenCompras(entity).enqueue(new Callback<GraficoCompraResponse>() {
            @Override
            public void onResponse(Call<GraficoCompraResponse> call, Response<GraficoCompraResponse> response) {
                ArrayList<BarEntry> entries = new ArrayList<>();
                ArrayList<String> labels = new ArrayList<String>();

                if(response.isSuccessful() && response.body().getProcesadoOk()==Constantes.SUCCESS_RESULT){
                    if(response.body().getCuerpo().size()>0){

                        int position=0;
                        for (DataGraficoDto ety: response.body().getCuerpo()) {
                            float value = (float) Float.parseFloat(ety.getTotal().toString());
                            entries.add(new BarEntry( value ,position)); //valores grafico
                            labels.add(ety.getNombreMes() + " " + ety.getAnio()); // etiqueta
                            position++;
                        }
                        listener.onEstadisticaBarra(entries,labels);
                    }
                }else{
                    listener.onEstadisticaBarra(entries,labels);
                }
            }

            @Override
            public void onFailure(Call<GraficoCompraResponse> call, Throwable t) {

            }
        });

     /*   final int[] a = {5,2,10,4,7,8,13};
        final String[] b= {"January","February","March","April","May","June","Jully"};
        final ArrayList<BarEntry> entries = new ArrayList<>();
        final ArrayList<String> labels = new ArrayList<String>();

        for(int i=0 ; i<5;i++){
            entries.add(new BarEntry(a[i],i));
            labels.add(b[i]);
        }*/



    }


}

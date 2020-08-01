package com.example.encuentraloya.model.Implement;


import com.example.encuentraloya.Servicios.APIService;
import com.example.encuentraloya.Servicios.ApiUtils;
import com.example.encuentraloya.Servicios.INegocioService;
import com.example.encuentraloya.Servicios.IPedidoService;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.CategoriaDto;
import com.example.encuentraloya.entidad.DataGraficoDto;
import com.example.encuentraloya.entidad.NegocioDto;
import com.example.encuentraloya.entidad.Request.CategoriaRequest;
import com.example.encuentraloya.entidad.Request.GraficoCompraRequest;
import com.example.encuentraloya.entidad.Request.ObtenerTiendasCercanasRequest;
import com.example.encuentraloya.entidad.Response.CategoriaResponse;
import com.example.encuentraloya.entidad.Response.GraficoCompraResponse;
import com.example.encuentraloya.entidad.Response.ObtenerTiendasCercanasResponse;
import com.example.encuentraloya.model.Interfaces.IOnHomeFinishedListener;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteractor {
    private APIService mAPIService;
    private INegocioService negocioService;
    private IPedidoService pedidoService;


    public void getAllCategoria(final IOnHomeFinishedListener listener){

        final CategoriaRequest entity = new CategoriaRequest();
        entity.setBuscar("");
        entity.setCantidadRegistros(0);
        entity.setColumnaOrden("");
        entity.setDireccionOrden("");
        entity.setIdEstado(0);
        entity.setNumeroPagina(0);

        mAPIService = ApiUtils.getAPIService();

        mAPIService.obtenerCategorias(entity).enqueue(new Callback<CategoriaResponse>() {
            @Override
            public void onResponse(Call<CategoriaResponse> call, Response<CategoriaResponse> response) {

                if(response.isSuccessful()) {
                    if (response.body().getCantidadTotalRegistros()>0){
                        List<CategoriaDto> listaCategoria =  response.body().getCategoriaDto();
                        listener.onCategoriaSucces(listaCategoria);
                    }


                }
            }

            @Override
            public void onFailure(Call<CategoriaResponse> call, Throwable t) {
                listener.onMessage(t.getMessage().toString());
            }
        });


    }

    public void getAllGastoUltimos_5Meses(final IOnHomeFinishedListener listener){

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
                            entries.add(new BarEntry(value,position)); //valores grafico
                            labels.add(ety.getNombreMes() + " " + ety.getAnio()); // etiqueta
                            position++;
                        }
                        listener.onGastoUltimosMeses(entries,labels);
                    }
                }else{
                    listener.onGastoUltimosMeses(entries,labels);
                }
            }

            @Override
            public void onFailure(Call<GraficoCompraResponse> call, Throwable t) {

            }
        });


    }

    public void getNeogcioCercano(final IOnHomeFinishedListener listener){
        //ID NEGOCIO SELECCIONADO POR DEFECTO
        final int idNegocio = SharedPreferencesManager.getIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO);

        ObtenerTiendasCercanasRequest entity = new ObtenerTiendasCercanasRequest();
        entity.setIdUsuario(SharedPreferencesManager.getIntValue(Constantes.PREF_IDUSUARIOAUTENTICADO));
        entity.setBuscar("");
        entity.setUbicacionLatitudInicio(Constantes.LATITUD_VALUE);
        entity.setUbicacionLongitudInicio(Constantes.LONGITUD_VALUE);
        entity.setCantidadKilometros(1000);

        negocioService = ApiUtils.getAPIServiceNegocio();
        negocioService.ObtenerNegociosCercanos(entity).enqueue(new Callback<ObtenerTiendasCercanasResponse>() {
            @Override
            public void onResponse(Call<ObtenerTiendasCercanasResponse> call, Response<ObtenerTiendasCercanasResponse> response) {
                if(response.isSuccessful() && response.body().getProcesadoOk()== Constantes.SUCCESS_RESULT){
                    List<NegocioDto> lista = response.body().getCuerpo();

                    if(lista.size()>0){ //si existe datos
                        boolean isEncontrado = false;  //

                        if(idNegocio!=0){
                            for (NegocioDto entity: lista ){
                                if(entity.getIdNegocio()==idNegocio){
                                    SharedPreferencesManager.setIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO,entity.getIdNegocio());
                                    isEncontrado=true;
                                    break;
                                }
                            }
                        }
                        if(isEncontrado==false){
                            SharedPreferencesManager.setIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO,lista.get(0).getIdNegocio());
                        }
                    }else{ //no existen datos
                        SharedPreferencesManager.removeValue(Constantes.PREF_SELECTED_ID_NEGOCIO);
                        //System.out.println("IDNEGOCIO: "+SharedPreferencesManager.getIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO));
                    }

                    listener.onCantidadDisponibleTiendas(lista.size()); //RETORNO LA CANTIDAD DE TIENDAS CERCANAS


                }

            }

            @Override
            public void onFailure(Call<ObtenerTiendasCercanasResponse> call, Throwable t) {
                listener.onMessage("Al parecer hubo un error al verificar las tiendas disponibles a tu ubicación");
            }
        });


    }


}

package com.example.encuentraloya.entidad.Response;

import com.example.encuentraloya.entidad.DataGraficoDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GraficoCompraResponse {

    @SerializedName("ProcesadoOk")
    @Expose
    private Integer procesadoOk;
    @SerializedName("ListaError")
    @Expose
    private List<Object> listaError = null;
    @SerializedName("Cuerpo")
    @Expose
    private List<DataGraficoDto> cuerpo = null;

    public Integer getProcesadoOk() {
        return procesadoOk;
    }

    public void setProcesadoOk(Integer procesadoOk) {
        this.procesadoOk = procesadoOk;
    }

    public List<Object> getListaError() {
        return listaError;
    }

    public void setListaError(List<Object> listaError) {
        this.listaError = listaError;
    }

    public List<DataGraficoDto> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(List<DataGraficoDto> cuerpo) {
        this.cuerpo = cuerpo;
    }
}

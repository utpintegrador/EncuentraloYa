package com.example.encuentraloya.entidad.Response;

import java.util.List;

import com.example.encuentraloya.entidad.NegocioDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObtenerTiendasCercanasResponse {

    @SerializedName("ProcesadoOk")
    @Expose
    private Integer procesadoOk;
    @SerializedName("ListaError")
    @Expose
    private List<ListaError> listaError = null;
    @SerializedName("Cuerpo")
    @Expose
    private List<NegocioDto> cuerpo = null;
    @SerializedName("CantidadTotalRegistros")
    @Expose
    private Integer cantidadTotalRegistros;

    public Integer getProcesadoOk() {
        return procesadoOk;
    }

    public void setProcesadoOk(Integer procesadoOk) {
        this.procesadoOk = procesadoOk;
    }

    public List<ListaError> getListaError() {
        return listaError;
    }

    public void setListaError(List<ListaError> listaError) {
        this.listaError = listaError;
    }

    public List<NegocioDto> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(List<NegocioDto> cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Integer getCantidadTotalRegistros() {
        return cantidadTotalRegistros;
    }

    public void setCantidadTotalRegistros(Integer cantidadTotalRegistros) {
        this.cantidadTotalRegistros = cantidadTotalRegistros;
    }
}

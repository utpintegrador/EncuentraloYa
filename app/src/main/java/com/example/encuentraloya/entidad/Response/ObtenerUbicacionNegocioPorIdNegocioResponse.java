package com.example.encuentraloya.entidad.Response;

import java.util.List;

import com.example.encuentraloya.entidad.CategoriaDto;
import com.example.encuentraloya.entidad.UbicacionNegocioDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObtenerUbicacionNegocioPorIdNegocioResponse {
    @SerializedName("ProcesadoOk")
    @Expose
    private Integer procesadoOk;
    @SerializedName("ListaError")
    @Expose
    private List<Object> listaError = null;
    @SerializedName("Cuerpo")
    @Expose
    private List<UbicacionNegocioDto> cuerpo = null;
    @SerializedName("CantidadTotalRegistros")
    @Expose
    private Integer cantidadTotalRegistros;

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

    public List<UbicacionNegocioDto> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(List<UbicacionNegocioDto> cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Integer getCantidadTotalRegistros() {
        return cantidadTotalRegistros;
    }

    public void setCantidadTotalRegistros(Integer cantidadTotalRegistros) {
        this.cantidadTotalRegistros = cantidadTotalRegistros;
    }
}

package com.example.encuentraloya.entidad.Response;

import java.util.List;

import com.example.encuentraloya.entidad.CategoriaDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CategoriaResponse {

    @SerializedName("ProcesadoOk")
    @Expose
    private Integer procesadoOk;
    @SerializedName("ListaError")
    @Expose
    private List<ListaError> listaError = null;
    @SerializedName("Cuerpo")
    @Expose
    private List<CategoriaDto> categoriaDto = null;
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

    public List<CategoriaDto> getCategoriaDto() {
        return categoriaDto;
    }

    public void setCategoriaDto(List<CategoriaDto> categoriaDto) {
        this.categoriaDto = categoriaDto;
    }

    public Integer getCantidadTotalRegistros() {
        return cantidadTotalRegistros;
    }

    public void setCantidadTotalRegistros(Integer cantidadTotalRegistros) {
        this.cantidadTotalRegistros = cantidadTotalRegistros;
    }

}



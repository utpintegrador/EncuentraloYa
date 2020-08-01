package com.example.encuentraloya.entidad.Response;
import java.util.List;

import com.example.encuentraloya.entidad.UbicacionNegocioDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ObtenerUbicacionNegocioPorIdResponse {
    @SerializedName("ProcesadoOk")
    @Expose
    private Integer procesadoOk;
    @SerializedName("ListaError")
    @Expose
    private List<Object> listaError = null;
    @SerializedName("Cuerpo")
    @Expose
    private UbicacionNegocioDto cuerpo;

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

    public UbicacionNegocioDto getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(UbicacionNegocioDto cuerpo) {
        this.cuerpo = cuerpo;
    }
}

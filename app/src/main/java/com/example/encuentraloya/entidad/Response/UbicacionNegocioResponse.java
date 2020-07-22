package com.example.encuentraloya.entidad.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UbicacionNegocioResponse {

    @SerializedName("ProcesadoOk")
    @Expose
    private Integer procesadoOk;

    @SerializedName("ListaError")
    @Expose
    private List<ListaError> listaError = null;

    @SerializedName("IdGenerado")
    @Expose
    private Integer idGenerado;

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

    public Integer getIdGenerado() {
        return idGenerado;
    }

    public void setIdGenerado(Integer idGenerado) {
        this.idGenerado = idGenerado;
    }

}

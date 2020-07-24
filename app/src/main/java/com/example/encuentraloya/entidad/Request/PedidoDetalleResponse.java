package com.example.encuentraloya.entidad.Request;
import java.util.List;

import com.example.encuentraloya.entidad.PedidoDto;
import com.example.encuentraloya.entidad.Response.ListaError;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PedidoDetalleResponse {
    @SerializedName("ProcesadoOk")
    @Expose
    private Integer procesadoOk;
    @SerializedName("ListaError")
    @Expose
    private List<ListaError> listaError = null;
    @SerializedName("Cuerpo")
    @Expose
    private PedidoDto cuerpo;

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

    public PedidoDto getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(PedidoDto cuerpo) {
        this.cuerpo = cuerpo;
    }
}

package com.example.encuentraloya.entidad.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GraficoCompraRequest {
    @SerializedName("IdUsuario")
    @Expose
    private Integer idUsuario;
    @SerializedName("CantidadMesesAtras")
    @Expose
    private Integer cantidadMesesAtras;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getCantidadMesesAtras() {
        return cantidadMesesAtras;
    }

    public void setCantidadMesesAtras(Integer cantidadMesesAtras) {
        this.cantidadMesesAtras = cantidadMesesAtras;
    }
}

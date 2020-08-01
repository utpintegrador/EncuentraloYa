package com.example.encuentraloya.entidad.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cuerpo {
    @SerializedName("NumeroRespuesta")
    @Expose
    private Integer numeroRespuesta;
    @SerializedName("DescripcionRespuesta")
    @Expose
    private String descripcionRespuesta;
    @SerializedName("CorreoElectronico")
    @Expose
    private String correoElectronico;
    @SerializedName("Codigo")
    @Expose
    private String codigo;
    @SerializedName("IdUsuario")
    @Expose
    private Integer idUsuario;

    public Integer getNumeroRespuesta() {
        return numeroRespuesta;
    }

    public void setNumeroRespuesta(Integer numeroRespuesta) {
        this.numeroRespuesta = numeroRespuesta;
    }

    public String getDescripcionRespuesta() {
        return descripcionRespuesta;
    }

    public void setDescripcionRespuesta(String descripcionRespuesta) {
        this.descripcionRespuesta = descripcionRespuesta;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}

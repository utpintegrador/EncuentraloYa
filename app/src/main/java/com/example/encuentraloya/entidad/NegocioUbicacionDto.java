package com.example.encuentraloya.entidad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NegocioUbicacionDto {
    @SerializedName("IdNegocioUbicacion")
    @Expose
    private Integer idNegocioUbicacion;
    @SerializedName("Latitud")
    @Expose
    private Integer latitud;
    @SerializedName("Longitud")
    @Expose
    private Integer longitud;
    @SerializedName("Titulo")
    @Expose
    private String titulo;
    @SerializedName("Descripcion")
    @Expose
    private String descripcion;
    @SerializedName("Predeterminado")
    @Expose
    private Boolean predeterminado;

    public Integer getIdNegocioUbicacion() {
        return idNegocioUbicacion;
    }

    public void setIdNegocioUbicacion(Integer idNegocioUbicacion) {
        this.idNegocioUbicacion = idNegocioUbicacion;
    }

    public Integer getLatitud() {
        return latitud;
    }

    public void setLatitud(Integer latitud) {
        this.latitud = latitud;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getPredeterminado() {
        return predeterminado;
    }

    public void setPredeterminado(Boolean predeterminado) {
        this.predeterminado = predeterminado;
    }
}

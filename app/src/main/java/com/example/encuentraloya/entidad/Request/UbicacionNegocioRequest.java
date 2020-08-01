package com.example.encuentraloya.entidad.Request;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class UbicacionNegocioRequest {
    @SerializedName("IdNegocio")
    @Expose
    private Integer idNegocio;
    @SerializedName("Latitud")
    @Expose
    private double latitud;
    @SerializedName("Longitud")
    @Expose
    private double longitud;
    @SerializedName("Titulo")
    @Expose
    private String titulo;
    @SerializedName("Descripcion")
    @Expose
    private String descripcion;
    @SerializedName("Predeterminado")
    @Expose
    private Boolean predeterminado;

    public Integer getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
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

package com.example.encuentraloya.entidad;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class UbicacionNegocioDto {

    @SerializedName("IdNegocioUbicacion")
    @Expose
    private Integer idNegocioUbicacion;
    @SerializedName("IdNegocio")
    @Expose
    private Integer idNegocio;
    @SerializedName("Latitud")
    @Expose
    private Double latitud;
    @SerializedName("Longitud")
    @Expose
    private Double longitud;
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

    public Integer getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
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

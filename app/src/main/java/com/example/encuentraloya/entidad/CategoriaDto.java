package com.example.encuentraloya.entidad;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class CategoriaDto {
    @SerializedName("IdCategoria")
    @Expose
    private Integer idCategoria;
    @SerializedName("Descripcion")
    @Expose
    private String descripcion;
    @SerializedName("UrlImagen")
    @Expose
    private String urlImagen;
    @SerializedName("DescripcionEstado")
    @Expose
    private String descripcionEstado;
    @SerializedName("FechaRegistro")
    @Expose
    private String fechaRegistro;
    @SerializedName("FechaActualizacion")
    @Expose
    private String fechaActualizacion;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}

package com.example.encuentraloya.entidad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class NegocioDto {
    @SerializedName("IdNegocio")
    @Expose
    private Integer idNegocio;
    @SerializedName("DocumentoIdentificacion")
    @Expose
    private String documentoIdentificacion;
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Resenia")
    @Expose
    private String resenia;
    @SerializedName("DescripcionTipoDocumentoIdentificacion")
    @Expose
    private String descripcionTipoDocumentoIdentificacion;
    @SerializedName("DescripcionEstado")
    @Expose
    private String descripcionEstado;
    @SerializedName("FechaRegistro")
    @Expose
    private String fechaRegistro;
    @SerializedName("CorreoElectronico")
    @Expose
    private String correoElectronico;
    @SerializedName("Longitud")
    @Expose
    private Double longitud;
    @SerializedName("Latitud")
    @Expose
    private Double latitud;
    @SerializedName("Telefono")
    @Expose
    private String telefono;

    public Integer getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(Integer idNegocio) {
        this.idNegocio = idNegocio;
    }

    public String getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResenia() {
        return resenia;
    }

    public void setResenia(String resenia) {
        this.resenia = resenia;
    }

    public String getDescripcionTipoDocumentoIdentificacion() {
        return descripcionTipoDocumentoIdentificacion;
    }

    public void setDescripcionTipoDocumentoIdentificacion(String descripcionTipoDocumentoIdentificacion) {
        this.descripcionTipoDocumentoIdentificacion = descripcionTipoDocumentoIdentificacion;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

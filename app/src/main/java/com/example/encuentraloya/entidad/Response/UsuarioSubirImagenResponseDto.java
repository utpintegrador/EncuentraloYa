package com.example.encuentraloya.entidad.Response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsuarioSubirImagenResponseDto {
    @SerializedName("ProcesadoOk")
    @Expose
    private Integer procesadoOk;
    @SerializedName("ListaError")
    @Expose
    private List<ListaError> listaError = null;
    @SerializedName("UrlImagen")
    @Expose
    private String urlImagen;

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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

}

package com.example.encuentraloya.entidad.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginInformationResponse {
    @SerializedName("Token")
    @Expose
    private String token;

    @SerializedName("Expiracion")
    @Expose
    private String expiracion;

    @SerializedName("IdUsuario")
    @Expose
    private Integer idUsuario;

    @SerializedName("Nombre")
    @Expose
    private String nombre;

    @SerializedName("Apellido")
    @Expose
    private String apellido;

    @SerializedName("CorreoElectronico")
    @Expose
    private String correoElectronico;

    @SerializedName("UrlImagen")
    @Expose
    private String urlImagen;

    @SerializedName("UserName")
    @Expose
    private String userName;


    public LoginInformationResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(String expiracion) {
        this.expiracion = expiracion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

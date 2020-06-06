package com.example.encuentraloya.entidad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginInformationRequest {

    @SerializedName("Usuario")
    @Expose
    private String usuario;

    @SerializedName("Contrasenia")
    @Expose
    private String contrasenia;


    public LoginInformationRequest() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}

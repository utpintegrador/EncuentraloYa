package com.example.encuentraloya.entidad.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginInformationRequest {

    @SerializedName("CorreoElectronico")
    @Expose
    private String correoElectronico;
    @SerializedName("Contrasenia")
    @Expose
    private String contrasenia;

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
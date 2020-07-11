package com.example.encuentraloya.entidad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginInformationRequest {

    @SerializedName("CorreoElectronico")
    @Expose
    private String email;

    @SerializedName("Contrasenia")
    @Expose
    private String contrasenia;


    public LoginInformationRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}

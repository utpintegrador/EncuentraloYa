package com.example.encuentraloya.entidad.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecuperarCuentaRequest {

    @SerializedName("CorreoElectronico")
    @Expose
    private String correoElectronico;

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

}
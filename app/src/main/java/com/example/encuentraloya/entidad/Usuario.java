package com.example.encuentraloya.entidad;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {
    @SerializedName("Usuario")
    @Expose
    private String usuario;

    @SerializedName("Contrasenia")
    @Expose
    private String contrasenia;

    @SerializedName("Nombre")
    @Expose
    private String nombre;

    @SerializedName("Apellido")
    @Expose
    private String apellido;

    @SerializedName("CorreoElectronico")
    @Expose
    private String correoelectronico;

    public Usuario() {
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

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }
}

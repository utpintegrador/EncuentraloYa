package com.example.encuentraloya.entidad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CreateUserRequest {

    @SerializedName("CorreoElectronico")
    @Expose
    private String email;

    @SerializedName("UserName")
    @Expose
    private String userName;

    @SerializedName("Contrasenia")
    @Expose
    private String password;

    @SerializedName("Nombre")
    @Expose
    private String name;

    @SerializedName("Apellido")
    @Expose
    private String lastName;

    public CreateUserRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

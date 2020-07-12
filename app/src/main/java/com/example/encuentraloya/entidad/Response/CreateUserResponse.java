package com.example.encuentraloya.entidad.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateUserResponse {

    @SerializedName("ProcesadoOk")
    @Expose
    private float processState;

    @SerializedName("ListaError")
    @Expose
    private List<Message> listError;

    @SerializedName("IdGenerado")
    @Expose
    private float Id;

    class Message {
        @SerializedName("Mensaje")
        @Expose
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public CreateUserResponse() {
    }

    public float getProcessState() {
        return processState;
    }

    public void setProcessState(Integer processState) {
        this.processState = processState;
    }

    public List<Message> getListError() {
        return listError;
    }

    public void setListError(List<Message> listError) {
        this.listError = listError;
    }

    public float getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}

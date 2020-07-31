package com.example.encuentraloya.entidad;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataGraficoDto {
    @SerializedName("Anio")
    @Expose
    private Integer anio;
    @SerializedName("Mes")
    @Expose
    private Integer mes;
    @SerializedName("NombreMes")
    @Expose
    private String nombreMes;
    @SerializedName("Total")
    @Expose
    private Double total;

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public String getNombreMes() {
        return nombreMes;
    }

    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

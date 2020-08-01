package com.example.encuentraloya.entidad.Request;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriaRequest {

    @SerializedName("Buscar")
    @Expose
    private String buscar;
    @SerializedName("IdEstado")
    @Expose
    private Integer idEstado;
    @SerializedName("NumeroPagina")
    @Expose
    private Integer numeroPagina;
    @SerializedName("CantidadRegistros")
    @Expose
    private Integer cantidadRegistros;
    @SerializedName("ColumnaOrden")
    @Expose
    private String columnaOrden;
    @SerializedName("DireccionOrden")
    @Expose
    private String direccionOrden;

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(Integer numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public Integer getCantidadRegistros() {
        return cantidadRegistros;
    }

    public void setCantidadRegistros(Integer cantidadRegistros) {
        this.cantidadRegistros = cantidadRegistros;
    }

    public String getColumnaOrden() {
        return columnaOrden;
    }

    public void setColumnaOrden(String columnaOrden) {
        this.columnaOrden = columnaOrden;
    }

    public String getDireccionOrden() {
        return direccionOrden;
    }

    public void setDireccionOrden(String direccionOrden) {
        this.direccionOrden = direccionOrden;
    }

}

package com.example.encuentraloya.entidad.Request;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObtenerTiendasCercanasRequest {
    @SerializedName("Buscar")
    @Expose
    private String buscar;
    @SerializedName("CantidadKilometros")
    @Expose
    private Integer cantidadKilometros;
    @SerializedName("IdUsuario")
    @Expose
    private Integer idUsuario;
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

    @SerializedName("UbicacionLongitudInicio")
    @Expose
    private double ubicacionLongitudInicio;
    @SerializedName("UbicacionLatitudInicio")
    @Expose
    private double ubicacionLatitudInicio;

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public Integer getCantidadKilometros() {
        return cantidadKilometros;
    }

    public void setCantidadKilometros(Integer cantidadKilometros) {
        this.cantidadKilometros = cantidadKilometros;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public double getUbicacionLongitudInicio() {
        return ubicacionLongitudInicio;
    }

    public void setUbicacionLongitudInicio(double ubicacionLongitudInicio) {
        this.ubicacionLongitudInicio = ubicacionLongitudInicio;
    }

    public double getUbicacionLatitudInicio() {
        return ubicacionLatitudInicio;
    }

    public void setUbicacionLatitudInicio(double ubicacionLatitudInicio) {
        this.ubicacionLatitudInicio = ubicacionLatitudInicio;
    }
}

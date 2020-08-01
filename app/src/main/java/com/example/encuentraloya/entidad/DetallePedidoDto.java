package com.example.encuentraloya.entidad;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetallePedidoDto {

    @SerializedName("IdPedidoDetalle")
    @Expose
    private Integer idPedidoDetalle;
    @SerializedName("Cantidad")
    @Expose
    private Integer cantidad;
    @SerializedName("PrecioUnitario")
    @Expose
    private Double precioUnitario;
    @SerializedName("DescripcionProducto")
    @Expose
    private String descripcionProducto;
    @SerializedName("UrlImagenProducto")
    @Expose
    private String urlImagenProducto;

    @SerializedName("IdProducto")
    @Expose
    private Integer idProducto;

    public Integer getIdPedidoDetalle() {
        return idPedidoDetalle;
    }

    public void setIdPedidoDetalle(Integer idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getUrlImagenProducto() {
        return urlImagenProducto;
    }

    public void setUrlImagenProducto(String urlImagenProducto) {
        this.urlImagenProducto = urlImagenProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}

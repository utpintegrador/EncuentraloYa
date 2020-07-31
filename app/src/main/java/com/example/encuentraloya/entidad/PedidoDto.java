package com.example.encuentraloya.entidad;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PedidoDto {
    @SerializedName("IdPedido")
    @Expose
    private Integer idPedido;
    @SerializedName("DocumentoIdentificacionVendedor")
    @Expose
    private String documentoIdentificacionVendedor;
    @SerializedName("NombreNegocioVendedor")
    @Expose
    private String nombreNegocioVendedor;
    @SerializedName("Direccion")
    @Expose
    private String direccion;
    @SerializedName("DescripcionMoneda")
    @Expose
    private String descripcionMoneda;
    @SerializedName("DescripcionEstado")
    @Expose
    private String descripcionEstado;
    @SerializedName("FechaRegistro")
    @Expose
    private String fechaRegistro;
    @SerializedName("FechaActualizacion")
    @Expose
    private String fechaActualizacion;

    @SerializedName("Total")
    @Expose
    private Double total;

    @SerializedName("IdEstado")
    @Expose
    private Integer idEstado;
    @SerializedName("IdMoneda")
    @Expose
    private Integer idMoneda;
    @SerializedName("IdNegocioVendedor")
    @Expose
    private Integer idNegocioVendedor;
    @SerializedName("IdNegocioComprador")
    @Expose
    private Integer idNegocioComprador;

    @SerializedName("IdUsuarioRegistro")
    @Expose
    private Integer idUsuarioRegistro;

    @SerializedName("NumeroCelular")
    @Expose
    private String numeroCelular;

    @SerializedName("Observaciones")
    @Expose
    private String observaciones;

    @SerializedName("ListaDetalle")
    @Expose
    private List<DetallePedidoDto> listaDetalle = null;

    @SerializedName("ListaPedidoDetalle")
    @Expose
    private List<DetallePedidoDto> listaPedidoDetalle = null;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getDocumentoIdentificacionVendedor() {
        return documentoIdentificacionVendedor;
    }

    public void setDocumentoIdentificacionVendedor(String documentoIdentificacionVendedor) {
        this.documentoIdentificacionVendedor = documentoIdentificacionVendedor;
    }

    public String getNombreNegocioVendedor() {
        return nombreNegocioVendedor;
    }

    public void setNombreNegocioVendedor(String nombreNegocioVendedor) {
        this.nombreNegocioVendedor = nombreNegocioVendedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcionMoneda() {
        return descripcionMoneda;
    }

    public void setDescripcionMoneda(String descripcionMoneda) {
        this.descripcionMoneda = descripcionMoneda;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Double  getTotal() {
        return total;
    }

    public void setTotal(Double  total) {
        this.total = total;
    }


    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Integer getIdNegocioVendedor() {
        return idNegocioVendedor;
    }

    public void setIdNegocioVendedor(Integer idNegocioVendedor) {
        this.idNegocioVendedor = idNegocioVendedor;
    }

    public Integer getIdNegocioComprador() {
        return idNegocioComprador;
    }

    public void setIdNegocioComprador(Integer idNegocioComprador) {
        this.idNegocioComprador = idNegocioComprador;
    }

    public List<DetallePedidoDto> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetallePedidoDto> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public Integer getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Integer idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public List<DetallePedidoDto> getListaPedidoDetalle() {
        return listaPedidoDetalle;
    }

    public void setListaPedidoDetalle(List<DetallePedidoDto> listaPedidoDetalle) {
        this.listaPedidoDetalle = listaPedidoDetalle;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

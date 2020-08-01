package com.example.encuentraloya.entidad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductDto {
    @SerializedName("IdProducto")
    @Expose
    public Integer idProduct;

    @SerializedName("DescripcionProducto")
    @Expose
    public String descriptionProduct;

    @SerializedName("DescripcionExtendida")
    @Expose
    public String descriptionExtend;

    @SerializedName("Precio")
    @Expose
    public Double price;

    @SerializedName("UrlImagen")
    @Expose
    public String urlImage;

    @SerializedName("IdMoneda")
    @Expose
    public Integer idMoney;

    @SerializedName("IdCategoria")
    @Expose
    public Integer idCategory;

    @SerializedName("IdNegocio")
    @Expose
    public Integer idBusiness;

    @SerializedName("IdEstado")
    @Expose
    public Integer idState;

    @SerializedName("Posicionamiento")
    @Expose
    public Integer idPosicionamiento;


    @SerializedName("Cantidad")
    @Expose
    public double cantidad;

    @SerializedName("idPedido")
    @Expose
    public int idPedido;




    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public String getDescriptionExtend() {
        return descriptionExtend;
    }

    public void setDescriptionExtend(String descriptionExtend) {
        this.descriptionExtend = descriptionExtend;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Integer getIdMoney() {
        return idMoney;
    }

    public void setIdMoney(Integer idMoney) {
        this.idMoney = idMoney;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(Integer idBusiness) {
        this.idBusiness = idBusiness;
    }

    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
    }

    public Integer getIdPosicionamiento() {
        return idPosicionamiento;
    }

    public void setIdPosicionamiento(Integer idPosicionamiento) {
        this.idPosicionamiento = idPosicionamiento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {

        this.cantidad = cantidad;
    }


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }


}

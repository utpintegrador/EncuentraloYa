package com.example.encuentraloya.entidad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
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


}

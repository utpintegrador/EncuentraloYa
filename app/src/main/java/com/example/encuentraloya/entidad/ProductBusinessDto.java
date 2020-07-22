package com.example.encuentraloya.entidad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ProductBusinessDto {

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

    @SerializedName("DescripcionMoneda")
    @Expose
    public String descriptionMoney;

    @SerializedName("DescripcionCategoria")
    @Expose
    public String descriptionCategory;

    @SerializedName("IdNegocio")
    @Expose
    public Integer idBusiness;

    @SerializedName("Negocio")
    @Expose
    public String business;

    @SerializedName("DescripcionEstado")
    @Expose
    public String descriptionState;

    @SerializedName("UrlImagen")
    @Expose
    public String urlImage;

    @SerializedName("CantidadDescuentos")
    @Expose
    public Integer amountDiscounts;

    @SerializedName("CantidadImagenes")
    @Expose
    public Integer amountImages;
}
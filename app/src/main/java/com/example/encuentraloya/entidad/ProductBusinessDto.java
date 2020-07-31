package com.example.encuentraloya.entidad;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


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

    @SerializedName("MontoDescuento")
    @Expose
    private Integer montoDescuento;


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

    public String getDescriptionMoney() {
        return descriptionMoney;
    }

    public void setDescriptionMoney(String descriptionMoney) {
        this.descriptionMoney = descriptionMoney;
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }

    public Integer getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(Integer idBusiness) {
        this.idBusiness = idBusiness;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getDescriptionState() {
        return descriptionState;
    }

    public void setDescriptionState(String descriptionState) {
        this.descriptionState = descriptionState;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Integer getAmountDiscounts() {
        return amountDiscounts;
    }

    public void setAmountDiscounts(Integer amountDiscounts) {
        this.amountDiscounts = amountDiscounts;
    }

    public Integer getAmountImages() {
        return amountImages;
    }

    public void setAmountImages(Integer amountImages) {
        this.amountImages = amountImages;
    }

    public Integer getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(Integer montoDescuento) {
        this.montoDescuento = montoDescuento;
    }
}

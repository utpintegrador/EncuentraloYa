package com.example.encuentraloya.entidad.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObtenerProdByNegocioRequest {

    @SerializedName("IdNegocio")
    @Expose
    private Integer idBusiness;

    @SerializedName("Buscar")
    @Expose
    private String search;

    @SerializedName("IdEstado")
    @Expose
    private Integer idState;

    @SerializedName("IdMoneda")
    @Expose
    private Integer idMoney;

    @SerializedName("IdCategoria")
    @Expose
    private Integer idCategory;

    @SerializedName("NumeroPagina")
    @Expose
    private Integer numberPage;

    @SerializedName("CantidadRegistros")
    @Expose
    private Integer totalRecords;

    @SerializedName("ColumnaOrden")
    @Expose
    private String orderColumn;

    @SerializedName("DireccionOrden")
    @Expose
    private String orderDirection;

    public Integer getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(Integer idBusiness) {
        this.idBusiness = idBusiness;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
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

    public Integer getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(Integer numberPage) {
        this.numberPage = numberPage;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }
}

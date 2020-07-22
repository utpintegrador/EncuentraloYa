package com.example.encuentraloya.entidad.Response;

import com.example.encuentraloya.entidad.ProductBusinessDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

public class ObtenerProdByNegocioResponse {

    @SerializedName("ProcesadoOk")
    @Expose
    public Integer processOk;

    @SerializedName("ListaError")
    @Expose
    public List<ListaError> list_Error = null;

    @SerializedName("Cuerpo")
    @Expose
    public List<ProductBusinessDto> list_ProductBusiness = null;

    @SerializedName("CantidadTotalRegistros")
    @Expose
    public Integer totalRecords;

    public Integer getProcessOk() {
        return processOk;
    }

    public void setProcessOk(Integer processOk) {
        this.processOk = processOk;
    }

    public List<ListaError> getList_Error() {
        return list_Error;
    }

    public void setList_Error(List<ListaError> list_Error) {
        this.list_Error = list_Error;
    }

    public List<ProductBusinessDto> getList_ProductBusiness() {
        return list_ProductBusiness;
    }

    public void setList_ProductBusiness(List<ProductBusinessDto> list_ProductBusiness) {
        this.list_ProductBusiness = list_ProductBusiness;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }
}

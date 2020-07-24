package com.example.encuentraloya.entidad.Response;
import com.example.encuentraloya.entidad.PedidoDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PedidoObtenerResponse {
    @SerializedName("ProcesadoOk")
    @Expose
    private Integer procesadoOk;
    @SerializedName("ListaError")
    @Expose
    private List<ListaError> listaError = null;
    @SerializedName("Cuerpo")
    @Expose
    private List<PedidoDto> cuerpo = null;
    @SerializedName("CantidadTotalRegistros")
    @Expose
    private Integer cantidadTotalRegistros;

    public Integer getProcesadoOk() {
        return procesadoOk;
    }

    public void setProcesadoOk(Integer procesadoOk) {
        this.procesadoOk = procesadoOk;
    }

    public List<ListaError> getListaError() {
        return listaError;
    }

    public void setListaError(List<ListaError> listaError) {
        this.listaError = listaError;
    }

    public List<PedidoDto> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(List<PedidoDto> cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Integer getCantidadTotalRegistros() {
        return cantidadTotalRegistros;
    }

    public void setCantidadTotalRegistros(Integer cantidadTotalRegistros) {
        this.cantidadTotalRegistros = cantidadTotalRegistros;
    }
}

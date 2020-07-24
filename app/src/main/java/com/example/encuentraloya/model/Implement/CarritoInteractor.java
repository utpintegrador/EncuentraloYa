package com.example.encuentraloya.model.Implement;

import android.content.Context;

import com.example.encuentraloya.comun.PedidoSQLite;
import com.example.encuentraloya.entidad.ProductDto;
import com.example.encuentraloya.model.Interfaces.OnCarritoFinishedInteractor;
import com.example.encuentraloya.model.Interfaces.OnSearchProductFinishedListener;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class CarritoInteractor {
    Context context;
    NumberFormat formatter = new DecimalFormat("#0.00");
    public CarritoInteractor(Context context) {
        this.context = context;
    }

    public  void  listarCarrito(OnCarritoFinishedInteractor lister){

        PedidoSQLite dbLite = new PedidoSQLite(context);
        List<ProductDto> lista = dbLite.ListarProductos();
        lister.onListaCarrito(lista);

    }


    public void actualizarrProducto(int idPedido,double cantidad, final OnCarritoFinishedInteractor listener ){
        PedidoSQLite db = new PedidoSQLite(context);
        if(db.actualizarProducto(idPedido,cantidad)){
            listener.onActualizadoProducto("El producto ha sido agregado");
        }else{
            listener.onMensaje("Al parecer hubo un error");
        }

    }

    public void eliminarProducto(int idPedido, final OnCarritoFinishedInteractor listener ){
        PedidoSQLite db = new PedidoSQLite(context);
        if(db.eliminarProducto(idPedido)){
            listener.onEliminadoProducto("El producto ha sido agregado");
        }else{
            listener.onMensaje("Al parecer hubo un error");
        }

    }

    public String getTotal(){
        PedidoSQLite dbLite = new PedidoSQLite(context);
        List<ProductDto> lista = dbLite.ListarProductos();

        double total=0;
        for (ProductDto obj: lista) {
            total = total + (obj.getCantidad()*obj.getPrice());
        }

        return "S/." + String.valueOf(formatter.format(total));
    }




}

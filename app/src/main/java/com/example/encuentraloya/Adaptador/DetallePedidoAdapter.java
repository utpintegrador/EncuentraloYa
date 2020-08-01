package com.example.encuentraloya.Adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.encuentraloya.R;
import com.example.encuentraloya.comun.ConstantesEstado;
import com.example.encuentraloya.entidad.DetallePedidoDto;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.http.PUT;

public class DetallePedidoAdapter  extends RecyclerView.Adapter<DetallePedidoAdapter.ViewHolder>{
    Context context;
    List<DetallePedidoDto> lista;
    int idMoneda;

    public DetallePedidoAdapter(Context context, List<DetallePedidoDto> lista, int idMoneda) {
        this.context = context;
        this.lista = lista;
        this.idMoneda=idMoneda;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detalle_pedido,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String tituloProducto = lista.get(position).getDescripcionProducto();
        String descripcion =  lista.get(position).getDescripcionProducto();
        String cantidad =  lista.get(position).getCantidad().toString();
        String subtotal = String.valueOf (lista.get(position).getPrecioUnitario()*lista.get(position).getCantidad());
        String urlProducto =  lista.get(position).getUrlImagenProducto();
        String precioUnitario = String.valueOf(lista.get(position).getPrecioUnitario());

        holder.tvProcuto.setText(descripcion);
        holder.tvCantidad.setText( "Cantidad: "+ cantidad);
        holder.tvDescripcion.setText("Precio Unitario: " + precioUnitario);
        holder.tvSubtotal.setText("S/."+ subtotal);

        Picasso.with(context).load(urlProducto).into(holder.imgProducto);

        if (idMoneda== ConstantesEstado.MONEDA_DOLARES){
            holder.tvSubtotal.setText("USD"+ subtotal);
        }

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvProcuto;
        TextView tvDescripcion;
        TextView tvCantidad;
        TextView tvSubtotal;
        ImageView imgProducto;

        public ViewHolder(View itemView) {
            super(itemView);
            imgProducto = (ImageView) itemView.findViewById(R.id.imageView);
            tvProcuto = (TextView) itemView.findViewById(R.id.tvProducto);
            tvDescripcion = (TextView) itemView.findViewById(R.id.tvDescripcion);
            tvCantidad = (TextView) itemView.findViewById(R.id.tvCantidad);
            tvSubtotal = (TextView) itemView.findViewById(R.id.tvSubtotal);

        }
    }

}

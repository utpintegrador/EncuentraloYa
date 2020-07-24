package com.example.encuentraloya.Adaptador;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.encuentraloya.R;
import com.example.encuentraloya.entidad.PedidoDto;
import com.example.encuentraloya.view.Implement.DetallePedidoActivity;


import java.util.List;

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.ViewHolder> {

    Context context;
    List<PedidoDto> lista;

    public PedidoAdapter(Context context, List<PedidoDto> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pedido,parent,false );
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String nombreNegocio = lista.get(position).getNombreNegocioVendedor();
        String fecha = lista.get(position).getFechaRegistro();
        String estado=lista.get(position).getDescripcionEstado();

        //asignar valor a la vista
        holder.estado_pedido.setText(estado);
        holder.fecha_pedido.setText(fecha);
        holder.nombre_tienda.setText(nombreNegocio);

        if(estado.equals("Generado")){
            holder.img_alert.setVisibility(View.VISIBLE);
        }else if (estado.equals("Rechazado")){
            holder.img_cancel.setVisibility(View.VISIBLE);
        }else  {
            holder.img_check.setVisibility(View.VISIBLE);
        }

        //listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetallePedidoActivity.class);
                intent.putExtra("idPedido", lista.get(position).getIdPedido());
                intent.putExtra("DescripcionEstado",lista.get(position).getDescripcionEstado());
                intent.putExtra("nombreTienda",lista.get(position).getNombreNegocioVendedor());
                intent.putExtra("fecha",lista.get(position).getFechaRegistro());
                v.getContext().startActivity(intent);
                //Toast toast = Toast.makeText(v.getContext(), String.valueOf(position) ,Toast.LENGTH_SHORT);
                //toast.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre_tienda;
        private TextView fecha_pedido;
        private TextView estado_pedido;
        private ImageView img_check;
        private ImageView img_alert;
        private ImageView img_cancel;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre_tienda = (TextView) itemView.findViewById(R.id.tvTienda);
            fecha_pedido =(TextView) itemView.findViewById(R.id.tvfecha);
            estado_pedido=(TextView) itemView.findViewById(R.id.tvEstadoPedido);
            img_check = (ImageView) itemView.findViewById(R.id.imageViewCheck);
            img_alert = (ImageView) itemView.findViewById(R.id.imageViewAlerta);
            img_cancel = (ImageView) itemView.findViewById(R.id.imageViewCancel);


        }




    }


}

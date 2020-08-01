package com.example.encuentraloya.Adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.encuentraloya.R;
import com.example.encuentraloya.entidad.CategoriaDto;
import com.example.encuentraloya.entidad.ProductDto;
import com.example.encuentraloya.view.Interfaces.ICarritoView;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class CarritoItemAdaptador extends RecyclerView.Adapter<CarritoItemAdaptador.ViewHolder> {
    Context context;
    public List<ProductDto> lista;
    NumberFormat formatter = new DecimalFormat("#0.00");
    ICarritoView view;

    public CarritoItemAdaptador(Context context, List<ProductDto> lista, ICarritoView view) {
        this.context = context;
        this.lista = lista;
        this.view = view;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrito, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ProductDto entity = lista.get(position);

        holder.textViewTitle.setText(entity.getDescriptionProduct());
        holder.textViewShortDesc.setText("");
        holder.btnCantidad.setText( String.valueOf(entity.getCantidad()));
        holder.textPriceUnit.setText("Precio Unitario: " + String.valueOf(entity.getPrice()));
        holder.textPrice.setText("S/." + String.valueOf( formatter.format(entity.getPrice()*entity.getCantidad())));
        //holder.img_producto.
        Picasso.with(context).load(entity.getUrlImage()).into(holder.img_producto);

        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDto obj = lista.get(position);
                notifyDataSetChanged();
                lista.remove(lista.get(position));
                view.setOperation(2,obj.getIdPedido(),obj.getCantidad());
            }
        });


        holder.btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDto obj = lista.get(position);
                if(obj.getCantidad()>0){
                    obj.setCantidad(obj.getCantidad()-1);
                    holder.btnCantidad.setText( String.valueOf(obj.getCantidad()));
                    holder.textPrice.setText("S/." + String.valueOf( formatter.format(entity.getPrice()*entity.getCantidad())));
                    notifyDataSetChanged();
                    view.setOperation(1,obj.getIdPedido(),obj.getCantidad());
                    obj =null;


                }
            }
        });

        holder.btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
                ProductDto obj = lista.get(position);
                obj.setCantidad(obj.getCantidad()+1);
                holder.btnCantidad.setText( String.valueOf(obj.getCantidad()));
                holder.textPrice.setText("S/." + String.valueOf( formatter.format(entity.getPrice()*entity.getCantidad())));
                notifyDataSetChanged();
                view.setOperation(1,obj.getIdPedido(),obj.getCantidad());
                obj =null;
            }
        });


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_producto;
        private TextView textViewTitle;
        private TextView textViewShortDesc;
        private Button btnCantidad;
        private TextView textPrice;
        private Button btnRestar;
        private Button btnSumar;
        private Button btnEliminar;
        private TextView textPriceUnit;

        public ViewHolder(View v) {
            super(v);
            img_producto=(ImageView) v.findViewById(R.id.imageView);
            textViewTitle = (TextView)v.findViewById(R.id.textViewTitle);
            textViewShortDesc = (TextView)v.findViewById(R.id.textViewShortDesc);
            btnCantidad = (Button) v.findViewById(R.id.btnCantidad);
            textPrice = (TextView)v.findViewById(R.id.textPrice);
            textPriceUnit = (TextView)v.findViewById(R.id.textPriceUnit);

            btnRestar = (Button)v.findViewById(R.id.btnRestar);
            btnSumar = (Button) v.findViewById(R.id.btnSumar);
            btnEliminar = (Button)v.findViewById(R.id.btnEliminar);
        }
    }

}

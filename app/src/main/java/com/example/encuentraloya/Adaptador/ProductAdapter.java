package com.example.encuentraloya.Adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.encuentraloya.R;
import com.example.encuentraloya.comun.Generico;
import com.example.encuentraloya.entidad.ProductBusinessDto;
import com.example.encuentraloya.presenter.BuscarProductoPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.GridHolder> {

    BuscarProductoPresenter presenter;
    public List<ProductBusinessDto> list_productBusinessDto;
    Context context;

    public ProductAdapter(List<ProductBusinessDto> list_productBusinessDto, Context context, BuscarProductoPresenter presenter) {
        this.list_productBusinessDto = list_productBusinessDto;
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public GridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new GridHolder(view);
    }

    @Override
    public void onBindViewHolder(GridHolder holder, final int position) {
        // Descripcion
        holder.tv_prodDescription.setText(list_productBusinessDto.get(position).getDescriptionProduct());
        // Precio
        double precio = list_productBusinessDto.get(position).price;
        //descuento
        double descuento = list_productBusinessDto.get(position).getMontoDescuento();

        holder.tv_Descuento.setVisibility(View.GONE);
        if(descuento>0){
            double newPrice = Generico.round( precio- descuento,2);
            holder.tv_prodPrice.setText("S/".concat(Double.toString(newPrice)));
            holder.tv_Descuento.setText("S/".concat(Double.toString(precio)));
            holder.tv_Descuento.setVisibility(View.VISIBLE);
        }else{
            holder.tv_prodPrice.setText("S/".concat(Double.toString(precio)));
        }

        //holder.tv_prodPrice.setText("S/".concat(Double.toString(precio)));
        // Url Imagen
        Picasso.with(context).load(list_productBusinessDto.get(position).getUrlImage()).into(holder.iv_prod);

        //evento click
        holder.btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.agregarProducto(list_productBusinessDto.get(position).getIdProduct(),
                        1,
                        list_productBusinessDto.get(position).getDescriptionProduct(),
                         Generico.round(list_productBusinessDto.get(position).getPrice()- list_productBusinessDto.get(position).getMontoDescuento(),2),
                        list_productBusinessDto.get(position).getUrlImage());

            }
        });



    }

    @Override
    public int getItemCount() {
        return list_productBusinessDto.size();
    }

    public static class GridHolder extends RecyclerView.ViewHolder {

        private ImageView iv_prod;
        private TextView tv_prodDescription;
        private TextView tv_prodPrice;
        private ImageButton btn_agregar;
        private TextView tv_Descuento;

        public GridHolder(View v) {
            super(v);
            iv_prod = (ImageView) v.findViewById(R.id.imageViewProduct);
            tv_prodDescription = (TextView) v.findViewById(R.id.tvDescription);
            tv_prodPrice = (TextView) v.findViewById(R.id.tvPrice);
            tv_Descuento = (TextView) v.findViewById(R.id.tvPrecioAntiguo);
            btn_agregar =(ImageButton) v.findViewById(R.id.btnAgregar);
        }
    }

}

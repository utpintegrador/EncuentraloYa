package com.example.encuentraloya.Adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.encuentraloya.R;
import com.example.encuentraloya.entidad.ProductBusinessDto;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.GridHolder> {

    public List<ProductBusinessDto> list_productBusinessDto;
    Context context;

    public ProductAdapter(List<ProductBusinessDto> list_productBusinessDto, Context context) {
        this.list_productBusinessDto = list_productBusinessDto;
        this.context = context;
    }

    @Override
    public GridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new GridHolder(view);
    }

    @Override
    public void onBindViewHolder(GridHolder holder, int position) {
        // Descripcion
        holder.tv_prodDescription.setText(list_productBusinessDto.get(position).getDescriptionProduct());
        // Precio
        holder.tv_prodPrice.setText("S/".concat(Double.toString(list_productBusinessDto.get(position).getPrice())));
        // Url Imagen
        //Picasso.with(context).load(list_productBusinessDto.get(position).getUrlImage()).into(holder.iv_prod);
    }

    @Override
    public int getItemCount() {
        return list_productBusinessDto.size();
    }

    public static class GridHolder extends RecyclerView.ViewHolder {

        private ImageView iv_prod;
        private TextView tv_prodDescription;
        private TextView tv_prodPrice;

        public GridHolder(View v) {
            super(v);
            iv_prod = (ImageView) v.findViewById(R.id.imageViewProduct);
            tv_prodDescription = (TextView) v.findViewById(R.id.tvDescription);
            tv_prodPrice = (TextView) v.findViewById(R.id.tvPrice);
        }
    }
}

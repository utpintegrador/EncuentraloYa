package com.example.encuentraloya.Adaptador;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.encuentraloya.R;
import com.example.encuentraloya.entidad.CategoriaDto;
import com.example.encuentraloya.view.Implement.BuscarProductoActivity;
import com.example.encuentraloya.view.Implement.DetallePedidoActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewHolder> {
    Context context;

    public List<CategoriaDto> listaCategoria;

    public CategoriaAdapter(List<CategoriaDto> listaCategoria, Context context) {
        this.listaCategoria = listaCategoria;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String nombreCategoria = listaCategoria.get(position).getDescripcion();
        String urlCategoria =  listaCategoria.get(position).getUrlImagen();

        holder.name_categoria.setText(nombreCategoria);

        Picasso.with(context).load(urlCategoria).into(holder.img_categoria);

        //click en la imagen
        holder.img_categoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idCategoria = listaCategoria.get(position).getIdCategoria();

                Intent intent = new Intent(view.getContext(), BuscarProductoActivity.class);
                intent.putExtra("idCategoria", idCategoria);
                view.getContext().startActivity(intent);
                ((Activity)context).finish(); //finaliza sesión
            }
        });




    }

    @Override
    public int getItemCount() {
        return listaCategoria.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name_categoria;
        private ImageView img_categoria;
        public ViewHolder(View v) {
            super(v);
            name_categoria = (TextView) v.findViewById(R.id.tv_nombre_categoria);
            img_categoria=(ImageView) v.findViewById(R.id.img_categoria);

        }
    }



}

package com.example.encuentraloya.Adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.encuentraloya.R;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.Generico;
import com.example.encuentraloya.comun.SharedPreferencesManager;
import com.example.encuentraloya.entidad.NegocioDto;

import java.util.List;

public class NegocioCercanoAdapter extends RecyclerView.Adapter<NegocioCercanoAdapter.ViewHolder>{
    Context context;
    List<NegocioDto> lista;
    INegocioCercanoAdapterView negocioCercanoAdapterView;

    static  int itemSelected=0;


    public NegocioCercanoAdapter(Context context, List<NegocioDto> lista,  INegocioCercanoAdapterView negocioCercanoAdapterView) {
        this.context = context;
        this.lista = lista;
        this.negocioCercanoAdapterView = negocioCercanoAdapterView;

        //cargo por defecto el seleccionado

        int idNegocio = SharedPreferencesManager.getIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO);
        if(idNegocio!=0){
            for (NegocioDto entity: lista ){
                if(entity.getIdNegocio()==idNegocio){
                    itemSelected = lista.lastIndexOf(entity);
                    break;
                }
            }
        }



    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tienda,parent,false );
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        String nombreNegocio = lista.get(position).getNombre();
        int distance = Generico.calculateDistanceInKilometer(Constantes.LATITUD_VALUE, Constantes.LONGITUD_VALUE, lista.get(position).getLatitud(), lista.get(position).getLatitud());
        String distancia = "" + distance + " KM";

        // ASIGNACIÓN DE VALORES
        holder.tvTiendaNombre.setText(nombreNegocio);
        holder.tvDistancia.setText(distancia);

        //EVENTO CLICK
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemSelected = position;
                notifyDataSetChanged();
                SharedPreferencesManager.setIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO,lista.get(position).getIdNegocio());
                negocioCercanoAdapterView.updateNegocioSelected(lista.get(position).getNombre(), holder.tvDistancia.getText().toString());
            }

        });


        if( itemSelected == position){
            holder.img_selected.setVisibility(View.VISIBLE);
            negocioCercanoAdapterView.updateNegocioSelected(lista.get(position).getNombre(), holder.tvDistancia.getText().toString());
        }else{
            holder.img_selected.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTiendaNombre;
        TextView tvDistancia;
        ImageView img_selected;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTiendaNombre =(TextView) itemView.findViewById(R.id.tvTienda);
            tvDistancia =(TextView) itemView.findViewById(R.id.tvKilometros);
            img_selected =(ImageView)itemView.findViewById(R.id.img_selected);
            img_selected.setVisibility(View.GONE);
        }
    }


}

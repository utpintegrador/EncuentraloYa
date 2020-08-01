package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.encuentraloya.Adaptador.DetallePedidoAdapter;
import com.example.encuentraloya.R;
import com.example.encuentraloya.comun.ConstantesEstado;
import com.example.encuentraloya.comun.Generico;
import com.example.encuentraloya.entidad.PedidoDto;
import com.example.encuentraloya.model.Implement.DetallePedidoInteractor;
import com.example.encuentraloya.presenter.DetallePedidoPresenter;
import com.example.encuentraloya.view.Interfaces.IDetallePedidoView;

public class DetallePedidoActivity extends AppCompatActivity implements IDetallePedidoView , View.OnClickListener {
    DetallePedidoPresenter presenter;
    TextView tvTelefono;
    TextView tvTienda;
    TextView tvEstadoPedido;
    TextView tvFecha;
    TextView tvTotal;

    ImageView img_alert;
    ImageView img_cancel;
    ImageView img_check;

    ImageButton btn_back;

    RecyclerView rvDetallePedido;

    DetallePedidoAdapter adapter;

    String nombreTienda;
    String descripcionEstado;
    String fecha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pedido);

        tvTelefono = (TextView) findViewById(R.id.tvtelefono);
        tvTienda = (TextView) findViewById(R.id.tvTienda);
        tvEstadoPedido = (TextView) findViewById(R.id.tvEstadoPedido);
        tvFecha = (TextView) findViewById(R.id.tvfecha);
        tvTotal = (TextView) findViewById(R.id.tvTotal);

        img_alert = (ImageView)findViewById(R.id.imageViewAlerta);
        img_cancel = (ImageView)findViewById(R.id.imageViewCancel);
        img_check = (ImageView)findViewById(R.id.imageViewCheck);

        btn_back = (ImageButton)findViewById(R.id.btn_back);

        rvDetallePedido = (RecyclerView)findViewById(R.id.rvDetallePedido);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        rvDetallePedido.setHasFixedSize(true);
        rvDetallePedido.setLayoutManager(layoutManager);

        //listener
        btn_back.setOnClickListener(this);

        //init
        presenter=new DetallePedidoPresenter(this, new DetallePedidoInteractor());

        Bundle b = getIntent().getExtras();
        if(b!= null){
            nombreTienda = b.getString("nombreTienda");
            descripcionEstado  = b.getString("DescripcionEstado");
            fecha  = b.getString("fecha");
            presenter.getAllPedidos(b.getInt("idPedido"));
        }else{
            finish();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                finish();
                break;
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showPedidos(PedidoDto pedido) {
        //adaptador
        adapter = new DetallePedidoAdapter(this,pedido.getListaDetalle(),pedido.getIdMoneda());
        rvDetallePedido.setAdapter(adapter);

        tvTienda.setText(nombreTienda);
        tvTelefono.setText(pedido.getDireccion());
        tvEstadoPedido.setText(descripcionEstado);
        tvFecha.setText(fecha);
        tvTotal.setText("S/."+pedido.getTotal().toString());
        if(pedido.getIdMoneda().equals(ConstantesEstado.MONEDA_DOLARES)){
            tvTotal.setText("USD"+pedido.getTotal().toString());
        }

        if (descripcionEstado.equals("Generado")){
            img_alert.setVisibility(View.VISIBLE);
        }else if (descripcionEstado.equals("Rechazado") || descripcionEstado.equals("Cancelado")){
            img_cancel.setVisibility(View.VISIBLE);
        }else{
            img_check.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void showMessage(String message) {

    }
}

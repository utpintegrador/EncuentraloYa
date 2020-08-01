package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.encuentraloya.Adaptador.PedidoAdapter;
import com.example.encuentraloya.R;
import com.example.encuentraloya.entidad.PedidoDto;
import com.example.encuentraloya.model.Implement.MiPedidoInteractor;
import com.example.encuentraloya.presenter.MiPedidoPresenter;
import com.example.encuentraloya.view.Interfaces.IMisPedidosView;

import java.util.List;

public class MisPedidoActivity extends AppCompatActivity implements IMisPedidosView, View.OnClickListener {
    MiPedidoPresenter presenter;

    ImageButton btn_back;
    RecyclerView rcPedido;
    PedidoAdapter pedidoAdapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_pedido);

        btn_back = (ImageButton) findViewById(R.id.btn_back);

        progressBar = (ProgressBar)  findViewById(R.id.progress_pedidos);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        rcPedido = (RecyclerView) findViewById(R.id.rvPedido);
        rcPedido.setHasFixedSize(true);
        rcPedido.setLayoutManager(layoutManager);

        //listener
        btn_back.setOnClickListener(this);

        //init
        presenter =new MiPedidoPresenter(this, new MiPedidoInteractor());

        presenter.getAllPedidos();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                startActivity(new Intent(this, PerfilActivity.class));
                break;
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showPedidos(List<PedidoDto> listaPedido) {
        rcPedido.setVisibility(View.VISIBLE);
        pedidoAdapter = new PedidoAdapter(this, listaPedido);
        rcPedido.setAdapter(pedidoAdapter);

    }

    @Override
    public void showMessage(String message) {
        Toast toast = Toast.makeText(this, message,Toast.LENGTH_SHORT);
        toast.show();
    }


}

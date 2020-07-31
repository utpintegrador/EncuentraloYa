package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.encuentraloya.Adaptador.CarritoItemAdaptador;
import com.example.encuentraloya.R;
import com.example.encuentraloya.entidad.ProductDto;
import com.example.encuentraloya.model.Implement.CarritoInteractor;
import com.example.encuentraloya.presenter.CarritoPresenter;
import com.example.encuentraloya.view.Interfaces.ICarritoView;

import java.util.List;

public class CarritoActivity extends AppCompatActivity implements ICarritoView , View.OnClickListener {

    CarritoPresenter presenter;

    TextView tv_total;
    RecyclerView rvItem;
    CarritoItemAdaptador itemAdaptador;
    ProgressBar progress_carrito;
    Button btn_continuar;

    Button navegation_inicio;
    Button navegation_buscar;
    Button navegation_carrito;
    Button navegation_perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        navegation_inicio =(Button) this.findViewById(R.id.btn_inicio);
        navegation_buscar=(Button) this.findViewById(R.id.btn_buscar);
        navegation_carrito=(Button) this.findViewById(R.id.btn_carrito);
        navegation_perfil =(Button) this.findViewById(R.id.btn_perfil);

        tv_total= (TextView)findViewById(R.id.tv_total);
        progress_carrito = (ProgressBar) findViewById(R.id.progress_carrito);
        btn_continuar = (Button)findViewById(R.id.btn_continuar);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        rvItem = (RecyclerView) findViewById(R.id.rvItem);
        rvItem.setHasFixedSize(true);
        rvItem.setLayoutManager(layoutManager);

        //set listener
        navegation_inicio.setOnClickListener(this);
        navegation_buscar.setOnClickListener(this);
        navegation_carrito.setOnClickListener(this);
        navegation_perfil.setOnClickListener(this);
        btn_continuar.setOnClickListener(this);

        presenter = new CarritoPresenter(this ,new CarritoInteractor(this));
        presenter.listarCarrito();
    }

    @Override
    public void showMensaje(String mensaje) {
        Toast toast = Toast.makeText(this, mensaje,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showProgress() {
        progress_carrito.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress_carrito.setVisibility(View.GONE);
    }

    @Override
    public void showRecyclerView() {
        rvItem.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRecyclerView() {
        rvItem.setVisibility(View.GONE);
    }

    @Override
    public void showListaCarrito(List<ProductDto> lista) {
        itemAdaptador = new CarritoItemAdaptador(this, lista,this);
        rvItem.setAdapter(itemAdaptador);

    }

    @Override
    public void showTotal(String total) {
        tv_total.setText(total);
    }

    @Override
    public void setOperation(int operation, int idPedido, double cantidad) {
        if(operation==1){ //actualiza
            presenter.setActualizarProducto(idPedido,cantidad);
        }else if(operation==2){ //elimina
            presenter.setEliminarProducto(idPedido);
        }
    }

    @Override
    public void nagevationContinuar() {
        startActivity(new Intent(this,ConfirmarPedidoActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_continuar:
                presenter.moveContinuar();
                //startActivity(new Intent(this,ConfirmarPedidoActivity.class));
                break;
            case R.id.btn_inicio:
                startActivity(new Intent(this,HomeActivity.class));
                finish();
                break;
            case R.id.btn_buscar:
                startActivity(new Intent(this,BuscarProductoActivity.class));
                finish();
                break;
            case R.id.btn_carrito:
                startActivity(new Intent(this,CarritoActivity.class));
                finish();
                break;
            case R.id.btn_perfil:
                startActivity(new Intent(this,PerfilActivity.class));
                finish();
                break;
        }
    }
}

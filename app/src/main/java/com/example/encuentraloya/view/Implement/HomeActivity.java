package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.encuentraloya.Adaptador.CategoriaAdapter;
import com.example.encuentraloya.R;
import com.example.encuentraloya.entidad.CategoriaDto;
import com.example.encuentraloya.model.Implement.HomeInteractor;
import com.example.encuentraloya.presenter.HomePresenter;
import com.example.encuentraloya.view.Interfaces.IHomeView;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, IHomeView {

    Button navegation_inicio;
    Button navegation_buscar;
    Button navegation_carrito;
    Button navegation_perfil;

    RecyclerView rvCategoria;
    ProgressBar progressBar;

    RelativeLayout navegation_tiendas_cercanas;

    HomePresenter presenter;

    CategoriaAdapter catAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navegation_inicio =(Button) this.findViewById(R.id.btn_inicio);
        navegation_buscar=(Button) this.findViewById(R.id.btn_buscar);
        navegation_carrito=(Button) this.findViewById(R.id.btn_carrito);
        navegation_perfil =(Button) this.findViewById(R.id.btn_perfil);
        navegation_tiendas_cercanas=(RelativeLayout)  this.findViewById(R.id.rl_tiendas_cercanas);
        progressBar =(ProgressBar)  this.findViewById(R.id.progress_home_categoria);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        LinearLayoutManager layoutManager =
                new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);

        rvCategoria=(RecyclerView) this.findViewById(R.id.rvCategoria);
        rvCategoria.setHasFixedSize(true);
        rvCategoria.setLayoutManager(layoutManager);

        //set listener
        navegation_inicio.setOnClickListener(this);
        navegation_buscar.setOnClickListener(this);
        navegation_carrito.setOnClickListener(this);
        navegation_perfil.setOnClickListener(this);
        navegation_tiendas_cercanas.setOnClickListener(this);

        //Init
        presenter = new HomePresenter(this, new HomeInteractor());

        presenter.getAllCategoria();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_inicio:
                startActivity(new Intent(HomeActivity.this,HomeActivity.class));
                finish();
                break;
            case R.id.btn_buscar:
                startActivity(new Intent(HomeActivity.this,BuscarProductoActivity.class));
                finish();
                break;
            case R.id.btn_carrito:
                startActivity(new Intent(HomeActivity.this,CarritoActivity.class));
                finish();
                break;
            case R.id.btn_perfil:
                startActivity(new Intent(HomeActivity.this,PerfilActivity.class));
                finish();
                break;
            case R.id.rl_tiendas_cercanas:
                startActivity(new Intent(HomeActivity.this,ListaTiendasCercanasActivity.class));
                finish();
                break;
        }
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void showRecyclerView() {
        rvCategoria.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showCategoria(List<CategoriaDto> listaCategoria) {
        catAdapter=new CategoriaAdapter(listaCategoria,this);
        rvCategoria.setAdapter(catAdapter);
    }

    @Override
    public void showMessage(String message) {

    }



}

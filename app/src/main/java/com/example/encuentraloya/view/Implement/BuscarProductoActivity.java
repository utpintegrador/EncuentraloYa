package com.example.encuentraloya.view.Implement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.encuentraloya.Adaptador.ProductAdapter;
import com.example.encuentraloya.R;
import com.example.encuentraloya.entidad.ProductBusinessDto;
import com.example.encuentraloya.model.Implement.BuscarProductoInteractor;
import com.example.encuentraloya.presenter.BuscarProductoPresenter;
import com.example.encuentraloya.view.Interfaces.IBuscarProductoView;

import java.util.List;

public class BuscarProductoActivity extends AppCompatActivity implements IBuscarProductoView, View.OnClickListener {
    ProductAdapter productAdapter;
    private BuscarProductoPresenter presenter;

    private EditText search;
    private ProgressBar progressBar;
    private RecyclerView recyclerView_products;

    Button navegation_inicio;
    Button navegation_buscar;
    Button navegation_carrito;
    Button navegation_perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_producto);

        navegation_inicio =(Button) this.findViewById(R.id.btn_inicio);
        navegation_buscar=(Button) this.findViewById(R.id.btn_buscar);
        navegation_carrito=(Button) this.findViewById(R.id.btn_carrito);
        navegation_perfil =(Button) this.findViewById(R.id.btn_perfil);

        search =(EditText) this.findViewById(R.id.search_product);
        progressBar = (ProgressBar) this.findViewById(R.id.progress_search);

        recyclerView_products = this.findViewById(R.id.rv_products);
        //recyclerView_products.setHasFixedSize(true);
        //recyclerView_products.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        //set listener
        navegation_inicio.setOnClickListener(this);
        navegation_buscar.setOnClickListener(this);
        navegation_carrito.setOnClickListener(this);
        navegation_perfil.setOnClickListener(this);

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    String text = search.getText().toString();
                    //Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

                    // Oculta el teclado
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(search.getWindowToken(), 0);

                    presenter.searchProductsByIdBusiness(29, text, 1, 1, 0, 1, 0,
                            "Precio", "desc");

                    return true;
                }
                return false;
            }
        });

        //presenter = new RegisterUsuarioPresenter(this, new RegisterUsuarioInteractor());
        presenter = new BuscarProductoPresenter(this, new BuscarProductoInteractor(this));

        Bundle b = getIntent().getExtras();
        if(b!= null){
            int idCategoria = b.getInt("idCategoria");
            //inicializa el filtro por defecto
            presenter.searchProductsByIdBusiness(29, "", 1, 1, idCategoria, 1, 0,
                    "Precio", "desc");
        }else{
            //inicializa el filtro por defecto
            presenter.searchProductsByIdBusiness(29, "", 1, 1, 0, 1, 0,
                    "Precio", "desc");
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
    public void showRecyclerView() {
        recyclerView_products.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRecyclerView() {
        recyclerView_products.setVisibility(View.GONE);
    }

    @Override
    public void showProducts(List<ProductBusinessDto> list_productBusinessDto) {
        recyclerView_products.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        productAdapter = null;
        recyclerView_products.setAdapter(null);
        productAdapter = new ProductAdapter(list_productBusinessDto, this, presenter);
        recyclerView_products.setAdapter(productAdapter);
        productAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void hideEmpty() {

    }

    @Override
    public void showMensaje(String mensaje) {
        Toast toast = Toast.makeText(this, mensaje,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showSuccesAddProducto(String mensaje) {
        Toast toast = Toast.makeText(this, mensaje,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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

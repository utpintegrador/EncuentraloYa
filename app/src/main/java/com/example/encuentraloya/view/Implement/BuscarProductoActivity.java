package com.example.encuentraloya.view.Implement;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
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

public class BuscarProductoActivity extends AppCompatActivity implements IBuscarProductoView {

    ProductAdapter productAdapter;
    private BuscarProductoPresenter presenter;
    private EditText search;
    private ProgressBar progressBar;
    private RecyclerView recyclerView_products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_producto);

        search = this.findViewById(R.id.search_product);
        progressBar = this.findViewById(R.id.progress_search);

        recyclerView_products = this.findViewById(R.id.rv_products);
        //recyclerView_products.setHasFixedSize(true);
        recyclerView_products.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


        //presenter = new RegisterUsuarioPresenter(this, new RegisterUsuarioInteractor());
        presenter = new BuscarProductoPresenter(this, new BuscarProductoInteractor());

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String text = search.getText().toString();
                    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

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
    public void showProducts(List<ProductBusinessDto> list_productBusinessDto) {
        productAdapter = new ProductAdapter(list_productBusinessDto, this);
        recyclerView_products.setAdapter(productAdapter);
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void hideEmpty() {

    }
}

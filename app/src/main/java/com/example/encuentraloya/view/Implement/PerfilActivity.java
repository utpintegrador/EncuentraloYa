package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.encuentraloya.R;
import com.example.encuentraloya.entidad.CategoriaDto;
import com.example.encuentraloya.model.Implement.PerfilInteractor;
import com.example.encuentraloya.presenter.PerfilPresenter;
import com.example.encuentraloya.view.Interfaces.IHomeView;
import com.example.encuentraloya.view.Interfaces.IPerfilView;

import org.w3c.dom.Text;

import java.util.List;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener , IPerfilView {
    PerfilPresenter presenter;

    Button navegation_inicio;
    Button navegation_buscar;
    Button navegation_carrito;
    Button navegation_perfil;

    LinearLayout btn_mi_negocio;
    LinearLayout btn_mi_pedido;
    LinearLayout btn_mi_estadistica;
    LinearLayout btn_mi_cambio_pwd;
    LinearLayout btn_cerrar_sesion;

    TextView etNombreCompleto;
    TextView etCorreoElectronico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        etNombreCompleto=(TextView) this.findViewById(R.id.et_NombreCompleto);
        etCorreoElectronico=(TextView) this.findViewById(R.id.et_CorreoElectronico);

        navegation_inicio =(Button) this.findViewById(R.id.btn_inicio);
        navegation_buscar=(Button) this.findViewById(R.id.btn_buscar);
        navegation_carrito=(Button) this.findViewById(R.id.btn_carrito);
        navegation_perfil =(Button) this.findViewById(R.id.btn_perfil);

        btn_mi_negocio = (LinearLayout) findViewById(R.id.Ly_mi_negocio);
        btn_mi_pedido = (LinearLayout) findViewById(R.id.Ly_mi_pedido);
        btn_mi_estadistica = (LinearLayout) findViewById(R.id.Ly_mi_estadistica);
        btn_mi_cambio_pwd = (LinearLayout) findViewById(R.id.Ly_mi_actualizar_pwd);
        btn_cerrar_sesion = (LinearLayout) findViewById(R.id.Ly_cerrar_sesion);

        //listener
        navegation_inicio.setOnClickListener(this);
        navegation_buscar.setOnClickListener(this);
        navegation_carrito.setOnClickListener(this);
        navegation_perfil.setOnClickListener(this);

        btn_mi_negocio.setOnClickListener(this);
        btn_mi_pedido.setOnClickListener(this);
        btn_mi_estadistica.setOnClickListener(this);
        btn_mi_cambio_pwd.setOnClickListener(this);
        btn_cerrar_sesion.setOnClickListener(this);

        //init
        presenter = new PerfilPresenter(this, new PerfilInteractor());
        presenter.getPerfilData();

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

            case R.id.Ly_mi_negocio:
                startActivity(new Intent(this,MyNegocioActivity.class));
                finish();
                break;

            case R.id.Ly_mi_pedido:
                //startActivity(new Intent(this,ListaTiendasCercanasActivity.class));
                finish();
                break;

            case R.id.Ly_mi_estadistica:
               // startActivity(new Intent(this,ListaTiendasCercanasActivity.class));
                finish();
                break;

            case R.id.Ly_mi_actualizar_pwd:
                //startActivity(new Intent(this,ListaTiendasCercanasActivity.class));
                finish();
                break;

            case R.id.Ly_cerrar_sesion:
                //startActivity(new Intent(this,ListaTiendasCercanasActivity.class));
                finish();
                break;


        }
    }


    @Override
    public void showPerfilDatos(String nombreCompleto, String correoElectronico) {
        etNombreCompleto.setText(nombreCompleto); ;
        etCorreoElectronico.setText(correoElectronico);
    }
}

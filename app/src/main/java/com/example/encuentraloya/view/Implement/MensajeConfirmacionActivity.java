package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.encuentraloya.R;
import com.example.encuentraloya.view.Implement.BuscarProductoActivity;
import com.example.encuentraloya.view.Implement.CarritoActivity;
import com.example.encuentraloya.view.Implement.HomeActivity;
import com.example.encuentraloya.view.Implement.LoginActivity;
import com.example.encuentraloya.view.Implement.PerfilActivity;

public class MensajeConfirmacionActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_procesado;
    TextView tvTitle;
    TextView tvMensaje;
    String operacion="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_confirmacion);

        tvMensaje = (TextView) findViewById(R.id.tvMensaje);
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        btn_procesado = (Button) findViewById(R.id.btn_procesado);

        btn_procesado.setOnClickListener(this);


        Bundle b = getIntent().getExtras();
        if(b!= null){
            operacion = b.getString("operacion");
            if(operacion.equals("confirmacion_pedido")){
                tvMensaje.setText("Su orden ha sido generado!");
                tvTitle.setText("CONFIRMACIÓN DE PEDIDO");
            }else if(operacion.equals("confirmacion_creacion_cuenta")){
                tvMensaje.setText("Su cuenta ha sido registrada!");
                tvTitle.setText("CREACIÓN DE CUENTA DE USUARIO");
            }

        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_procesado:
                if(operacion.equals("confirmacion_pedido")){
                    startActivity(new Intent(this, HomeActivity.class));
                }else if(operacion.equals("confirmacion_creacion_cuenta")){
                    startActivity(new Intent(this, LoginActivity.class));
                }

                finish();
                break;
        }
    }
}

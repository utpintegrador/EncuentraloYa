package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.encuentraloya.R;
import com.example.encuentraloya.model.Implement.ConfirmarPedidoInteractor;
import com.example.encuentraloya.presenter.ConfirmarPedidoPresenter;
import com.example.encuentraloya.view.Interfaces.IConfirmarPedidoView;

public class ConfirmarPedidoActivity extends AppCompatActivity implements IConfirmarPedidoView, View.OnClickListener {

    ImageButton btn_back;
    Button btnConfirmar;
    EditText edNumeroCelular;
    EditText edComentario;
    EditText edReferencia;
    ProgressBar progress_confirmar;

    ConfirmarPedidoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido);

        btnConfirmar = (Button) findViewById(R.id.btn_confirmar_perdido);
        edNumeroCelular = (EditText) findViewById(R.id.ed_numeroCelular);
        edComentario =(EditText) findViewById(R.id.ed_observacion);
        edReferencia=(EditText)findViewById(R.id.ed_referencia);

        progress_confirmar = (ProgressBar) findViewById(R.id.progress_confirmar);
        btn_back = (ImageButton)findViewById(R.id.btn_back);


        //listener
        btnConfirmar.setOnClickListener(this);
        btn_back.setOnClickListener(this);

        presenter = new ConfirmarPedidoPresenter(this, new ConfirmarPedidoInteractor(this));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar_perdido:
                presenter.savePedido(
                        edNumeroCelular.getText().toString(),
                        edReferencia.getText().toString(),
                        edComentario.getText().toString());
                //startActivity(new Intent(this,HomeActivity.class));
                //finish();
                break;
            case R.id.btn_back:
                startActivity(new Intent(this, CarritoActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void showProgress() {
        progress_confirmar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress_confirmar.setVisibility(View.GONE);
    }

    @Override
    public void showMensaje(String mensaje) {
        Toast toast = Toast.makeText(this, mensaje,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showSuccesPedido() {

        Intent intent = new Intent(this, MensajeConfirmacionActivity.class);
        intent.putExtra("operacion", "confirmacion_pedido");
        this.startActivity(intent);

    /*
        final Activity activity = this;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(activity,MensajeConfirmacionActivity.class));
                //enemigos.add(new Enemigo());
            }
        }, 2000); //espera 5 segundos para a~adir un enemigo
       */

    }

    @Override
    public void setNumeroCelularError(String mensaje) {
        edNumeroCelular.setError(mensaje);
    }
}

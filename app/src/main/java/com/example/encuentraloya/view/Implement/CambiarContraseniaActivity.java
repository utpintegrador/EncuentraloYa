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
import com.example.encuentraloya.model.Implement.CambiarContraseniaInteractor;
import com.example.encuentraloya.presenter.CambiarContraseniaPresenter;
import com.example.encuentraloya.view.Interfaces.ICambiarContraseniaView;

public class CambiarContraseniaActivity extends AppCompatActivity implements View.OnClickListener , ICambiarContraseniaView {
    CambiarContraseniaPresenter presenter;

    EditText edNuevaClave;
    EditText edConfirmarClave;
    ImageButton btn_back;
    Button btn_cambiar_pwd;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasenia);

        edNuevaClave = (EditText) findViewById(R.id.et_change_password);
        edConfirmarClave = (EditText) findViewById(R.id.et_change_password_confirm);
        btn_cambiar_pwd =(Button) findViewById(R.id.btn_change_pwd);
        btn_back =(ImageButton)findViewById(R.id.btn_back);
        progressBar = (ProgressBar) findViewById(R.id.progress_change_pwd);

        //init
        btn_cambiar_pwd.setOnClickListener(this);
        btn_back.setOnClickListener(this);

        presenter = new CambiarContraseniaPresenter(this, new CambiarContraseniaInteractor());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_change_pwd:
                presenter.setContrasenia(edNuevaClave.getText().toString(), edConfirmarClave.getText().toString());
                //startActivity(new Intent(this,HomeActivity.class));
                //finish();
                break;

            case R.id.btn_back:
                startActivity(new Intent(this,PerfilActivity.class));
                finish();
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
    public void showMensage(String mensaje) {
        Toast toast = Toast.makeText(this, mensaje,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showSucces() {
        Toast toast = Toast.makeText(this, "la contraseña ha sido actualizada.",Toast.LENGTH_SHORT);
        toast.show();

    }

    @Override
    public void setErrorNewContrasenia(String mensaje) {
        edNuevaClave.setError(mensaje);
    }

    @Override
    public void setErrorConformarContrasenia(String mensaje) {
        edConfirmarClave.setError(mensaje);
    }
}

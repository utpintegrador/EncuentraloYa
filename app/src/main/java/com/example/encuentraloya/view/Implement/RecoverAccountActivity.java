package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.encuentraloya.R;
import com.example.encuentraloya.model.Implement.RecoverAccountInteractor;
import com.example.encuentraloya.presenter.RecoverAccountPresenter;
import com.example.encuentraloya.view.Interfaces.IRecuperarAccountView;

public class RecoverAccountActivity extends AppCompatActivity  implements View.OnClickListener , IRecuperarAccountView {

    private RecoverAccountPresenter presenter;

    EditText et_correo;
    ProgressBar progressBar;
    Button btn_enviar_correo;
    TextView navegation_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_account);

        btn_enviar_correo = (Button) findViewById(R.id.btn_recover_account);
        navegation_login = (TextView)  findViewById(R.id.tv_recover_login);
        et_correo=(EditText)  findViewById(R.id.et_recover_email);
        progressBar =(ProgressBar) findViewById(R.id.progress_recover);

        //listener
        btn_enviar_correo.setOnClickListener(this);
        navegation_login.setOnClickListener(this);

        //init
        presenter = new RecoverAccountPresenter(this, new RecoverAccountInteractor());

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_recover_account:
                presenter.getSolicitarPassword(et_correo.getText().toString());

                break;
            case R.id.tv_recover_login:
                startActivity(new Intent(RecoverAccountActivity.this,LoginActivity.class));
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
    public void setErrorCorreoElectronico(String message) {
        et_correo.setError(message);
    }

    @Override
    public void showMessage(String message) {
        Toast toast = Toast.makeText(this, message,Toast.LENGTH_SHORT);
        toast.show();
    }
}

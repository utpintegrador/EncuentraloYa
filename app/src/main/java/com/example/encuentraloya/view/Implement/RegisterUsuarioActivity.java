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
import com.example.encuentraloya.model.Implement.RegisterUsuarioInteractor;
import com.example.encuentraloya.presenter.RegisterUsuarioPresenter;
import com.example.encuentraloya.view.Interfaces.IRegisterUsuarioView;

public class RegisterUsuarioActivity extends AppCompatActivity implements IRegisterUsuarioView, View.OnClickListener {
    RegisterUsuarioPresenter presenter;

    // Elements of layout
    private EditText createPass;
    private EditText createName;
    private EditText createLastName;
    private EditText createEmail;
    private EditText createPassConfirm;
    private Button btnCreate;
    private ProgressBar progressBar;
    private TextView linkLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_usuario);

        // Init elements
        createName = (EditText) this.findViewById(R.id.et_create_name);
        createLastName = (EditText) this.findViewById(R.id.et_create_last_name);
        createEmail = (EditText) this.findViewById(R.id.et_create_email);
        createPass = (EditText) this.findViewById(R.id.et_create_password);
        createPassConfirm = (EditText) this.findViewById(R.id.et_create_password_confirm);
        progressBar = (ProgressBar) this.findViewById(R.id.progress_create_user);
        btnCreate = (Button) this.findViewById(R.id.btn_create_user);
        linkLogin = (TextView) this.findViewById(R.id.tv_create_login);

        //set listener
        btnCreate.setOnClickListener(this);
        linkLogin.setOnClickListener(this);


        // Init
        presenter = new RegisterUsuarioPresenter(this, new RegisterUsuarioInteractor());

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_user:
                presenter.registerUser(createName.getText().toString(),
                        createLastName.getText().toString(),
                        createEmail.getText().toString(),
                        createPass.getText().toString(),
                        createPassConfirm.getText().toString());
                break;
            case R.id.tv_create_login:
                startActivity(new Intent(RegisterUsuarioActivity.this,LoginActivity.class));
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
    public void setCorreoElectronicoError(String message) {
        createEmail.setError(message);
    }

    @Override
    public void setNombreeError(String message) {
        createName.setError(message);
    }

    @Override
    public void setApellidoError(String message) {
        createLastName.setError(message);
    }

    @Override
    public void setContraseniaError(String message) {
        createPass.setError(message);
    }

    @Override
    public void setConfirmarContraseniaError(String message) {
        createPassConfirm.setError(message);
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(RegisterUsuarioActivity.this,HomeActivity.class));
        finish();
    }

    @Override
    public void onClearText() {

    }

    @Override
    public void setError(String ErrorMessage) {

    }
}

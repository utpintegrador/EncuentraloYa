package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.encuentraloya.R;
import com.example.encuentraloya.model.Implement.RegisterUsuarioInteractor;
import com.example.encuentraloya.presenter.RegisterUsuarioPresenter;
import com.example.encuentraloya.view.Interfaces.IRegisterUsuarioView;

public class RegisterUsuarioActivity extends AppCompatActivity implements IRegisterUsuarioView, View.OnClickListener {
    RegisterUsuarioPresenter presenter;

    // Elements of layout
    private EditText createUser;
    private EditText createPass;
    private EditText createName;
    private EditText createLastName;
    private EditText createEmail;
    private EditText createPassConfirm;
    private Button btnCreate;
    private ProgressBar progressBar;

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

        btnCreate = (Button) this.findViewById(R.id.btn_create_user);
        btnCreate.setOnClickListener(this); // Registra usuario

        progressBar = (ProgressBar) this.findViewById(R.id.progress_create_user);
        // Init
        presenter = new RegisterUsuarioPresenter(this, new RegisterUsuarioInteractor());

        //presenter = new RegisterUsuarioPresenter(this);
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
    public void setCorreoElectronicoError() {

    }

    @Override
    public void setUsernameError() {

    }

    @Override
    public void setNombreeError() {

    }

    @Override
    public void setApellidoError() {

    }

    @Override
    public void setContraseniasError() {

    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this, "Usuario creado", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void onClearText() {

    }

    @Override
    public void setError(String ErrorMessage) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_user:
                presenter.registerUser(createUser.getText().toString(),
                        createEmail.getText().toString(),
                        createPass.getText().toString(),
                        createName.getText().toString(),
                        createLastName.getText().toString());
                break;
        }
    }
}

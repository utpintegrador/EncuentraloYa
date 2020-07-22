package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.encuentraloya.R;
import com.example.encuentraloya.model.Implement.LoginInteractor;
import com.example.encuentraloya.presenter.LoginPresenter;
import com.example.encuentraloya.view.Interfaces.ILoginView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    private LoginPresenter presenter;

    private EditText editUser;
    private EditText editPass;
    private Button btnLogin;
    private ProgressBar progressBar;
    private TextView link_recuperar_cuenta;
    private TextView link_crear_cuenta;
    private CheckBox recordar_cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //find view
        editUser = (EditText) this.findViewById(R.id.et_login_username);
        editPass = (EditText) this.findViewById(R.id.et_login_password);
        btnLogin = (Button) this.findViewById(R.id.btn_login_login);
        progressBar = (ProgressBar) this.findViewById(R.id.progress_login);
        link_recuperar_cuenta = (TextView) this.findViewById(R.id.tv_login_olvidar_pwd);
        link_crear_cuenta = (TextView) this.findViewById(R.id.tv_login_crear_cuenta);
        recordar_cuenta = (CheckBox) this.findViewById(R.id.chk_login_recordar);

        //set listener
        btnLogin.setOnClickListener(this);
        link_recuperar_cuenta.setOnClickListener(this);
        link_crear_cuenta.setOnClickListener(this);

        //init
        presenter = new LoginPresenter(this, new LoginInteractor());

        //inicializa evento recordar cuenta
        //presenter.verificarSiCuentaRecordar();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_login:
                presenter.validateCredentials(editUser.getText().toString(), editPass.getText().toString(), recordar_cuenta.isChecked());
                break;
            case R.id.tv_login_olvidar_pwd:
                startActivity(new Intent(LoginActivity.this, RecoverAccountActivity.class));
                finish();
                break;
            case R.id.tv_login_crear_cuenta:
                startActivity(new Intent(LoginActivity.this, RegisterUsuarioActivity.class));
                finish();
                break;
        }
    }


    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
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
    public void setUsernameError() {
        editPass.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        editPass.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        finish();
    }

    @Override
    public void onClearText() {

    }

    @Override
    public void setError(String ErrorMessage) {
        Toast toast = Toast.makeText(this, ErrorMessage, Toast.LENGTH_SHORT);
        toast.show();
    }


}

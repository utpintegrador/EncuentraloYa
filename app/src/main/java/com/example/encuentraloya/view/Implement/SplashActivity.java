package com.example.encuentraloya.view.Implement;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.encuentraloya.R;
import com.example.encuentraloya.model.Implement.SplashInteractor;
import com.example.encuentraloya.presenter.SplashPresenter;
import com.example.encuentraloya.view.ISplashView;
import com.example.encuentraloya.view.Implement.HomeActivity;
import com.example.encuentraloya.view.Implement.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity implements ISplashView {
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(this, new SplashInteractor());

        final Activity activity = this;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
            presenter.validarExistenLogin();
                //startActivity(new Intent(activity, LoginActivity.class));
                //finish();
                //onDestroy();
            }
        }, 5000); //espera 5 segundos para a~adir un enemigo


    }

    @Override
    public void LogOn(boolean estado) {
        if(estado==true){
            startActivity(new Intent(this, HomeActivity.class));
        }else{
            startActivity(new Intent(this, LoginActivity.class));
        }
        finish();
    }

}

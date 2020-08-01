package com.example.encuentraloya.presenter;

import com.example.encuentraloya.model.Implement.SplashInteractor;
import com.example.encuentraloya.model.Interfaces.OnSplashFinishedListener;
import com.example.encuentraloya.view.ISplashView;

public class SplashPresenter implements OnSplashFinishedListener {
    ISplashView view;
    SplashInteractor interactor;

    public SplashPresenter(ISplashView view, SplashInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void validarExistenLogin(){
        if (view != null) {
        }
        interactor.validarExistenLogin(this);
    }

    @Override
    public void onLoginOn(boolean estado) {
        if (view != null) {
            view.LogOn(estado);
        }

    }


    }


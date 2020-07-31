package com.example.encuentraloya.presenter;

import com.example.encuentraloya.comun.Generico;
import com.example.encuentraloya.model.Interfaces.OnRegisterUsuarioFinishedListener;
import com.example.encuentraloya.model.Implement.RegisterUsuarioInteractor;
import com.example.encuentraloya.view.Interfaces.IRegisterUsuarioView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterUsuarioPresenter implements OnRegisterUsuarioFinishedListener {
    private IRegisterUsuarioView view;
    private RegisterUsuarioInteractor registerInteractor;

    public RegisterUsuarioPresenter(IRegisterUsuarioView registerView, RegisterUsuarioInteractor registerInteractor) {
        this.view = registerView;
        this.registerInteractor = registerInteractor;
    }

    public void registerUser(String nombre, String apellido, String correoElectronioco, String contrasenia,String confirmarContrasenia) {
        if (view != null) {
            view.showProgress();
        }


        if(nombre.isEmpty()){
            onNombreeError("El Nombre está vacío");
        }else if(apellido.isEmpty()){
            onApellidoError("El Apellido está vacío");
        }else if (correoElectronioco.isEmpty()){
            onCorreoElectronicoError("El Correo esta vacío");
        }else if(!Generico.ValidarMail(correoElectronioco)){
            onCorreoElectronicoError("El Correo no es válido");
        }else if(contrasenia.isEmpty()){
            onContraseniasError("La Contraseña esta vacía");
        }else if(contrasenia.length()<8){
            onContraseniasError("La Contraseña no es muy segura");
        }else if(confirmarContrasenia.isEmpty()) {
            onConfirmarContraseniasError("La Contraseña esta vacía");
        }else if(!contrasenia.equals(confirmarContrasenia)){
            onConfirmarContraseniasError("La Contraseña no coincide");
        }else{
            registerInteractor.registrar(nombre, apellido, correoElectronioco, contrasenia, this);
        }


    }

    @Override
    public void onCorreoElectronicoError(String message) {
        if (view != null) {
            view.setCorreoElectronicoError(message);
            view.hideProgress();
        }
    }

    @Override
    public void onNombreeError(String message) {
        if (view != null) {
            view.setNombreeError(message);
            view.hideProgress();
        }
    }

    @Override
    public void onApellidoError(String message) {
        if (view != null) {
            view.setApellidoError(message);
            view.hideProgress();
        }
    }

    @Override
    public void onContraseniasError(String message) {
        if (view != null) {
            view.setContraseniaError(message);
            view.hideProgress();
        }
    }

    @Override
    public void onConfirmarContraseniasError(String message) {
        if (view != null) {
            view.setConfirmarContraseniaError(message);
            view.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (view != null) {
            view.navigateToHome();
            view.hideProgress();
        }
    }

    @Override
    public void onError(String ErrorMessage) {
        view.setError(ErrorMessage);
        view.hideProgress();
    }
}

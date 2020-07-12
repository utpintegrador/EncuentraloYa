package com.example.encuentraloya.presenter;

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

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcherIsCorreoValido =pattern.matcher(correoElectronioco);

        if(nombre.isEmpty()){
            onNombreeError("Falta completar el nombre");
        }else if(apellido.isEmpty()){
            onApellidoError("Falta completar el apellido");
        }else if (correoElectronioco.isEmpty()){
            onCorreoElectronicoError("Falta completar el correo");
        }else if(!matcherIsCorreoValido.find()){
            onCorreoElectronicoError("El correo ingresado no es válido");
        }else if(contrasenia.isEmpty()){
            onContraseniasError("Falta completar la contraseña");
        }else if(contrasenia.length()<8){
            onContraseniasError("La longitud de la contraseña debe ser mayo o igual a 8");
        }else if(confirmarContrasenia.isEmpty()) {
            onConfirmarContraseniasError("Falta confirmar la contraseña");
        }else if(!contrasenia.equals(confirmarContrasenia)){
            onConfirmarContraseniasError("La contraseña no coincide");
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

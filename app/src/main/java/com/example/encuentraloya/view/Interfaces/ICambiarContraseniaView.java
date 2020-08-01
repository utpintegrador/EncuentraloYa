package com.example.encuentraloya.view.Interfaces;

public interface ICambiarContraseniaView {

    void showProgress();
    void hideProgress();
    void showMensage(String mensaje);
    void showSucces();
    void setErrorNewContrasenia(String mensaje);
    void setErrorConformarContrasenia(String mensaje);


}

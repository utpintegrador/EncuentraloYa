package com.example.encuentraloya.view.Interfaces;


public interface ILoginView {

    void showProgress();
    void hideProgress();

    void setUsernameError(String mensaje);
    void setPasswordError(String mensaje);
    void navigateToHome();
    void onClearText();
    void setError(String ErrorMessage);

}

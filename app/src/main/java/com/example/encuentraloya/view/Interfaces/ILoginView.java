package com.example.encuentraloya.view.Interfaces;


public interface ILoginView {

    void showProgress();
    void hideProgress();

    void setUsernameError();
    void setPasswordError();
    void navigateToHome();
    void onClearText();
    void setError(String ErrorMessage);

}

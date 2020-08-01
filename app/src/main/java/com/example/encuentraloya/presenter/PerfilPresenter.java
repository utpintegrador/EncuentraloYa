package com.example.encuentraloya.presenter;

import com.example.encuentraloya.model.Implement.PerfilInteractor;
import com.example.encuentraloya.model.Interfaces.OnPerfilFinishedListener;
import com.example.encuentraloya.view.Interfaces.IPerfilView;

public class PerfilPresenter  implements OnPerfilFinishedListener {
    private IPerfilView view;
    private PerfilInteractor interactor;

    public PerfilPresenter(IPerfilView view, PerfilInteractor interactor)  {
        this.view = view;
        this.interactor = interactor;
    }

    public void getPerfilData(){
        interactor.getPerfilData(this);
    }

    public void clearLocalData(){
        interactor.setClearSharedPreferences(this);
    }

    public void setImagenPerfil(String urlImagenPerfil){
        if (view != null) {
            view.showProgress();
        }
        interactor.SubirImagen(urlImagenPerfil,this);
    }

    @Override
    public void onSuccesGetPerfilData(String nombreCompleto, String correoElectronico,  String urlImagenPerfil ) {
        if (view != null) {
            view.hideProgress();
            view.showPerfilDatos(nombreCompleto,correoElectronico, urlImagenPerfil);
        }
    }

    @Override
    public void onCerrarSesion() {
        if (view != null) {
            view.showNavegationLogin();
        }
    }

    @Override
    public void onSuccesSaveImage(String urlImagen) {
        if (view != null) {
            view.showImagenPerfil(urlImagen);
        }
    }

    @Override
    public void onMensaje(String mensaje) {
        if (view != null) {
            view.hideProgress();
            view.showMensaje(mensaje);
        }
    }
}

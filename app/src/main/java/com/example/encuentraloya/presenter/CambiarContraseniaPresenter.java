package com.example.encuentraloya.presenter;

import com.example.encuentraloya.model.Implement.CambiarContraseniaInteractor;
import com.example.encuentraloya.model.Interfaces.OnCambiarContraseniaFinishedListener;
import com.example.encuentraloya.view.Interfaces.ICambiarContraseniaView;

public class CambiarContraseniaPresenter implements OnCambiarContraseniaFinishedListener {

    private ICambiarContraseniaView view;
    private CambiarContraseniaInteractor interactor;

    public CambiarContraseniaPresenter(ICambiarContraseniaView view, CambiarContraseniaInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public  void setContrasenia(String newContrasenia, String confirmContrasenoia){


        if(newContrasenia.isEmpty()){
            view.setErrorNewContrasenia("La nueva contraseña esta vacia");
        }else if(confirmContrasenoia.isEmpty()){
            view.setErrorConformarContrasenia("La confirmación de contraseña esta vacia");
        }else if(newContrasenia.length()<8){
            view.setErrorNewContrasenia("La contraseña debe ser mayo a 7 digitos");
        }else if(!newContrasenia.equals(confirmContrasenoia)){
            view.setErrorConformarContrasenia("No coinciden las contraseñas");
        }else{
            if (view != null) {
                view.showProgress();
            }
            interactor.setContrasenia(newContrasenia, this);
        }

    }

    @Override
    public void onShowMesaje(String mensaje) {
        if (view != null) {
            view.showMensage(mensaje);
            view.hideProgress();
        }
    }

    @Override
    public void onSucces() {
        if (view != null) {
            view.showSucces();
            view.hideProgress();
        }

    }
}

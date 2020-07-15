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

    @Override
    public void onSuccesGetPerfilData(String nombreCompleto, String correoElectronico) {
        if (view != null) {
            view.showPerfilDatos(nombreCompleto,correoElectronico);
        }
    }
}

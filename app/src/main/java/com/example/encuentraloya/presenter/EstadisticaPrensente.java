package com.example.encuentraloya.presenter;

import com.example.encuentraloya.model.Implement.EstadisticaInteractor;
import com.example.encuentraloya.model.Interfaces.OnEstadisticaFinishedListener;
import com.example.encuentraloya.view.Interfaces.IEstadisticaView;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class EstadisticaPrensente implements OnEstadisticaFinishedListener {
    IEstadisticaView view;
    EstadisticaInteractor interactor;

    public EstadisticaPrensente(IEstadisticaView view, EstadisticaInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void getEstadistiacBarra(){
        if (view != null) {
            view.showProgress();
        }
        interactor.getEstadistiacBarra(this);
    }

    @Override
    public void onEstadisticaBarra(ArrayList<BarEntry> values, ArrayList<String> labels) {
        if (view != null) {
            view.hideProgress();
            view.showEstadisticaBarra(values,labels);

        }
    }

    @Override
    public void onMessage(String message) {
        if (view != null) {
            view.showMessage(message);
            view.hideProgress();
        }
    }
}

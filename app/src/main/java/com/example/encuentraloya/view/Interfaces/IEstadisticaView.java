package com.example.encuentraloya.view.Interfaces;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public interface IEstadisticaView {
    void showProgress();
    void hideProgress();
    void showEstadisticaBarra(ArrayList<BarEntry> values, ArrayList<String> labels);
    void showMessage(String message);
}

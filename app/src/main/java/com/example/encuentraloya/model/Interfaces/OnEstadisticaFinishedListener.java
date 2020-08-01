package com.example.encuentraloya.model.Interfaces;

import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public interface OnEstadisticaFinishedListener {
    void onEstadisticaBarra(ArrayList<BarEntry> values, ArrayList<String> labels);
    void onMessage(String message);
}

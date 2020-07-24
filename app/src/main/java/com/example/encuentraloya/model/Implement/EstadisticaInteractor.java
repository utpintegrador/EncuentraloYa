package com.example.encuentraloya.model.Implement;


import com.example.encuentraloya.model.Interfaces.OnEstadisticaFinishedListener;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class EstadisticaInteractor {

    public void getEstadistiacBarra(final OnEstadisticaFinishedListener listener){

        final int[] a = {5,2,10,4,7,8,13};
        final String[] b= {"January","February","March","April","May","June","Jully"};
        final ArrayList<BarEntry> entries = new ArrayList<>();
        final ArrayList<String> labels = new ArrayList<String>();

        for(int i=0 ; i<5;i++){
            entries.add(new BarEntry(a[i],i));
            labels.add(b[i]);
        }

        listener.onEstadisticaBarra(entries,labels);
    }


}

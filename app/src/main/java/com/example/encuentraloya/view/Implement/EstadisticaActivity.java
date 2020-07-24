package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.encuentraloya.R;
import com.example.encuentraloya.model.Implement.EstadisticaInteractor;
import com.example.encuentraloya.presenter.EstadisticaPrensente;
import com.example.encuentraloya.view.Interfaces.IEstadisticaView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class EstadisticaActivity extends AppCompatActivity implements IEstadisticaView , View.OnClickListener {

    ImageButton btn_back;
    BarChart barChart;
    ProgressBar progressBar;

    EstadisticaPrensente prensenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        btn_back = (ImageButton) findViewById(R.id.btn_back);
        barChart =(BarChart) findViewById(R.id.barChart) ;
        progressBar =(ProgressBar)  this.findViewById(R.id.progress_estadistica);

        btn_back.setOnClickListener(this);

        prensenter = new EstadisticaPrensente(this, new EstadisticaInteractor());
        prensenter.getEstadistiacBarra();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showEstadisticaBarra(ArrayList<BarEntry> values, ArrayList<String> labels) {
        barChart.setVisibility(View.VISIBLE);
        BarDataSet dataset = new BarDataSet(values, "# Gasto general de los últimos 5 meses");
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.TOP);
        BarData data = new BarData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setDescription("");
        barChart.setData(data);
        barChart.animateY(3000);
    }

    @Override
    public void showMessage(String message) {
        Toast toast = Toast.makeText(this, message,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                startActivity(new Intent(this,PerfilActivity.class));
                finish();
                break;

        }
    }
}

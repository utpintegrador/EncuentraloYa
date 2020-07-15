package com.example.encuentraloya;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.encuentraloya.Servicios.BingApi;
import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.Key.ApiKeys;
import com.example.encuentraloya.comun.MyLocation;
import com.example.encuentraloya.entidad.Modal.Destination;
import com.example.encuentraloya.entidad.Modal.Point;
import com.example.encuentraloya.view.IMyLocation;
import com.example.encuentraloya.view.Implement.MyNegocioActivity;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.annotations.Annotation;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
//import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.geometry.LatLng;


import com.mapbox.mapboxsdk.views.MapView;
//import com.mapbox.mapboxsdk.views.MapView;



import retrofit2.Call;
import retrofit2.Callback;
//import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegistaraNegocioActivity extends AppCompatActivity
implements OnMapReadyCallback, IMyLocation , View.OnClickListener{

    EditText searchLocation;
    FloatingActionsMenu fabMenu;
    MapView mapView;
    //MapboxMap mapboxMap;

    Button btn_cancel;
    Button btn_guardar;

    double _point_latitud;
    double _point_longitud;


    InputMethodManager imm;
    public static final String ENDPOINT = "http://dev.virtualearth.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registara_negocio);

        btn_cancel = (Button) findViewById(R.id.btn_cancelar);
        btn_guardar = (Button) findViewById(R.id.btn_agregarUbicacion);

        btn_cancel.setOnClickListener(this);
        btn_guardar.setOnClickListener(this);


        //SI LA LATITUD ES 0, obtenemos nuestra ubicación
        if(Constantes.LATITUD_VALUE==0){
            MyLocation location = new MyLocation(this,this  );
        }



        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setStyleUrl(Style.MAPBOX_STREETS);

        //coordenata por default
        mapView.setCenterCoordinate(new LatLng(Constantes.LATITUD_VALUE, Constantes.LONGITUD_VALUE));
        mapView.addMarker(new MarkerOptions().position(new LatLng(Constantes.LATITUD_VALUE,
                Constantes.LONGITUD_VALUE)));


        mapView.setZoomLevel(16);
        mapView.onCreate(savedInstanceState);

       // fabMenu = (FloatingActionsMenu) findViewById(R.id.fab_menu);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        searchLocation = (EditText) findViewById(R.id.searchLocation);
        searchLocation.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    if (searchLocation.getText().toString().trim().length() != 0) {

                        Map<String, String> options = new HashMap<>();
                        options.put("q", searchLocation.getText().toString());
                        options.put("key", ApiKeys.BING_MAPS_KEY);

                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(ENDPOINT)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        BingApi api = retrofit.create(BingApi.class);

                        Call<Destination> destination = api.getCoordinates(options);
                        destination.enqueue(new Callback<Destination>() {

                            @Override
                            public void onResponse(Call<Destination> call, Response<Destination> response) {
                                Point point = response.body().getResourceSets().get(0)
                                        .getResources().get(0).getPoint();

                                //mapView.addMarker(new MarkerOptions().position(new LatLng(point.getCoordinates().get(0),
                                //        point.getCoordinates().get(1))));

                                mapView.setCenterCoordinate(new LatLng(point.getCoordinates().get(0),
                                        point.getCoordinates().get(1)));
                            }

                            @Override
                            public void onFailure(Call<Destination> call, Throwable t) {

                            }
                        });

                        imm.hideSoftInputFromWindow(searchLocation.getWindowToken(), 0);
                        return true;
                    } else {
                        Toast.makeText(getBaseContext(), "Enter location", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });


    mapView.setOnMapClickListener(new MapView.OnMapClickListener() {
        @Override
        public void onMapClick(@NonNull LatLng point) {

            //remove marcadores
            mapView.removeAllAnnotations();

            //agrega marcadores
            mapView.addMarker(new MarkerOptions().position(new LatLng(point.getLatitude(),
                    point.getLongitude())));

            _point_latitud=point.getLatitude();
            _point_longitud=point.getLongitude();

        }
    });



    }

    public void enterLocation(View view) {
        fabMenu.collapse();
        searchLocation.requestFocus();
        imm.showSoftInput(searchLocation, InputMethodManager.SHOW_IMPLICIT);
    }

    public void selectStyle(View view) {
        fabMenu.collapse();
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setItems(new CharSequence[]{"Streets", "Emerald", "Dark", "Light",
                "Satellite"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    mapView.setStyle(Style.MAPBOX_STREETS);
                } else if (i == 1) {
                    mapView.setStyle(Style.EMERALD);
                } else if (i == 2) {
                    mapView.setStyle(Style.DARK);
                } else if (i == 3) {
                    mapView.setStyle(Style.LIGHT);
                } else {
                    mapView.setStyle(Style.SATELLITE);
                }
            }
        });
        dialogBuilder.create().show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    @Override
    public void showMyLocation() {
        //remove marcadores
        mapView.removeAllAnnotations();

        //agrega marcadores
        mapView.setCenterCoordinate(new LatLng(Constantes.LATITUD_VALUE, Constantes.LONGITUD_VALUE));
        mapView.addMarker(new MarkerOptions().position(new LatLng(Constantes.LATITUD_VALUE,
                Constantes.LONGITUD_VALUE)));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancelar:
                Constantes.RETURN_MAP_LATITUD=0;
                Constantes.RETURN_MAP_LONGITUD=0;
                //startActivity(new Intent(this, MyNegocioActivity.class));
                finish();
                break;
            case R.id.btn_agregarUbicacion:
                Constantes.RETURN_MAP_LATITUD=_point_latitud;
                Constantes.RETURN_MAP_LONGITUD=_point_longitud;
                //startActivity(new Intent(this,MyNegocioActivity.class));
                finish();
                break;
        }
    }
}

package com.example.encuentraloya.comun;

public class Constantes {

    //region Preferencias
    public static  final String PREF_RECORDAR_ACCESO = "PREF_RECORDAR_ACCESO";

    public static final String PREF_TOKEN = "PREF_TOKEN";
    public static final String PREF_IDUSUARIOAUTENTICADO = "PREF_IDUSUARIOAUTENTICADO";
    public static final String PREF_NOMBRE = "PREF_NOMBRE";
    public static final String PREF_APELLIDO = "PREF_APELLIDO";
    public static final String PREF_CORREOELECTRONICO = "PREF_CORREOELECTRONICO";
    public static final String PREF_URLIMAGENUSUARIO = "PREF_URLIMAGENUSUARIO";
    public static final String PREF_USERNAME = "PREF_USERNAME";
    //endregion

    //region negocio
    public static final String PREF_IDNEGOCIO ="PREF_IDNEGOCIO";
    public static final String PREF_NOMBRENEGOCIO ="PREF_NOMBRENEGOCIO";
    public static final String PREF_ID_UBICACION_NEGOCIO ="PREF_ID_UBICACION_NEGOCIO";
    public static final String PREF_TITULO_NEGOCIO ="PREF_TITULO_NEGOCIO";
    public static final String PREF_DESCRIPCION_NEGOCIO ="PREF_DESCRIPCION_NEGOCIO";
    public static final String PREF_LATITUD_NEGOCIO ="PREF_LATITUD_NEGOCIO";
    public static final String PREF_LONGITUD_NEGOCIO ="PREF_LONGITUD_NEGOCIO";
    //endregion negocio

    //TIENDA SELECCIONADA
    public static final String PREF_SELECTED_ID_NEGOCIO="PREF_SELECTED_ID_NEGOCIO";


    //poins
    public static double LATITUD_VALUE;
    public static double LONGITUD_VALUE;
    public static double RETURN_MAP_LATITUD;
    public static double RETURN_MAP_LONGITUD;


    //

    //LOCATION
    public static final int SUCCESS_RESULT = 1;
    public static final int FAILURE_RESULT = 0;
    public static final String PACKAGE_NAME =
            "com.google.android.gms.location.sample.locationaddress";
    public static final String RECEIVER = PACKAGE_NAME + ".RECEIVER";
    public static final String RESULT_DATA_KEY = PACKAGE_NAME +
            ".RESULT_DATA_KEY";
    public static final String LOCATION_DATA_EXTRA = PACKAGE_NAME +
            ".LOCATION_DATA_EXTRA";


    //POSICION DE TIENDA SELECCIONADA
    public static int SELECTED_POSITION_ACTUAL_RV=-1;
    public static int SELECTED_CHANGE_NEGOCIO=0;


    //NOMBRE DATABASE
    public static final String DATABASE_NAME="DBENCUENTRALOYA";


}

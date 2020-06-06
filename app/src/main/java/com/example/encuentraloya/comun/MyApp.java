package com.example.encuentraloya.comun;

import android.app.Application;
import android.content.Context;

/*Retorna el contexto de la aplicacion*/
/*En el Manifest se declara este objeto*/
public class MyApp extends Application {
    private static MyApp instance;
    public static MyApp getInstance(){
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}

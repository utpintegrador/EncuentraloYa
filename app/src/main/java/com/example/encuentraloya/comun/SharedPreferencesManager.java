package com.example.encuentraloya.comun;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    private static final String APP_SETTINGS_FILE = "APP_SETTINGS";

    private SharedPreferencesManager(){}

    private static SharedPreferences getSharedPreferences(){
        return MyApp.
                getContext().
                getSharedPreferences(APP_SETTINGS_FILE, Context.MODE_PRIVATE);
    }

    public static void setStringValue(String etiqueta, String valor){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(etiqueta, valor);
        editor.commit();
    }

    public static void setBooleanValue(String etiqueta, boolean valor){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(etiqueta, valor);
        editor.commit();
    }

    public static void setIntValue(String etiqueta, int valor){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putInt(etiqueta, valor);
        editor.commit();
    }


    public static String getStringValue(String etiqueta){
        return getSharedPreferences().getString(etiqueta, null);
    }

    public static Boolean getBooleanValue(String etiqueta){
        return getSharedPreferences().getBoolean(etiqueta, false);
    }

    public static int getIntValue(String etiqueta){
        return getSharedPreferences().getInt(etiqueta, 0);
    }
}

package com.example.encuentraloya.Servicios;

import com.example.encuentraloya.comun.Constantes;
import com.example.encuentraloya.comun.SharedPreferencesManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {

            //OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
            //okHttpClientBuilder.addInterceptor(new AuthInterceptor());
            //OkHttpClient cliente = okHttpClientBuilder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}


class AuthInterceptor implements Interceptor
{
    @Override
    public Response intercept(Chain chain) throws IOException
    {
        String token = SharedPreferencesManager.getStringValue(Constantes.PREF_TOKEN);
        Request request = chain.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer " + token).build();
        return chain.proceed(request);
    }
}
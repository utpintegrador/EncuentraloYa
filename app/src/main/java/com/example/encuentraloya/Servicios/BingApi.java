package com.example.encuentraloya.Servicios;
import com.example.encuentraloya.entidad.Modal.Destination;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface BingApi {
    @GET("/REST/v1/Locations")
    Call<Destination> getCoordinates(@QueryMap Map<String, String> options);
}

package com.example.encuentraloya.Servicios;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://api-find.control-zeta.net/api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}

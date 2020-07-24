package com.example.encuentraloya.Servicios;

public class ApiUtils {
    private ApiUtils() {}

    //http://api-find.control-zeta.net/api/
    //https://api-find.control-zeta.net/api/
    public static final String BASE_URL = "https://api-find.control-zeta.net/api/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
    public static IUbicacionNegocioService getAPIServiceaUbicacionNegocio() {
        return RetrofitClient.getClient(BASE_URL).create(IUbicacionNegocioService.class);
    }

    public static  INegocioService getAPIServiceNegocio(){
        return RetrofitClient.getClient(BASE_URL).create(INegocioService.class);
    }

    public  static IUsuarioService getAPIUsuarioService(){
        return  RetrofitClient.getClient(BASE_URL).create(IUsuarioService.class);
    }

    public static IPedidoService getAPIPedidoService(){
        return RetrofitClient.getClient(BASE_URL).create(IPedidoService.class);
    }

    public static IDetallePedidoService getApiDetallePedido(){
        return RetrofitClient.getClient(BASE_URL).create(IDetallePedidoService.class);
    }

    public static IProductService getAPIServiceProduct(){
        return RetrofitClient.getClient(BASE_URL).create(IProductService.class);
    }

}

package com.example.encuentraloya.comun;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.encuentraloya.entidad.DetallePedidoDto;
import com.example.encuentraloya.entidad.ProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PedidoSQLite extends SQLiteOpenHelper {

    public PedidoSQLite(Context context) {
         super(context, Constantes.DATABASE_NAME, null, 1);
        SQLiteDatabase db = getWritableDatabase();
        onCreate(db);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL("CREATE TABLE TBPEDIDOS ("+
                    "idPedido INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "idProducto INTEGER , " +
                    "cantidad REAL , " +
                    "descripcion TEXT , " +
                    "precio REAL,  " +
                    "UrlImagen TEXT,  " +
                    "idNegocio INTEGER  " +
                    ")");
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // En caso de una nueva versión habría que actualizar las tablas

    }

    public  boolean agregarProducto(int idProducto, double cantidad, String descripcion, double precio, String urlImagen ){
        boolean response = false;
        try{
            SQLiteDatabase db = getWritableDatabase();

            if (existeProducto(idProducto, db)){ //
                db.execSQL("UPDATE TBPEDIDOS SET cantidad=cantidad+" + cantidad + " WHERE idProducto=" + idProducto);
            }else{
                int idNegocio = SharedPreferencesManager.getIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO);
                db.execSQL("INSERT INTO TBPEDIDOS VALUES ( null,"+ idProducto + "," +
                        cantidad+", '"+descripcion+"', "+precio+",'"+  urlImagen +"',"+ idNegocio + ")");
            }

            db.close();
            response=true;
        }catch (Exception e){
            response=false;
        }
        return response;
    }

    public  boolean actualizarProducto(int idPedido, double cantidad){
        boolean response = false;
        try{
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("UPDATE TBPEDIDOS SET cantidad=" + cantidad +" WHERE idPedido="+idPedido);

            db.close();
            response=true;
        }catch (Exception e){
            response=false;
        }
        return response;
    }

    public  boolean eliminarProducto(int idPedido){
        boolean response = false;
        try{
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("DELETE FROM TBPEDIDOS  WHERE idPedido="+idPedido);

            db.close();
            response=true;
        }catch (Exception e){
            response=false;
        }
        return response;
    }

    public  boolean eliminarTodoProducto(){
        boolean response = false;
        try{
            int idNegocio = SharedPreferencesManager.getIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO);
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("DELETE FROM TBPEDIDOS WHERE idNegocio=" + idNegocio);

            db.close();
            response=true;
        }catch (Exception e){
            response=false;
        }
        return response;
    }

    public List<ProductDto> ListarProductos() {
        Vector result = new Vector();
        List<ProductDto> lista = new ArrayList<>();

        int idNegocio = SharedPreferencesManager.getIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT idPedido, idProducto,cantidad,descripcion,precio,UrlImagen  FROM TBPEDIDOS WHERE idNegocio =" + idNegocio , null);

        while (cursor.moveToNext()){
            ProductDto entity = new ProductDto();

            entity.setIdPedido(cursor.getInt(0));
            entity.setIdProduct(cursor.getInt(1));
            entity.setCantidad(cursor.getDouble(2));
            entity.setDescriptionProduct(cursor.getString(3));
            entity.setPrice(cursor.getDouble(4));
            entity.setUrlImage(cursor.getString(5));
            lista.add(entity);
            entity = null;
         }

        cursor.close();
        db.close();

        return  lista;
    }

    public List<DetallePedidoDto> ListarDetalleProductos() {
        Vector result = new Vector();
        List<DetallePedidoDto> lista = new ArrayList<>();

        int idNegocio = SharedPreferencesManager.getIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO);

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT idPedido, idProducto,cantidad,descripcion,precio,UrlImagen  FROM TBPEDIDOS WHERE idNegocio=" + idNegocio, null);

        while (cursor.moveToNext()){
            DetallePedidoDto entity = new DetallePedidoDto();
            entity.setIdProducto(cursor.getInt(1));
            entity.setCantidad(cursor.getInt(2));
            entity.setPrecioUnitario(cursor.getDouble(4));
            lista.add(entity);
            entity = null;
        }

        cursor.close();
        db.close();

        return  lista;
    }


    public boolean existeProducto(int idProducto,SQLiteDatabase db) {
        boolean existe = false;
        int idNegocio = SharedPreferencesManager.getIntValue(Constantes.PREF_SELECTED_ID_NEGOCIO);

        Cursor cursor = db.rawQuery("SELECT  idProducto  FROM TBPEDIDOS where idProducto="+ idProducto + " AND idNegocio="+idNegocio, null);
        while (cursor.moveToNext()){
            existe=true;
        }
        cursor.close();
        return  existe;
    }

}

package com.example.encuentraloya.comun;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.encuentraloya.entidad.ProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PedidoSQLite extends SQLiteOpenHelper {

    public PedidoSQLite(Context context) {
         super(context, Constantes.DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TBPEDIDO ("+
                "idPedido INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "idProducto INTEGER , " +
                "cantidad REAL , " +
                "descripcion TEXT , " +
                "precio REAL,  " +
                "UrlImagen TEXT  " +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // En caso de una nueva versión habría que actualizar las tablas
    }


    public  boolean agregarProducto(int idProducto, double cantidad, String descripcion, double precio, String urlImagen ){
        boolean response = false;
        try{
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("INSERT INTO TBPEDIDO VALUES ( null,"+ idProducto + "," +
                    cantidad+", '"+descripcion+"', "+precio+","+  urlImagen +")");
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
            db.execSQL("UPDATE TBPEDIDO SET cantidad=" + cantidad +" WHERE idPedido="+idPedido);

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
            db.execSQL("DELETE FROM TBPEDIDO  WHERE idPedido="+idPedido);

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

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT idPedido, idProducto,cantidad,descripcion,precio,UrlImagen  FROM TBPEDIDO", null);

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
/**         ls
            result.add(cursor.getInt(0)+" "
                    +cursor.getString(1));**/


        }

        cursor.close();
        db.close();

        return  lista;
    }


}

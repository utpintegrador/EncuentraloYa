package com.example.encuentraloya.view.Implement;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.encuentraloya.R;
import com.example.encuentraloya.comun.Generico;
import com.example.encuentraloya.entidad.CategoriaDto;
import com.example.encuentraloya.model.Implement.PerfilInteractor;
import com.example.encuentraloya.presenter.PerfilPresenter;
import com.example.encuentraloya.view.Interfaces.IHomeView;
import com.example.encuentraloya.view.Interfaces.IPerfilView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.File;
import java.util.List;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener , IPerfilView {
    PerfilPresenter presenter;

    Button navegation_inicio;
    Button navegation_buscar;
    Button navegation_carrito;
    Button navegation_perfil;

    LinearLayout btn_mi_negocio;
    LinearLayout btn_mi_pedido;
    LinearLayout btn_mi_estadistica;
    LinearLayout btn_mi_cambio_pwd;
    LinearLayout btn_cerrar_sesion;

    TextView etNombreCompleto;
    TextView etCorreoElectronico;
    ImageView imgPerfil;
    ProgressBar progress_perfil;

    ImageButton btn_agregarFoto;

    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        etNombreCompleto=(TextView) this.findViewById(R.id.et_NombreCompleto);
        etCorreoElectronico=(TextView) this.findViewById(R.id.et_CorreoElectronico);
        imgPerfil = (ImageView)this.findViewById(R.id.imgPerfil);
        btn_agregarFoto = (ImageButton) this.findViewById(R.id.btn_agregarFoto);
        progress_perfil = (ProgressBar) findViewById(R.id.progress_perfil);

        navegation_inicio =(Button) this.findViewById(R.id.btn_inicio);
        navegation_buscar=(Button) this.findViewById(R.id.btn_buscar);
        navegation_carrito=(Button) this.findViewById(R.id.btn_carrito);
        navegation_perfil =(Button) this.findViewById(R.id.btn_perfil);

        btn_mi_negocio = (LinearLayout) findViewById(R.id.Ly_mi_negocio);
        btn_mi_pedido = (LinearLayout) findViewById(R.id.Ly_mi_pedido);
        btn_mi_estadistica = (LinearLayout) findViewById(R.id.Ly_mi_estadistica);
        btn_mi_cambio_pwd = (LinearLayout) findViewById(R.id.Ly_mi_actualizar_pwd);
        btn_cerrar_sesion = (LinearLayout) findViewById(R.id.Ly_cerrar_sesion);

        //listener
        navegation_inicio.setOnClickListener(this);
        navegation_buscar.setOnClickListener(this);
        navegation_carrito.setOnClickListener(this);
        navegation_perfil.setOnClickListener(this);

        btn_mi_negocio.setOnClickListener(this);
        btn_mi_pedido.setOnClickListener(this);
        btn_mi_estadistica.setOnClickListener(this);
        btn_mi_cambio_pwd.setOnClickListener(this);
        btn_cerrar_sesion.setOnClickListener(this);

        btn_agregarFoto.setOnClickListener(this);



        //init
        presenter = new PerfilPresenter(this, new PerfilInteractor());
        presenter.getPerfilData();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_inicio:
                startActivity(new Intent(this,HomeActivity.class));
                finish();
                break;
            case R.id.btn_buscar:
                startActivity(new Intent(this,BuscarProductoActivity.class));
                finish();
                break;
            case R.id.btn_carrito:
                startActivity(new Intent(this,CarritoActivity.class));
                finish();
                break;
            case R.id.btn_perfil:
                startActivity(new Intent(this,PerfilActivity.class));
                finish();
                break;

            case R.id.Ly_mi_negocio:
                startActivity(new Intent(this,MyNegocioActivity.class));
                finish();
                break;

            case R.id.Ly_mi_pedido:
                startActivity(new Intent(this,MisPedidoActivity.class));
                finish();
                break;

            case R.id.Ly_mi_estadistica:
                startActivity(new Intent(this,EstadisticaActivity.class));
                finish();
                break;

            case R.id.Ly_mi_actualizar_pwd:
                startActivity(new Intent(this,CambiarContraseniaActivity.class));
                finish();
                break;

            case R.id.Ly_cerrar_sesion:
                presenter.clearLocalData();
                //finish();
                break;
            case R.id.btn_agregarFoto:
                // in onCreate or any event where your want the user to
                // select a file
              /*  Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Seleccionar Imagen"), SELECT_PICTURE);*/
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);

                break;


        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data){

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();

                imgPerfil.setVisibility(View.GONE);
                presenter.setImagenPerfil(picturePath);

        }
    }

    @Override
    public void showProgress() {
        progress_perfil.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress_perfil.setVisibility(View.GONE);
    }

    @Override
    public void showPerfilDatos(String nombreCompleto, String correoElectronico,  String urlImagenPerfil) {
        etNombreCompleto.setText(nombreCompleto);
        etCorreoElectronico.setText(correoElectronico);
        Picasso.with(this).load(urlImagenPerfil).into(imgPerfil);
    }

    @Override
    public void showNavegationLogin() {
        startActivity(new Intent(this,LoginActivity.class));
    }

    @Override
    public void showImagenPerfil(String urlImagenPerfil) {
        Picasso.with(this).load(urlImagenPerfil).into(imgPerfil);
        imgPerfil.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMensaje(String mensaje) {
        Toast toast = Toast.makeText(this, mensaje,Toast.LENGTH_SHORT);
        toast.show();
    }
}

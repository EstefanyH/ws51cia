package com.hache.appentrepatas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hache.appentrepatas.helper.VeterinariaContract;
import com.hache.appentrepatas.helper.VeterinariaDB;
import com.hache.appentrepatas.util.General;

public class SingupActivity extends AppCompatActivity implements View.OnClickListener {

    Button register_btn;
    EditText correo, password, repassword, nombre, apellido, telefono;
    Intent intent;
    long newRowId;
    VeterinariaDB dbHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        correo = (EditText) findViewById(R.id.et_mail);
        password = (EditText) findViewById(R.id.et_pass);
        repassword = (EditText) findViewById(R.id.et_repass);
        nombre = (EditText) findViewById(R.id.et_nombre);
        apellido = (EditText) findViewById(R.id.et_apellido);
        telefono = (EditText) findViewById(R.id.et_telefono);

        register_btn = (Button) findViewById(R.id.btn_singup_register);
        register_btn.setOnClickListener(this);
        dbHelper = new VeterinariaDB(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_singup_register:
                if (validarRegistro()) {
                    /*crearUsuario();
                    if (newRowId > 0) {
                        Toast.makeText(this, getString(R.string.msg_registro_exito), Toast.LENGTH_LONG).show();
                        intent = new Intent(this, LoginActivity.class);
                        startActivity(intent);
                    } */

                    Toast.makeText(this, getString(R.string.msg_registro_exito), Toast.LENGTH_LONG).show();
                    intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }
            default:
                break;
        }
    }

    Boolean validarRegistro() {
        if (correo.getText().toString().trim().length() == 0) {
            Toast.makeText(this, getString(R.string.msg_registro_mail), Toast.LENGTH_LONG).show();
            return false;
        }

        if (!General.validarMail(correo.getText().toString())) {
            Toast.makeText(this, getString(R.string.msg_registro_valMail), Toast.LENGTH_LONG).show();
            return false;
        }

        if (password.getText().toString().trim().length() == 0) {
            Toast.makeText(this, getString(R.string.msg_registro_password), Toast.LENGTH_LONG).show();
            return false;
        }
        if (repassword.getText().toString().trim().length() == 0) {
            Toast.makeText(this, getString(R.string.msg_registro_repasswod), Toast.LENGTH_LONG).show();
            return false;
        }

        if (!password.getText().toString().equals(repassword.getText().toString())) {
            Toast.makeText(this, getString(R.string.msg_registro_valPass), Toast.LENGTH_LONG).show();
            return false;
        }

        if (nombre.getText().toString().trim().length() == 0) {
            Toast.makeText(this, getString(R.string.msg_registro_nombre), Toast.LENGTH_LONG).show();
            return false;
        }
        if (apellido.getText().toString().trim().length() == 0) {
            Toast.makeText(this, getString(R.string.msg_registro_apellido), Toast.LENGTH_LONG).show();
            return false;
        }
        if (telefono.getText().toString().trim().length() == 0) {
            Toast.makeText(this, getString(R.string.msg_registro_telefono), Toast.LENGTH_LONG).show();
            return false;
        }
        if (telefono.getText().toString().trim().length() != 9) {
            Toast.makeText(this, getString(R.string.msg_registro_format_telefono), Toast.LENGTH_LONG).show();
            return false;
        }


        return true;
    }

    void crearUsuario() {

        try{
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(VeterinariaContract.UsuarioEntry.COLUMN_NAME_CORREO, correo.getText().toString().trim());
            values.put(VeterinariaContract.UsuarioEntry.COLUMN_NAME_PASSWORD, password.getText().toString().trim());
            values.put(VeterinariaContract.UsuarioEntry.COLUMN_NAME_TIPO_USUARIO, "1");
            values.put(VeterinariaContract.UsuarioEntry.COLUMN_NAME_NOMBRE, nombre.getText().toString().trim());
            values.put(VeterinariaContract.UsuarioEntry.COLUMN_NAME_PATERNO, apellido.getText().toString().trim());
            values.put(VeterinariaContract.UsuarioEntry.COLUMN_NAME_CELULAR, telefono.getText().toString().trim());
            values.put(VeterinariaContract.UsuarioEntry.COLUMN_NAME_ESTADO, "1");
// Insert the new row, returning the primary key value of the new row
            newRowId = db.insert(VeterinariaContract.UsuarioEntry.TABLE_NAME, null, values);
        }
        catch (Exception ex){
            System.out.println("Error de registro SQLLite ");
            System.out.println("Mensaje: "+ ex.getMessage());
            Toast.makeText(this, getString(R.string.msg_error_ocurrio),Toast.LENGTH_LONG).show();
        }
    }
}
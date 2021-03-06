package com.hache.appentrepatas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.PortUnreachableException;

public class VeterinariaDB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Veterinaria.db";

    public VeterinariaDB(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + VeterinariaContract.UsuarioEntry.TABLE_NAME + " (" +
                    VeterinariaContract.UsuarioEntry._ID + " INTEGER  PRIMARY KEY AUTOINCREMENT," +
                    VeterinariaContract.UsuarioEntry.COLUMN_NAME_CORREO + " TEXT," +
                    VeterinariaContract.UsuarioEntry.COLUMN_NAME_PASSWORD + " TEXT," +
                    VeterinariaContract.UsuarioEntry.COLUMN_NAME_TIPO_USUARIO + " TEXT," +
                    VeterinariaContract.UsuarioEntry.COLUMN_NAME_NOMBRE + " TEXT," +
                    VeterinariaContract.UsuarioEntry.COLUMN_NAME_PATERNO + " TEXT," +
                    VeterinariaContract.UsuarioEntry.COLUMN_NAME_CELULAR + " TEXT," +
                    VeterinariaContract.UsuarioEntry.COLUMN_NAME_ESTADO + " TEXT)";



    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + VeterinariaContract.UsuarioEntry.TABLE_NAME;
}

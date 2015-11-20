package br.edu.ifspsaocarlos.sdm.trabalhofinal.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Leonardo on 20/09/13.
 */
public class SaveGameDB extends SQLiteOpenHelper {

    public static final String DEFAULT_USER = "DEFAULT_USER";
    public static final String COLUMN_USER = "user";
    public static final String COLUMN_FASE = "fase";
    public static final String TABELA = "savegames";
    private static final String DATABASE_NAME = "savegames.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQLCREATETABLE = "CREATE TABLE " + TABELA +
            "( " +
            COLUMN_USER +" TEXT PRIMARY KEY NOT NULL," +
            COLUMN_FASE +" INTEGER " +
            ");";
    private static final String SQLDROPTABLE = "DROP TABLE IF EXISTS " + TABELA + ";";

    public SaveGameDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCREATETABLE);
        ContentValues valores = new ContentValues();
        valores.put(COLUMN_USER, DEFAULT_USER);
        valores.put(COLUMN_FASE, 0);
        db.insert(TABELA, null, valores);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(SaveGameDB.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL(SQLDROPTABLE);
        this.onCreate(db);
    }


}

package br.edu.ifspsaocarlos.sdm.trabalhofinal.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.edu.ifspsaocarlos.sdm.trabalhofinal.db.SaveGameDB;
import br.edu.ifspsaocarlos.sdm.trabalhofinal.model.SaveGame;

/**
 * Created by Leonardo on 19/09/13.
 */
public class SaveGameDAO {

    private static final String WHERE = "user=" + SaveGameDB.DEFAULT_USER;
    private String[] allColumns = { SaveGameDB.COLUMN_USER, SaveGameDB.COLUMN_FASE };
    private final SaveGameDB saveGameDB;
    private static SQLiteDatabase database;

    public SaveGameDAO(Context context){
        saveGameDB = new SaveGameDB(context);
        database = saveGameDB.getWritableDatabase();
    }

    private void close() {
        saveGameDB.close();
    }

    public void remover(SaveGame saveGame) {

            String user = saveGame.getUser();
            System.out.println("User deleted: " + user);
            database.delete(SaveGameDB.TABELA, SaveGameDB.COLUMN_USER
                    + " = " + saveGame.getUser(), null);
    }

    public void inserir(SaveGame saveGame){
            ContentValues valores = new ContentValues();
            valores.put(SaveGameDB.COLUMN_USER, saveGame.getUser());
            valores.put(SaveGameDB.COLUMN_FASE, saveGame.getFase());
            database.insert(SaveGameDB.TABELA, null, valores);
    }

    public void alterar(SaveGame saveGame){
            ContentValues valores = new ContentValues();
            valores.put(SaveGameDB.COLUMN_FASE, new Integer(saveGame.getFase()).toString());
            String strFilter = SaveGameDB.COLUMN_USER +" = '" + SaveGameDB.DEFAULT_USER + "'";

            database.update(SaveGameDB.TABELA, valores, strFilter, null);
            //this.close();
    }

    public SaveGame getSavedGames(SaveGame saveGame){
        //String where = SaveGameDB.COLUMN_USER + " = " + saveGame.getUser();

        Cursor c = database.query(SaveGameDB.TABELA, allColumns, null, null, null, null, null);
        c.moveToNext();
        saveGame = cursorToSaveGame(c);
        c.close();
        //this.close();
        return saveGame;
    }

    private SaveGame cursorToSaveGame(Cursor cursor) {
        SaveGame saveGame = new SaveGame();
        saveGame.setUser(cursor.getString(0));
        saveGame.setFase(cursor.getInt(1));
        return saveGame;
    }
}

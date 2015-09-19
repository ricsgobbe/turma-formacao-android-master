package br.com.cast.turmaformacao.taskmanager.model.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.cast.turmaformacao.taskmanager.util.ApplicationUtil;

/**
 * Created by Administrador on 16/09/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "taskmanager";
    private static final int DATABASE_VERSION = 1;

    private DatabaseHelper(Context context ){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance(){
        return new DatabaseHelper(ApplicationUtil.getContext());
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LabelContract.getCreateTableScript());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package br.com.cast.turmaformacao.taskmanager.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entidade.Label;
import br.com.cast.turmaformacao.taskmanager.model.servicos.LabelBusinessServices;

/**
 * Created by Administrador on 17/09/2015.
 */
public class LabelRepository {

    public LabelRepository() {
        super();
    }

    public static void save(Label label) {
        /*1-Qual � o banco de dados "context"*/
        /*2- getInstance retorna um objeto databasehelper, semelhante a uma factory method*/
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = LabelContract.getContentValues(label);
        if (label.getId() == null) {
        /*Passando por parametro o task, onde o metodo contentValues vai retornar os valores do objeto */
            db.insert(LabelContract.TABLE, null, LabelContract.getContentValues(label));
        } else {
            String where = LabelContract.ID + " = ? ";
            String[] params = {label.getId().toString()};
            db.update(LabelContract.TABLE, values, where, params);
        }
        db.close();
        databaseHelper.close();

    }

    public static List<Label> getAll() {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();


        Cursor cursor = db.query(LabelContract.TABLE, LabelContract.COLUNSLABEL, null, null, null, null, LabelContract.ID);
        List<Label> labels = LabelContract.getLabels(cursor);
        db.close();
        databaseHelper.close();
        return labels;
    }

    public static void delete(long id) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = LabelContract.ID + " = ? ";
        String[] params = {String.valueOf(id)};
        db.delete(LabelContract.TABLE, where, params);

        db.close();
        databaseHelper.close();
    }

    public static Label getLabel(Long id){
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = LabelContract.ID + " = ? ";
        String[] params = {String.valueOf(id)};
        Cursor cursor = db.query(LabelContract.TABLE, LabelContract.COLUNSLABEL, where, params, null, null, null);

        databaseHelper.close();
        db.close();
        return LabelContract.getLabel(cursor);
    }


}

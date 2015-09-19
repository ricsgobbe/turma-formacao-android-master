package br.com.cast.turmaformacao.taskmanager.model.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entidade.Task;

/**
 * Created by Administrador on 16/09/2015.
 */

/*Classe DAO*/
public final class TaskRepository {

    private TaskRepository(){
        super();
    }

    public static void save(Task task){
        /*1-Qual � o banco de dados "context"*/
        /*2- getInstance retorna um objeto databasehelper, semelhante a uma factory method*/
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = TaskContract.getContentValues(task);
        if(task.getId() == null) {
        /*Passando por parametro o task, onde o metodo contentValues vai retornar os valores do objeto */
            db.insert(TaskContract.TABLE, null, values);
        } else {
            String where = TaskContract.ID + " = ? ";
            String[] params = {task.getId().toString()};
            db.update(TaskContract.TABLE, values, where, params);
        }
        db.close();
        databaseHelper.close();

    }

    public static List<Task> getAll(){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();


        Cursor cursor = db.query(TaskContract.TABLE, TaskContract.COLUNS, null, null, null, null, TaskContract.ID);
        List<Task> tarefas = TaskContract.getTasks(cursor);
        db.close();
        databaseHelper.close();
        return tarefas;
    }

    public static void delete(long id){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = TaskContract.ID + " = ? ";
        String[] params = {String.valueOf(id)};
        db.delete(TaskContract.TABLE, where, params);

        db.close();
        databaseHelper.close();
    }

}

package br.com.cast.turmaformacao.taskmanager.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entidade.Task;
import br.com.cast.turmaformacao.taskmanager.model.entidade.User;


/**
 * Created by eu.nicekuba on 22/09/2015.
 */
public class UserRepository {

    public UserRepository() {
        super();
    }

    public static void save(User user){
        /*1-Qual � o banco de dados "context"*/
        /*2- getInstance retorna um objeto databasehelper, semelhante a uma factory method*/
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = UserContract.getContentValues(user);
        if(user.getId() == null) {
        /*Passando por parametro o task, onde o metodo contentValues vai retornar os valores do objeto */
            db.insert(UserContract.TABLE, null, values);
        } else {
            String where = UserContract.ID + " = ? ";
            String[] params = {user.getId().toString()};
            db.update(UserContract.TABLE, values, where, params);
        }
        db.close();
        databaseHelper.close();

    }


    public static List<User> getAll(){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();


        Cursor cursor = db.query(UserContract.TABLE, UserContract.COLUNS, null, null, null, null, UserContract.ID);
        List<User> tarefas = UserContract.getUsers(cursor);
        db.close();
        databaseHelper.close();
        return tarefas;
    }


    public static void delete(long id){
        DatabaseHelper databaseHelper =DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = UserContract.ID + " = ? ";
        String[] params = {String.valueOf(id)};
        db.delete(UserContract.TABLE, where, params);

        db.close();
        databaseHelper.close();
    }

    public static User selectLogin(User user){
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String where = UserContract.NOME + " = ?  AND "+ UserContract.SENHA + "  = ? ";
        String[] params ={String.valueOf(user.getNome()), String.valueOf(user.getSenha())};
        Cursor cursor = db.query(UserContract.TABLE, UserContract.COLUNS,where, params, null, null, null);

        User usuario = UserContract.getUser(cursor);
        databaseHelper.close();
        db.close();
        return usuario;
    }
}

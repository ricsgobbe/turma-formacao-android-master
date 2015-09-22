package br.com.cast.turmaformacao.taskmanager.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entidade.User;


/**
 * Created by eu.nicekuba on 21/09/2015.
 */
public class UserContract {

    public static final String TABLE = "user";
   public static final String ID = "id";
   public static final String NOME = "nome";
   public static final String SENHA = "senha";


   public static final String[] COLUNS = {ID,NOME,SENHA};

    public UserContract() {
        super();
    }

    public static String getCreateTableScript() {
        final StringBuilder create = new StringBuilder();

        create.append(" CREATE TABLE " + TABLE);
        create.append(" ( ");
        create.append(ID + " INTEGER PRIMARY KEY, ");
        create.append(NOME + " TEXT NOT NULL, ");
        create.append(SENHA + " TEXT NOT NULL ");
        create.append(" ); ");

        return create.toString();
    }


    public static ContentValues getContentValues(User user) {
        ContentValues values = new ContentValues();
        values.put(UserContract.ID, user.getId());
        values.put(UserContract.NOME, user.getNome());
        values.put(UserContract.SENHA, user.getSenha());
        return values;
    }




    public static User getUser(Cursor cursor) {
      /**/
        if (!cursor.isBeforeFirst() || cursor.moveToNext()) {
            User user = new User();
            user.setId(cursor.getLong(cursor.getColumnIndex(UserContract.ID)));
            user.setSenha(cursor.getString(cursor.getColumnIndex(UserContract.SENHA)));
            user.setNome(cursor.getString(cursor.getColumnIndex(UserContract.NOME)));


            return user;
        }
        return null;
    }


    public static List<User> getUsers(Cursor cursor) {
        ArrayList<User> tarefas = new ArrayList<>();
        while (cursor.moveToNext()) {
            tarefas.add(getUser(cursor));
        }
        return tarefas;
    }

}

package br.com.cast.turmaformacao.taskmanager.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entidade.Label;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Task;

/**
 * Created by Administrador on 16/09/2015.
 */
public final class TaskContract {
    /*todos os atributos*/
    public static final String TABLE = "task";
    public static final String ID = "id";
    public static final String WEB_ID = "web_id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String LABEL = "label";

    public static final String[] COLUNS = {ID,WEB_ID, NAME, DESCRIPTION, LABEL};

    private TaskContract() {
        super();
    }

    public static String getCreateTableScript() {
        final StringBuilder create = new StringBuilder();

        create.append(" CREATE TABLE " + TABLE);
        create.append(" ( ");
        create.append(ID + " INTEGER PRIMARY KEY, ");
        create.append(WEB_ID + " INTEGER, ");
        create.append(NAME + " TEXT NOT NULL, ");
        create.append(DESCRIPTION + " TEXT, ");
        create.append(LABEL + " LONG ");
        create.append(" ); ");

        return create.toString();
    }


    public static ContentValues getContentValues(Task task) {
        ContentValues values = new ContentValues();
        values.put(TaskContract.ID, task.getId());
        values.put(TaskContract.NAME, task.getNome());
        values.put(TaskContract.DESCRIPTION, task.getDescription());
        values.put(TaskContract.LABEL, task.getLabel().getId());
        values.put(TaskContract.WEB_ID, task.getWeb_id());
        return values;
    }

    public static Task getTask(Cursor cursor) {
      /**/
        if (!cursor.isBeforeFirst() || cursor.moveToNext()) {
            Task task = new Task();
            task.setId(cursor.getLong(cursor.getColumnIndex(TaskContract.ID)));
            task.setWeb_id(cursor.getLong(cursor.getColumnIndex(TaskContract.WEB_ID)));
            task.setDescription(cursor.getString(cursor.getColumnIndex(TaskContract.DESCRIPTION)));
            task.setNome(cursor.getString(cursor.getColumnIndex(TaskContract.NAME)));
            if(task.getLabel() != null) {

                Label label = new Label();
                label.setId(cursor.getLong(cursor.getColumnIndex(TaskContract.LABEL)));
                task.setLabel(label);
            }
            return task;
        }
        return null;
    }

    public static List<Task> getTasks(Cursor cursor) {
        ArrayList<Task> tarefas = new ArrayList<>();
        while (cursor.moveToNext()) {
            tarefas.add(getTask(cursor));
        }
        return tarefas;
    }

}

package br.com.cast.turmaformacao.taskmanager.model.persistencia;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.taskmanager.model.entidade.Color;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Label;

/**
 * Created by Administrador on 17/09/2015.
 */
public class LabelContract {
    public  static final  String TABLE = "label";
    public  static final  String ID = "id";
    public  static final  String NAME = "name";
    public  static final  String DESCRIPTION = "description";
    public static final String COLOR = "null";

    public static final String[] COLUNSLABEL = {ID, NAME, DESCRIPTION};

    private LabelContract(){
        super();
    }

    public static String getCreateTableScript(){
        final StringBuilder create = new StringBuilder();

        create.append(" CREATE TABLE " + TABLE);
        create.append(" ( ");
        create.append(ID + " INTEGER PRIMARY KEY, ");
        create.append(NAME + " TEXT NOT NULL, ");
        create.append(DESCRIPTION + " TEXT ");
        create.append(COLOR +" TEXT ");
        create.append(" ); ");

        return create.toString();
    }



    public static ContentValues getContentValues(Label label){
        ContentValues values = new ContentValues();
        values.put(LabelContract.ID, label.getId());
        values.put(LabelContract.NAME, label.getName());
        values.put(LabelContract.DESCRIPTION, label.getDescription());
        values.put(LabelContract.COLOR, label.getColor().getHex());
        return values;
    }

    public static Label getLabel(Cursor cursor){
      /**/
        if(!cursor.isBeforeFirst() || cursor.moveToNext()) {
            Label label = new Label();
            label.setId(cursor.getLong(cursor.getColumnIndex(LabelContract.ID)));
            label.setDescription(cursor.getString(cursor.getColumnIndex(LabelContract.DESCRIPTION)));
            label.setName(cursor.getString(cursor.getColumnIndex(LabelContract.NAME)));
            label.setColor(Color.getInstancia(cursor.getString(cursor.getColumnIndex(LabelContract.COLOR))));

            return label;
        }
        return null;
    }

    public static List<Label> getLabels(Cursor cursor){
        ArrayList<Label> label = new ArrayList<>();
        while(cursor.moveToNext()){
            label.add(getLabel(cursor));
        }
        return label;
    }

}

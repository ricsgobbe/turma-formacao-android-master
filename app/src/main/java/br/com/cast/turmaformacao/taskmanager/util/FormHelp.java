package br.com.cast.turmaformacao.taskmanager.util;

import android.view.View;
import android.widget.EditText;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Label;

/**
 * Created by Administrador on 15/09/2015.
 */
public final class FormHelp {
    private FormHelp(){
        super();
    }

    public static boolean validateRequired(String requiredMessage, EditText... editTexts){
        for(EditText editText : editTexts){
            boolean required = false;
            String textValue = editText.getText().toString();
            if(textValue.trim().isEmpty()){
                editText.setError(requiredMessage);
                required = true;
            }
            return required;
        }

        return false;
    }

}

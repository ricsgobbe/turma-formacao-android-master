package br.com.cast.turmaformacao.taskmanager.controlers.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Task;
import br.com.cast.turmaformacao.taskmanager.model.servicos.TaskBusinessServices;
import br.com.cast.turmaformacao.taskmanager.util.FormHelp;


/**
 * Created by Administrador on 15/09/2015.
 */
public class ActivityTaskForm extends AppCompatActivity {

    public static final String PARAM_TASK = "PARAM_TASK";
    private EditText editName;
    private EditText editDesc;
    private Button button;
    private Task task;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_task_form);

        iniTask();
        bindTextName();
        bindTextDesc();
        bindButtonSave();
    }

    private void iniTask() {
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            this.task = (Task) getIntent().getExtras().getParcelable(PARAM_TASK);
        }
        this.task = this.task == null ? new Task() : task;
    }

    private void bindButtonSave() {
        button = (Button) findViewById(R.id.btnSave);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = ActivityTaskForm.this.getString(R.string.lbl_required);
               if(!FormHelp.validateRequired(msg, editName) ) {
                   bindTask();
                   /*Por manipular arquivo, deve-se usar o getApplication, pq se a activity morrer, o conteudo estara vivo
                   * pois ela serve para todo o ciclo de vida do programa*/

                   TaskBusinessServices.save(task);
                   Toast.makeText(ActivityTaskForm.this, R.string.msg_save_success, Toast.LENGTH_LONG).show();
                   ActivityTaskForm.this.finish();
               }
            }

            private void bindTask() {
                task.setNome(editName.getText().toString());
                task.setDescription(editDesc.getText().toString());
            }
        });
    }


    private void bindTextDesc() {
        editDesc = (EditText) findViewById(R.id.textDesc);
        editDesc.setText(task.getNome() == null ? "" : task.getDescription());
    }

    private void bindTextName() {
        editName = (EditText) findViewById(R.id.textNome);
        editName.setText(task.getNome() == null ? "" : task.getNome());
    }
}

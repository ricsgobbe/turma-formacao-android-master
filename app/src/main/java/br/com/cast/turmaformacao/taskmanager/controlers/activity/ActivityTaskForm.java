package br.com.cast.turmaformacao.taskmanager.controlers.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.controlers.adapters.ColorListAdapter;
import br.com.cast.turmaformacao.taskmanager.controlers.adapters.LabelListAdapter;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Label;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Task;
import br.com.cast.turmaformacao.taskmanager.model.servicos.LabelBusinessServices;
import br.com.cast.turmaformacao.taskmanager.model.servicos.TaskBusinessServices;
import br.com.cast.turmaformacao.taskmanager.util.FormHelp;


/**
 * Created by Administrador on 15/09/2015.
 */
public class ActivityTaskForm extends AppCompatActivity {

    public static final String PARAM_TASK = "PARAM_TASK";
    private EditText editName;
    private EditText editDesc;
    private Button buttonLabel;
    private Spinner spinner;
    private Task task;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_task_form);

        iniTask();
        bindButton();
        bindTextName();
        bindTextDesc();
        bindSpinner();

    }


    @Override
    protected void onResume() {
        update();
        super.onResume();

    }

    private void update() {
        List<Label> labels = LabelBusinessServices.findAll();
        LabelListAdapter labelAdapter = (LabelListAdapter) spinner.getAdapter();
        labelAdapter.setItens(labels);
        labelAdapter.notifyDataSetChanged();
    }

    private void bindSpinner() {
        spinner = (Spinner) findViewById(R.id.spinnerTaskForm);
        List<Label>  label = LabelBusinessServices.findAll();
        spinner.setAdapter(new LabelListAdapter(ActivityTaskForm.this, label));
    }

    private void bindButton() {
        buttonLabel = (Button) findViewById(R.id.button_taskForm_label);
        buttonLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLabelForm = new Intent(ActivityTaskForm.this, LabelFormActivity.class);
                startActivity(goToLabelForm);
            }
        });
    }

    private void iniTask() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.task = getIntent().getExtras().getParcelable(PARAM_TASK);
        }
        this.task = this.task == null ? new Task() : task;
    }

    private void onMenuAdd() {
        String msg = ActivityTaskForm.this.getString(R.string.lbl_required);
        if (!FormHelp.validateRequired(msg, editName)) {
            bindTask();
                   /*Por manipular arquivo, deve-se usar o getApplication, pq se a activity morrer, o conteudo estara vivo
                   * pois ela serve para todo o ciclo de vida do programa*/

            TaskBusinessServices.save(task);
            ActivityTaskForm.this.finish();
        }
    }

    private void bindTask() {
        task.setNome(editName.getText().toString());
        task.setDescription(editDesc.getText().toString());
        task.setLabel((Label)spinner.getSelectedItem());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_addTask:
                onMenuAdd();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void bindTextDesc() {
        editDesc = (EditText) findViewById(R.id.textDesc);
        editDesc.setText(task.getNome() == null ? "" : task.getDescription());
    }

    private void bindTextName() {
        editName = (EditText) findViewById(R.id.textNome);
        editName.setText(task.getNome() == null ? "" : task.getNome());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option_task_form, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

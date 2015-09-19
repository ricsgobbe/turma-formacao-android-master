package br.com.cast.turmaformacao.taskmanager.controlers.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.controlers.adapters.TaskListAdapter;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Task;
import br.com.cast.turmaformacao.taskmanager.model.servicos.TaskBusinessServices;

/**
 * Created by Administrador on 15/09/2015.
 */
public class TaskListActivity extends AppCompatActivity {
    private ListView listViewTaskList;
    private Task selectedTask;

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_task_list);


        bindTaskList();


    }

    private void bindTaskList() {
        listViewTaskList = (ListView) findViewById(R.id.listViewTaskList);
        registerForContextMenu(listViewTaskList);
        listViewTaskList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            /*Boolean indica se ele consumiu ou nao elemento, senao ele passar pra frente*/
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TaskListAdapter adapter = (TaskListAdapter) listViewTaskList.getAdapter();
                selectedTask = adapter.getItem(position);
                return false;
            }
        });
    }

    protected void onResume() {
        updateTaskList();
        super.onResume();
    }

    private void updateTaskList() {
        List<Task> values = TaskBusinessServices.findAll();
        listViewTaskList.setAdapter(new TaskListAdapter(this, values));
        TaskListAdapter adapter = (TaskListAdapter) listViewTaskList.getAdapter();
        adapter.notifyDataSetChanged();
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_add:
                onMenuAddClick();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onMenuAddClick() {
        Intent goToTaskFormActivity = new Intent(TaskListActivity.this, ActivityTaskForm.class);
        startActivity(goToTaskFormActivity);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context_task_list, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_delete:
                onMenuDeleteClick();
                break;
            case R.id.menu_edit:
                onMenuEditClick();
                break;
        }

        return super.onContextItemSelected(item);
    }

    private void onMenuEditClick() {
        Intent goToTaskForm = new Intent(TaskListActivity.this, ActivityTaskForm.class);
       /*Quase hash map ou Bundle new Bundle*/
        goToTaskForm.putExtra(ActivityTaskForm.PARAM_TASK, selectedTask);
        startActivity(goToTaskForm);
    }

    private void onDeleteClick() {
        TaskBusinessServices.delete(selectedTask);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_task_list, menu);
        return super.onCreateOptionsMenu(menu);
    }
    /*TRATAMENTO CLICK MENU DAS VIEWS*/
    public void onMenuDeleteClick(){

        new AlertDialog.Builder(TaskListActivity.this).setTitle(getString(R.string.lbl_confirm))
                .setMessage(getString(R.string.lbl_confirm_delete)).setPositiveButton(R.string.lbl_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TaskBusinessServices.delete(selectedTask);
                        selectedTask = null;
                        String message = "Yes";
                        updateTaskList();
                        Toast.makeText(TaskListActivity.this, message, Toast.LENGTH_LONG).show();
                    }

                }).setNeutralButton(R.string.lbl_no, null)
                .create()
                .show();

    }
}
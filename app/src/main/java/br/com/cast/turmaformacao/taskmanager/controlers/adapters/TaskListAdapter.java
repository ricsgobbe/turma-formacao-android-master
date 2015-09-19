package br.com.cast.turmaformacao.taskmanager.controlers.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Task;

/**
 * Created by Administrador on 15/09/2015.
 */
public class TaskListAdapter extends BaseAdapter {


    private List<Task> taskList;
    private Activity contexto;


    public TaskListAdapter(Activity contexto, List<Task> taskList) {
        this.contexto = contexto;
        this.taskList = taskList;
    }

    public void setDataValues(List<Task> values){
        taskList.clear();
        taskList.addAll(values);

    }


    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Task getItem(int position) {
        return taskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);
        View taskListView = contexto.getLayoutInflater().inflate(R.layout.list_item_task, parent, false);

        TextView textViewId = (TextView)taskListView.findViewById(R.id.taskListId);
        textViewId.setText(task.getId().toString());

        TextView textViewNome = (TextView)taskListView.findViewById(R.id.taskListNome);
        textViewNome.setText(task.getNome().toString());


        return taskListView;
    }
}

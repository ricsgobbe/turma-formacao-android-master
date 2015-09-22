package br.com.cast.turmaformacao.taskmanager.controlers.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Color;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Label;

/**
 * Created by Administrador on 17/09/2015.
 */
public class LabelListAdapter extends BaseAdapter {
    private Activity context;
    private List<Label> labels;

    public LabelListAdapter(Activity activity, List<Label> labels) {
        super();
        this.context = activity;
        this.labels = labels;
    }

    @Override
    public int getCount() {
        return labels.size();
    }

    @Override
    public Label getItem(int position) {
        return this.labels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View labelListView = context.getLayoutInflater().inflate(R.layout.list_item_label, parent, false);
        Label label = getItem(position);

        TextView taskListNome = (TextView)labelListView.findViewById(R.id.taskListNome);
        taskListNome.setText(label.getName().toString());

        View tarefa = labelListView.findViewById(R.id.viewTarefa);
        tarefa.setBackgroundColor(android.graphics.Color.parseColor(label.getColor().getHex()));


        //View viewById =  view.findViewById(R.id.list_colors);

        return labelListView;
    }

    public void setItens(List<Label> itens) {
        labels.clear();
        labels.addAll(itens);
    }
}

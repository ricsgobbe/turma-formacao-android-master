package br.com.cast.turmaformacao.taskmanager.controlers.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;


import java.util.List;
import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.controlers.adapters.LabelListAdapter;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Label;
import br.com.cast.turmaformacao.taskmanager.model.servicos.LabelBusinessServices;


/**
 * Created by Administrador on 17/09/2015.
 */
public class LabelListActivity extends AppCompatActivity {

    private ListView listViewLabelList;
    private Label selectedLabel;


    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_label_list);

        bindLabelList();
    }

    private void bindLabelList() {
        listViewLabelList = (ListView) findViewById(R.id.listViewLabelList);
    }

    protected void onResume() {
        updateLabelList();
        super.onResume();
    }

    private void updateLabelList() {
        List<Label> values = LabelBusinessServices.findAll();
        listViewLabelList.setAdapter(new LabelListAdapter(this, values));
        LabelListAdapter adapter = (LabelListAdapter) listViewLabelList.getAdapter();
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
        Intent goToLabelFormActivity = new Intent(LabelListActivity.this, LabelFormActivity.class);
        startActivity(goToLabelFormActivity);
    }




}

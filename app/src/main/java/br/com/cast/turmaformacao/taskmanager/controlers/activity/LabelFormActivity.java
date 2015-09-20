package br.com.cast.turmaformacao.taskmanager.controlers.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.controlers.adapters.ColorListAdapter;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Color;
import br.com.cast.turmaformacao.taskmanager.model.entidade.Label;
import br.com.cast.turmaformacao.taskmanager.model.persistencia.LabelContract;
import br.com.cast.turmaformacao.taskmanager.model.persistencia.LabelRepository;
import br.com.cast.turmaformacao.taskmanager.model.servicos.LabelBusinessServices;
import br.com.cast.turmaformacao.taskmanager.util.FormHelp;

/**
 * Created by Administrador on 17/09/2015.
 */
public class LabelFormActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editDesc;
    private Spinner spinerColor;
    private Label label;
    public static final String PARAM_LABEL = "PARAM_LABEL";

    protected  void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_label_form);

        bindSpinner();
        iniLabel();
        bindTextName();
        bindTextDesc();

    }




    private void iniLabel() {
        this.label = this.label == null ? new Label() : label;
    }



   private void bindSpinner() {
       Color[] colors = Color.values();
       spinerColor = (Spinner)findViewById(R.id.spinnerColor);
       /*colors.add(Color.getInstancia("#03A9F4"));
       ArrayAdapter<Color> colorArrayAdapter = new ArrayAdapter<Color>(this, R.layout.list_item_color, colors);
       spinerColor.setAdapter(colorArrayAdapter);*/
       ColorListAdapter colorAdapter = new ColorListAdapter(LabelFormActivity.this, colors);
       spinerColor.setAdapter(colorAdapter);


    }



    private void onMenuAddClick() {
        if(!FormHelp.validateRequired("erro", editName)){
            bindLabel();
            LabelBusinessServices.save(label);
            Toast.makeText(LabelFormActivity.this, LabelRepository.getAll().toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void bindLabel() {
        label.setName(editName.getText().toString());
        label.setDescription(editDesc.getText().toString());
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_addLabel:
                onMenuAddClick();
                break;
        }
        return super.onOptionsItemSelected(item);
    }





    private void bindTextDesc() {
        editDesc = (EditText) findViewById(R.id.editTextDescription);
    }

    private void bindTextName() {
        editName = (EditText) findViewById(R.id.editTextName);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_label_list, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

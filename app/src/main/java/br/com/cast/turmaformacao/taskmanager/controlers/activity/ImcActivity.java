package br.com.cast.turmaformacao.taskmanager.controlers.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;

import android.widget.Toast;

import br.com.cast.turmaformacao.taskmanager.R;

/**
 * Created by Administrador on 14/09/2015.
 */
public class ImcActivity extends AppCompatActivity {
    private EditText editAltura;
    private EditText editPeso;
    private EditText editCalcularText;
    private Button buttonCalcular;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_imc);

        bindTextAltura();
        bindTextPeso();
        bindButtonCalcular();

    }

    private void bindButtonCalcular() {
        buttonCalcular = (Button)findViewById(R.id.buttonCalcular);
        buttonCalcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                double resultado = Double.parseDouble(editPeso.getText().toString()) /
                             Math.pow(Double.parseDouble(editAltura.getText().toString()),2);
                Toast.makeText(ImcActivity.this, getResources().getString(R.string.txt_msg, resultado), Toast.LENGTH_LONG ).show();
            }
        });
    }

    private void bindTextPeso() {
        editPeso = (EditText)findViewById(R.id.editPesoText);
    }

    private void bindTextAltura() {
        editAltura =  (EditText)findViewById(R.id.editAlturaText);
    }
}

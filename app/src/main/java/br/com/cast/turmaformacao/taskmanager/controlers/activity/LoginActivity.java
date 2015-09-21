package br.com.cast.turmaformacao.taskmanager.controlers.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.cast.turmaformacao.taskmanager.R;

/**
 * Created by Administrador on 14/09/2015.
 */
public class LoginActivity extends AppCompatActivity {
    private EditText editLogin;
    private EditText editPassword;
    private Button editButton;

    protected void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);

        bindEditTextLogin();
        bindEditTextPassword();
        bindButtonLogin();
    }




    private void bindButtonLogin() {
        editButton = (Button) findViewById(R.id.editButtonLogin);
        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, TaskListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void bindEditTextPassword() {
        editPassword = (EditText) findViewById(R.id.editTextPassword);

    }

    private void bindEditTextLogin() {
        editLogin =(EditText) findViewById(R.id.editTextLogin);
    }
}

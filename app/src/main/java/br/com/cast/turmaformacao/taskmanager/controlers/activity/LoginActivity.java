package br.com.cast.turmaformacao.taskmanager.controlers.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.model.entidade.User;
import br.com.cast.turmaformacao.taskmanager.model.persistencia.UserRepository;
import br.com.cast.turmaformacao.taskmanager.model.servicos.UserBusinessServices;
import br.com.cast.turmaformacao.taskmanager.util.FormHelp;

/**
 * Created by Administrador on 14/09/2015.
 */
public class LoginActivity extends AppCompatActivity {
    private EditText editLogin;
    private EditText editPassword;
    private Button editButton;
    private List<User> users;
    private User user;

    protected void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);
        iniUser();
        bindEditTextLogin();
        bindEditTextPassword();
        bindButtonLogin();

    }

    private void iniUser() {
        this.user = this.user == null ? new User() : this.user;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private void bindButtonLogin() {
        editButton = (Button) findViewById(R.id.editButtonLogin);
        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bindUser();
                if(!(UserRepository.selectLogin(user) == null)){
                    Intent intent = new Intent(LoginActivity.this, TaskListActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void bindUser() {
        user.setNome(editLogin.getText().toString());
        user.setSenha(editPassword.getText().toString());
    }

    private void bindEditTextPassword() {
        editPassword = (EditText) findViewById(R.id.editTextPassword);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_addLoginUser:
                formLoginUser();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void formLoginUser() {
        Intent intent = new Intent(LoginActivity.this, LoginFormActivity.class);
        startActivity(intent);
    }

    private void bindEditTextLogin() {
        editLogin =(EditText) findViewById(R.id.editTextLogin);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

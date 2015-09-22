package br.com.cast.turmaformacao.taskmanager.controlers.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.model.entidade.User;
import br.com.cast.turmaformacao.taskmanager.model.servicos.LabelBusinessServices;
import br.com.cast.turmaformacao.taskmanager.model.servicos.UserBusinessServices;
import br.com.cast.turmaformacao.taskmanager.util.FormHelp;
;

/**
 * Created by eu.nicekuba on 21/09/2015.
 */
public class LoginFormActivity extends AppCompatActivity {

    private EditText nome;
    private EditText senha;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_user);
        
        iniUser();
        bindEditNome();
        bindEditSenha();
        bindUser();
    }

    private void bindUser() {
        user.setNome(nome.getText().toString());
        user.setSenha(senha.getText().toString());
    }

    private void iniUser() {
        this.user = this.user == null ? new User() : this.user;
    }


    private void bindEditSenha() {
        senha = (EditText) findViewById(R.id.editTextPassword);
        senha.setText(user.getSenha() == null ? "" : user.getSenha());
    }

    private void bindEditNome() {
        nome = (EditText) findViewById(R.id.editTextUser);
        nome.setText(user.getNome() == null ? "" : user.getNome());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_addLoginUser:
                addUser();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void addUser() {
        if (!FormHelp.validateRequired("Campo obrigatorio", nome, senha)) {
            bindUser();
            UserBusinessServices.save(user);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

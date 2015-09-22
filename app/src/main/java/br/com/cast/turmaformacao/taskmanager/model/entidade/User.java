package br.com.cast.turmaformacao.taskmanager.model.entidade;

import android.widget.EditText;

/**
 * Created by eu.nicekuba on 21/09/2015.
 */
public class User {
    private Long id;
    private String nome;
    private String senha;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (nome != null ? !nome.equals(user.nome) : user.nome != null) return false;
        return !(senha != null ? !senha.equals(user.senha) : user.senha != null);

    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}

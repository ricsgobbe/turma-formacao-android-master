package br.com.cast.turmaformacao.taskmanager.model.entidade;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrador on 15/09/2015.
 */
public class Task implements Parcelable {
    /*serializa a classe, permitindo passar bit a bit*/
    private Long id;
    private String nome;
    private String description;
    private Label label;


    public Task() {
        super();
    }

    public Task(Parcel imp) {
        super();
        readFromParcel(imp);
    }


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (nome != null ? !nome.equals(task.nome) : task.nome != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null)
            return false;
        return !(label != null ? !label.equals(task.label) : task.label != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", description='" + description + '\'' +
                ", label=" + label.toString() +
                '}';
    }


    /*Metodos parcelable*/


    /**/
    @Override
    public int describeContents() {
        return 0;
    }

    /*Escrita do objeto para o parcelable !*/
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id == null ? -1 : id);
        dest.writeString(nome == null ? "" : nome);
        dest.writeString(description == null ? "" : description);
    }

    /*retorna um void readFromPaRcel, deve ser colocado na mesma posicao qqd foi escrito, pouis ele sabe a posicao, apenas*/
    public void readFromParcel(Parcel imp) {
        id = imp.readLong();
        id = id == null ? -1 : id;

        nome = imp.readString();
        description = imp.readString();

    }

    /*cria ou um array de task ou um task*/
    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {

        @Override
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}

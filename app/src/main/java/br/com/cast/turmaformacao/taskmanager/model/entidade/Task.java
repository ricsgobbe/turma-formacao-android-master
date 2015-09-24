package br.com.cast.turmaformacao.taskmanager.model.entidade;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Administrador on 15/09/2015.
 */
public class Task implements Parcelable {
    /*serializa a classe, permitindo passar bit a bit*/
    private Long _id;
    @JsonProperty("id")
    private Long web_id;
    @JsonProperty("name")
    private String nome;
    @JsonProperty("description")
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
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public Long getWeb_id() {
        return web_id;
    }

    public void setWeb_id(Long web_id) {
        this.web_id = web_id;
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

        if (_id != null ? !_id.equals(task._id) : task._id != null) return false;
        if (web_id != null ? !web_id.equals(task.web_id) : task.web_id != null) return false;
        if (nome != null ? !nome.equals(task.nome) : task.nome != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null)
            return false;
        return !(label != null ? !label.equals(task.label) : task.label != null);

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (web_id != null ? web_id.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "_id=" + _id +
                ", web_id=" + web_id +
                ", nome='" + nome + '\'' +
                ", description='" + description + '\'' +
                ", label=" + label +
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
        dest.writeLong(_id == null ? -1 : _id);
        dest.writeString(nome == null ? "" : nome);
        dest.writeString(description == null ? "" : description);
        dest.writeParcelable(label, flags);
        dest.writeLong(web_id == null ? -1 : web_id);
    }

    /*retorna um void readFromPaRcel, deve ser colocado na mesma posicao qqd foi escrito, pouis ele sabe a posicao, apenas*/
    public void readFromParcel(Parcel imp) {
        _id = imp.readLong();
        _id = _id == null ? -1 : _id;

        web_id = imp.readLong();
        web_id = web_id == null ? -1 : web_id;

        nome = imp.readString();
        description = imp.readString();
        label = imp.readParcelable(Label.class.getClassLoader());

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

package br.com.cast.turmaformacao.taskmanager.model.entidade;

/**
 * Created by Administrador on 17/09/2015.
 */
public class Label {
   private Long id;
   private String name;
   private String description;
   //private String color;


    public Label() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}



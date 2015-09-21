package br.com.cast.turmaformacao.taskmanager.model.entidade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrador on 17/09/2015.
 */
public class Label implements Parcelable {
   private Long id;
   private String name;
   private String description;
   private Color color;


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
                ", color= "+ color.getHex() +
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


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id == null ? -1 : this.id);
        dest.writeString(this.name == null ? "" : this.name);
        dest.writeString(this.description == null ? "" : this.description);
        dest.writeInt(this.color == null ? -1 : this.color.ordinal());
    }

    protected Label(Parcel in) {
        /*ele d� o getClassLoader pq Long � uma classe*/
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.id = this.id == null ? -1 : this.id;
        this.name = in.readString();
        this.description = in.readString();
        int tmpColor = in.readInt();
        this.color = tmpColor == -1 ? null : Color.values()[tmpColor];
    }

    public static final Parcelable.Creator<Label> CREATOR = new Parcelable.Creator<Label>() {
        public Label createFromParcel(Parcel source) {
            return new Label(source);
        }

        public Label[] newArray(int size) {
            return new Label[size];
        }
    };
}



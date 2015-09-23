package br.com.cast.turmaformacao.taskmanager.model.entidade;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrador on 23/09/2015.
 */
public class Address {
    @JsonProperty("cep")
  private String  zipCode;
    @JsonProperty("tipoDeLogradouro")
  private String  type;
    @JsonProperty("logradouro")
  private String  street;
    @JsonProperty("bairro")
  private String  neightborhood;
    @JsonProperty("cidade")
  private String  city;
    @JsonProperty("estado")
  private String  state;





    public Address(String zipCode) {
        super();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeightborhood() {
        return neightborhood;
    }

    public void setNeightborhood(String neightborhood) {
        this.neightborhood = neightborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (zipCode != null ? !zipCode.equals(address.zipCode) : address.zipCode != null)
            return false;
        if (type != null ? !type.equals(address.type) : address.type != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (neightborhood != null ? !neightborhood.equals(address.neightborhood) : address.neightborhood != null)
            return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        return !(state != null ? !state.equals(address.state) : address.state != null);

    }

    @Override
    public int hashCode() {
        int result = zipCode != null ? zipCode.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (neightborhood != null ? neightborhood.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Address{" +
                "zipCode='" + zipCode + '\'' +
                ", type='" + type + '\'' +
                ", street='" + street + '\'' +
                ", neightborhood='" + neightborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

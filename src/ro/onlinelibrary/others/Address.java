package ro.onlinelibrary.others;

import java.util.Objects;

public class Address {
    private Integer id;
    String city;
    String population;
    String street;
    int number;

    public Address(Integer id, String city, String street, int number) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public Address(String city, String population, String street, int number) {
        this.city = city;
        this.population = population;
        this.street = street;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return number == address.number && city.equals(address.city) && population.equals(address.population) && street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, population, street, number);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", population='" + population + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}

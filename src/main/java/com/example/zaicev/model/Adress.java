package com.example.zaicev.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String street;
    private String building;

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private Collection<Person> tenats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Collection<Person> getTenats() {
        return tenats;
    }

    public void setTenats(Collection<Person> tenats) {
        this.tenats = tenats;
    }
}

package com.sapient.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Entity
public class State {
    @Id
    private UUID id;
    private String name;
    @OneToMany(targetEntity = City.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cities_id_FK",referencedColumnName = "id")
    private List<City> cities;
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}

package com.sapient.entity;

import javax.persistence.*;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Entity
public class Address {
    @Id
    private UUID id;
    private String street;
    @OneToOne(targetEntity = State.class,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "state_id_FK",referencedColumnName = "id")
    private State state;
    @OneToOne(targetEntity = City.class,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_id_FK",referencedColumnName = "id")
    private City city;
    @ManyToOne(targetEntity = User.class,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id_FK",referencedColumnName = "id")
    private User user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package com.sapient.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Entity
public class City {
    @Id
    private UUID id;
    private String name;
    @ManyToOne(targetEntity = State.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id_FK",referencedColumnName = "id")
    private State state;
    @OneToMany(targetEntity =Theatre.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id_FK",referencedColumnName = "id")
    private List<Theatre> theatres;
    private int pinCode;

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }
}

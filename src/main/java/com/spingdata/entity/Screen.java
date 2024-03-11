package com.sapient.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Entity
public class Screen {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private int numberOfSeats;



    @CollectionTable(name = "allottedSeats")
    @ElementCollection
    private Map<Integer,Boolean> seatsMapping=new HashMap<>();
    @OneToOne(targetEntity = Movie.class,cascade = CascadeType.DETACH)
    @JoinColumn(name = "m_fk",referencedColumnName = "id")
    private Movie movie;

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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Map<Integer, Boolean> getSeatsMapping() {
        return seatsMapping;
    }

    public void setSeatsMapping(Map<Integer, Boolean> seatsMapping) {
        this.seatsMapping = seatsMapping;
    }
}

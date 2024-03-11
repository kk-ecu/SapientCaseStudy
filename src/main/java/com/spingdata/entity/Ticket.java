package com.sapient.entity;

import javax.persistence.*;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Entity
public class Ticket {
    @Id
    private UUID id;
    @OneToOne(targetEntity = User.class,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id_FK",referencedColumnName = "id",insertable = false, updatable = false)
    private User user;
    @OneToOne(targetEntity = State.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "state_id_FK",referencedColumnName = "id",insertable = false, updatable = false)
    private State state;
    @OneToOne(targetEntity = City.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_id_FK",referencedColumnName = "id",insertable = false, updatable = false)
    private City city;
    @OneToOne(targetEntity = Screen.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "screen_id_FK",referencedColumnName = "id",insertable = false, updatable = false)
    private Screen screen;
    @OneToOne(targetEntity = Theatre.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_id_FK",referencedColumnName = "id",insertable = false, updatable = false)
    private Theatre theatre;

}

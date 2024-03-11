package com.sapient.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Entity
public class Theatre {
    @Id
    private UUID id;
    private String name;
    private String address;
    @OneToMany(targetEntity = Screen.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "s_fk",referencedColumnName = "id")
    private List<Screen> screen;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Screen> getScreen() {
        return screen;
    }

    public void setScreen(List<Screen> screen) {
        this.screen = screen;
    }
}

package com.sapient.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Entity
public class User {
    @Id
    private UUID id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id_FK",referencedColumnName = "id")
    private List<Address> addresses;

    @ElementCollection
    @CollectionTable(name ="phoneNumbers")
    private List<Integer> phoneNumbers= new ArrayList<Integer>();

    public List<Integer> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Integer> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}

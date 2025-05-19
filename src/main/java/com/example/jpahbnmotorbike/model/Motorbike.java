package com.example.jpahbnmotorbike.model;

import javax.persistence.*;

@Entity
@Table(name = "motorbike")
public class Motorbike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int soldNumber;
    private String description;

    public Motorbike() {
    }

    public Motorbike(long id, String name, int soldNumber, String description) {
        this.id = id;
        this.name = name;
        this.soldNumber = soldNumber;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(int soldNumber) {
        this.soldNumber = soldNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", soldNumber=" + soldNumber +
                ", description='" + description + '\'' +
                '}';
    }
}

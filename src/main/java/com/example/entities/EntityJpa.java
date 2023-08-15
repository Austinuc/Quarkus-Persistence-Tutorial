package com.example.entities;


import jakarta.persistence.*;

/**
 * Uses entity manager
 */

@Entity
@NamedQuery(name ="Entity.findAll",
    query = "SELECT a FROM EntityJpa a ORDER BY a.id")
@NamedQuery(name = "Entity.findByName",
query = "SELECT a FROM EntityJpa a WHERE a.name = :name")
public class EntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public EntityJpa() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

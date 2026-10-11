package com.example.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom;

    @ManyToMany(mappedBy = "equipements")
    private Set<Salle> salles = new HashSet<>();

    // Constructeurs, getters et setters

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Salle> getSalles() {
        return salles;
    }
}
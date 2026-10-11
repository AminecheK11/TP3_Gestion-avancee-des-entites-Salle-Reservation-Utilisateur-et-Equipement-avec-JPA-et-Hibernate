package com.example.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "salle_equipement",
            joinColumns = @JoinColumn(name = "salle_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private Set<Equipement> equipements = new HashSet<>();

    @OneToMany(mappedBy = "salle")
    private Set<Reservation> reservations = new HashSet<>();

    // Constructeurs, getters et setters

    public void addEquipement(Equipement equipement) {
        equipements.add(equipement);
        equipement.getSalles().add(this);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setSalle(this);
    }

    public boolean estDisponible(LocalDateTime debut, LocalDateTime fin) {
        for (Reservation reservation : reservations) {
            if (debut.isBefore(reservation.getDateFin())
                    && fin.isAfter(reservation.getDateDebut())) {
                return false;
            }

        }

        return true;
    }

}
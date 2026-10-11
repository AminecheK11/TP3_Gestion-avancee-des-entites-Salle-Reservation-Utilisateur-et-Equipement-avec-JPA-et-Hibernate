package com.example.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nom;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservations = new HashSet<>();

    // Constructeurs, getters et setters
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setUtilisateur(this);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public Set<Reservation> getReservations() {
        return reservations;
    }
}

package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateDebut;

    @Column(nullable = false)
    private LocalDateTime dateFin;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salle_id")
    private Salle salle;

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public boolean datesValides() {
        return dateDebut != null
                && dateFin != null
                && dateDebut.isBefore(dateFin);
    }
}
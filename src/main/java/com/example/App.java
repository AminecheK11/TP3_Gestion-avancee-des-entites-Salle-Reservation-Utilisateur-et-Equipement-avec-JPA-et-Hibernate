package com.example;

import com.example.model.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion-reservations-pu");
        EntityManager em = emf.createEntityManager();
        try {
        em.getTransaction().begin();

        Utilisateur user = new Utilisateur();
        user.setEmail("alice@example.com");
            user.setNom("Alice Dupont");

        Salle salle = new Salle();
        salle.setNom("Salle A");

        Equipement projecteur = new Equipement();
        projecteur.setNom("Projecteur");

        salle.addEquipement(projecteur);

        Reservation reservation = new Reservation();

        reservation.setDateDebut(LocalDateTime.of(2026, 10, 15, 9, 0));
        reservation.setDateFin(LocalDateTime.of(2026, 10, 15, 11, 0));

        System.out.println("Dates valides : " + reservation.datesValides());

        salle.addReservation(reservation);
        reservation.setUtilisateur(user);

        user.addReservation(reservation);

        System.out.println("Salle disponible de 10h à 12h : "
                + salle.estDisponible(
                LocalDateTime.of(2026, 10, 15, 10, 0),
                LocalDateTime.of(2026, 10, 15, 12, 0)
        ));

        em.persist(user); // cascade persist propagée

        em.getTransaction().commit();

        List<Reservation> reservationsUtilisateur = em.createQuery(
                        "SELECT r FROM Reservation r WHERE r.utilisateur.email = :email",
                        Reservation.class
                )
                .setParameter("email", "alice@example.com")
                .getResultList();

        System.out.println("Nombre de réservations de Alice : "
                + reservationsUtilisateur.size());

        List<Salle> sallesEquipees = em.createQuery(
                        "SELECT s FROM Salle s JOIN s.equipements e WHERE e.nom = :nomEquipement",
                        Salle.class
                )
                .setParameter("nomEquipement", "Projecteur")
                .getResultList();

        System.out.println("Nombre de salles avec Projecteur : "
                + sallesEquipees.size());

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.err.println("Erreur lors de la persistance : " + e.getMessage());
        }  finally {
            em.close();
            emf.close();
        }

    }
}
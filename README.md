# TP 3 : Gestion avancée des entités Salle, Réservation, Utilisateur et Équipement avec JPA et Hibernate

**Réalisé par : Amine Chekkouri**

## 1. Objectif du TP

L’objectif de ce TP est de réaliser une application de gestion des réservations de salles avec **JPA et Hibernate**. Le projet permet de gérer les utilisateurs, les salles, les réservations et les équipements, ainsi que les relations entre ces différentes entités.

## 2. Technologies utilisées

- Java
- JPA
- Hibernate
- Maven
- Base de données H2
- IntelliJ IDEA

 ## 3. Structure du projet

Le projet est organisé autour de quatre entités principales :

- **Utilisateur** : représente l'utilisateur qui effectue une réservation.
- **Salle** : représente les salles disponibles.
- **Réservation** : permet de gérer les réservations et leurs dates.
- **Équipement** : représente les équipements disponibles dans les salles.

## 4. Relations entre les entités

Les principales relations JPA utilisées sont :

- **Utilisateur → Réservation** : OneToMany
- **Réservation → Utilisateur** : ManyToOne
- **Salle → Réservation** : OneToMany
- **Réservation → Salle** : ManyToOne
- **Salle ↔ Équipement** : ManyToMany

## 5. Fonctionnalités réalisées

- Création et persistance des entités.
- Ajout d’équipements à une salle.
- Gestion des réservations.
- Validation des dates.
- Vérification de la disponibilité d’une salle.
- Recherche avec des requêtes JPQL.
- Gestion des exceptions et des transactions.

## 6. Tests et résultats

### 6.1 Persistance des entités

Les entités Utilisateur, Salle, Équipement et Réservation sont enregistrées dans la base de données avec Hibernate.

<img width="458" height="679" alt="cap4_lab3" src="https://github.com/user-attachments/assets/4d529ca1-9fe0-4402-a672-7412544d752c" />


### 6.2 Validation des dates et disponibilité des salles

Le test vérifie la validité des dates d'une réservation ainsi que la disponibilité d'une salle sur une période donnée.

<img width="396" height="260" alt="cap5_lab3" src="https://github.com/user-attachments/assets/6ab705e1-e08c-4130-b714-867bc2f2fcde" />

### 6.3 Requêtes JPQL

Deux requêtes JPQL ont été testées : la récupération des réservations d'un utilisateur et la recherche des salles selon un équipement.

**Réservations d'un utilisateur :**

<img width="347" height="242" alt="cap6_lab3" src="https://github.com/user-attachments/assets/ef419bd7-8181-490e-a7fe-1945b11cd5dc" />


**Salles équipées d'un projecteur :**

<img width="358" height="248" alt="cap7_lab3" src="https://github.com/user-attachments/assets/87fdc541-3153-473e-9b04-7032981ab2ec" />

### 6.4 Gestion des exceptions

Une erreur de persistance a été provoquée afin de vérifier la gestion des exceptions et le rollback de la transaction.

<img width="950" height="127" alt="cap8_lab3" src="https://github.com/user-attachments/assets/39c50257-1708-41a7-953d-3232ddb4b4b9" />

## 7. Conclusion

Ce TP m'a aidé à mieux comprendre JPA et Hibernate, notamment les relations entre les entités. J'ai également testé la persistance des données, les requêtes JPQL et la gestion des exceptions.






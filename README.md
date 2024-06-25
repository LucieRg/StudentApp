# Gestion des Étudiants

Ce projet Java est une application de gestion des étudiants, permettant d'effectuer des opérations CRUD (Create, Read, Update, Delete) sur une base de données PostgreSQL. L'application utilise JDBC pour la connexion à la base de données et est conçue pour être exécutée en ligne de commande.

## Fonctionnalités

- Ajout d'un étudiant avec nom, prénom, numéro de classe et date de diplôme.
- Affichage de tous les étudiants présents dans la base de données.
- Affichage des étudiants par classe.
- Suppression d'un étudiant par son ID.

## Structure du Projet

Le projet est structuré en packages selon les bonnes pratiques :

- **`org.example.Entity`** : Contient la classe `Etudiant` qui représente l'entité étudiant avec ses propriétés.
- **`org.example.DAO`** : Contient les classes `EtudiantDAO` pour l'accès aux données et `EtudiantService` pour la logique métier.
- **`org.example.Util`** : Contient `DatabaseManager` pour la gestion de la connexion à la base de données.
- **`org.example`** : Classe `Main` comme point d'entrée de l'application et `EtudiantView` pour l'IHM.

## Prérequis

Avant d'exécuter l'application, assurez-vous d'avoir :

- Java 8 ou version ultérieure installé sur votre machine.
- Une base de données PostgreSQL disponible. Assurez-vous que les détails de connexion (`URL`, `USERNAME`, `PASSWORD`) dans `DatabaseManager` correspondent à votre configuration PostgreSQL.

## Exemple d'utilisation 

=== Menu Principal ===
1. Ajouter un étudiant
2. Afficher tous les étudiants
3. Afficher les étudiants par classe
4. Supprimer un étudiant
5. Quitter
   
Votre choix : 1
- Nom : Dupont
- Prénom : Jean
- Numéro de classe : 3
- Date de diplôme (AAAA-MM-JJ) : 2024-06-01
- Étudiant ajouté avec succès !

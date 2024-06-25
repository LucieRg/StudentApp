package org.example.DAO;

import org.example.Entity.Etudiant;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EtudiantView {
    private final EtudiantService etudiantService;
    private final Scanner scanner;

    public EtudiantView(Connection connection) {
        this.etudiantService = new EtudiantService(connection);
        this.scanner = new Scanner(System.in);
    }

    public void ajouterEtudiant() throws SQLException {
        System.out.println("\nAjout d'un nouvel étudiant :");

        System.out.println("Entrez le Nom de l'étudiant:");
        String nom = scanner.nextLine();

        System.out.println("Entrez le Prénom de l'étudiant:");
        String prenom = scanner.nextLine();

        System.out.println("Entrez le numéro de classe:");
        int numeroClasse = Integer.parseInt(scanner.nextLine());

        System.out.println("Entrez la date de diplôme (format : AAAA-MM-JJ):");
        String dateDiplomeStr = scanner.nextLine();
        LocalDate dateDiplome = LocalDate.parse(dateDiplomeStr);

        etudiantService.ajouterEtudiant(nom, prenom, numeroClasse, dateDiplome);
        System.out.println("L'étudiant a été ajouté avec succès.");
    }

    public void afficherTousLesEtudiants() throws SQLException {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        System.out.println("\nListe de tous les étudiants :");
        for (Etudiant etudiant : etudiants) {
            System.out.printf("%s %s - Classe %d - Diplômé le %s\n", etudiant.getPrenom(), etudiant.getNom(), etudiant.getNumeroClasse(), etudiant.getDateDiplome());
        }
    }

    public void afficherEtudiantsParClasse() throws SQLException {
        System.out.println("\nAffichage des étudiants d'une classe :");
        System.out.println("Entrez le numéro de classe :");
        int numeroClasse = Integer.parseInt(scanner.nextLine());

        List<Etudiant> etudiants = etudiantService.getEtudiantsByClasse(numeroClasse);
        System.out.printf("\nListe des étudiants en classe %d :\n", numeroClasse);
        for (Etudiant etudiant : etudiants) {
            System.out.printf("%s %s - Diplômé le %s\n", etudiant.getPrenom(), etudiant.getNom(), etudiant.getDateDiplome());
        }
    }

    public void supprimerEtudiant() throws SQLException {
        System.out.println("\nSuppression d'un étudiant :");
        System.out.println("Entrez l'ID de l'étudiant à supprimer :");
        int id = Integer.parseInt(scanner.nextLine());

        boolean success = etudiantService.supprimerEtudiant(id);
        if (success) {
            System.out.printf("L'étudiant avec ID %d a été supprimé avec succès.\n", id);
        } else {
            System.out.printf("Aucun étudiant trouvé avec cet ID %d.\n", id);
        }
    }

    public void menuPrincipal() throws SQLException {
        while (true) {
            System.out.println(" Menu Principal ");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher tous les étudiants");
            System.out.println("3. Afficher les étudiants d'une classe");
            System.out.println("4. Supprimer un étudiant");
            System.out.println("5. Quitter");

            int choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    ajouterEtudiant();
                    break;
                case 2:
                    afficherTousLesEtudiants();
                    break;
                case 3:
                    afficherEtudiantsParClasse();
                    break;
                case 4:
                    supprimerEtudiant();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }
    }
}

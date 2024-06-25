package org.example.DAO;

import org.example.Entity.Etudiant;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class EtudiantService {
    private EtudiantDAO etudiantDAO;

    public EtudiantService(Connection connection) {
        this.etudiantDAO = new EtudiantDAO(connection);
    }

    public void ajouterEtudiant(String nom, String prenom, int numeroClasse, LocalDate dateDiplome) throws SQLException {
        Etudiant etudiant = Etudiant.builder()
                .nom(nom)
                .prenom(prenom)
                .numeroClasse(numeroClasse)
                .dateDiplome(dateDiplome)
                .build();
        etudiantDAO.ajouterEtudiant(etudiant);
    }

    public List<Etudiant> getAllEtudiants() throws SQLException {
        return etudiantDAO.getAllEtudiants();
    }

    public List<Etudiant> getEtudiantsByClasse(int numeroClasse) throws SQLException {
        return etudiantDAO.getEtudiantsByClasse(numeroClasse);
    }

    public boolean supprimerEtudiant(int id) throws SQLException {
        return etudiantDAO.supprimerEtudiant(id);
    }
}

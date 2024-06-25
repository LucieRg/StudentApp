package org.example.DAO;

import org.example.Entity.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {
    private static final String INSERT_QUERY = "INSERT INTO etudiant (nom, prenom, numero_classe, date_diplome) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM etudiant";
    private static final String SELECT_BY_CLASS_QUERY = "SELECT * FROM etudiant WHERE numero_classe = ?";
    private static final String DELETE_QUERY = "DELETE FROM etudiant WHERE id = ?";

    private Connection connection;

    public EtudiantDAO(Connection connection) {
        this.connection = connection;
    }

    public void ajouterEtudiant(Etudiant etudiant) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setInt(3, etudiant.getNumeroClasse());
            preparedStatement.setObject(4, etudiant.getDateDiplome());
            preparedStatement.executeUpdate();
        }
    }

    public List<Etudiant> getAllEtudiants() throws SQLException {
        List<Etudiant> etudiants = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_QUERY)) {
            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getInt("numero_classe"),
                        resultSet.getDate("date_diplome").toLocalDate()
                );
                etudiants.add(etudiant);
            }
        }
        return etudiants;
    }

    public List<Etudiant> getEtudiantsByClasse(int numeroClasse) throws SQLException {
        List<Etudiant> etudiants = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CLASS_QUERY)) {
            preparedStatement.setInt(1, numeroClasse);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Etudiant etudiant = new Etudiant(
                            resultSet.getInt("id"),
                            resultSet.getString("nom"),
                            resultSet.getString("prenom"),
                            resultSet.getInt("numero_classe"),
                            resultSet.getDate("date_diplome").toLocalDate()
                    );
                    etudiants.add(etudiant);
                }
            }
        }
        return etudiants;
    }

    public boolean supprimerEtudiant(int id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }
}

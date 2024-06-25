package org.example;

import org.example.DAO.EtudiantView;
import org.example.Util.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseManager.getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            }
            EtudiantView etudiantView = new EtudiantView(connection);
            etudiantView.menuPrincipal();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données: " + e.getMessage());
        }
    }
}

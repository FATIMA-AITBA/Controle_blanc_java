package com.fatima.control_blanc.DAO;

import com.fatima.control_blanc.Membre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDaoImpl implements MembreDao {
    private Connection conn;

    public MembreDaoImpl() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/fatim/OneDrive/Bureau/FATIMA-AITBA/membres.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inserer(Membre m) {
        String sql = "INSERT INTO Membre (identifiant, nom, prenom, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getIdentifiant());
            stmt.setString(2, m.getNom());
            stmt.setString(3, m.getPrenom());
            stmt.setString(4, m.getEmail());
            stmt.setString(5, m.getPhone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Membre> chargerListeMembres() {
        List<Membre> membres = new ArrayList<>();
        String sql = "SELECT * FROM Membre";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Membre m = new Membre(
                        rs.getString("identifiant"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
                membres.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membres;
    }

    @Override
    public Membre chargerParIdentifiant(String identifiant) {
        return null;
    }
}

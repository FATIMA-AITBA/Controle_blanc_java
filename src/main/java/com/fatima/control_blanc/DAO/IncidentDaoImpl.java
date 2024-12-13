package com.fatima.control_blanc.DAO;

import com.fatima.control_blanc.Incident;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncidentDaoImpl implements IncidentDao {
    private Connection conn;

    public IncidentDaoImpl() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/fatim/OneDrive/Bureau/FATIMA-AITBA/incidents.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inserer(Incident i) {
        String sql = "INSERT INTO Incident (reference, time, status) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, i.getReference());
            stmt.setString(2, i.getTime());
            stmt.setString(3, i.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Incident> chargerListeIncidents() {
        List<Incident> incidents = new ArrayList<>();
        String sql = "SELECT * FROM Incident";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Incident i = new Incident(
                        rs.getString("reference"),
                        rs.getString("time"),
                        rs.getString("status")
                );
                incidents.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidents;
    }
}

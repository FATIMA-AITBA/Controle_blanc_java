package com.fatima.control_blanc.DAO;

import com.fatima.control_blanc.Incident;

import java.util.List;


public interface IncidentDao {

    // Ajouter un incident dans la base de données
    void inserer(Incident i);

    public List<Incident> chargerListeIncidents();
}

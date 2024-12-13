package com.fatima.control_blanc.DAO;

import com.fatima.control_blanc.Membre;

import java.util.List;

public interface MembreDao {

    // Ajouter un membre dans la base de données
    void inserer(Membre m);

    // Charger tous les membres de la base de données
    List<Membre> chargerListeMembres();

    // Charger un membre par son identifiant
    Membre chargerParIdentifiant(String identifiant);
}
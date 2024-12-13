package com.fatima.control_blanc.Controller;


import com.fatima.control_blanc.Membre;
import com.fatima.control_blanc.DAO.MembreDaoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.UUID;

public class FormController {
    @FXML private TextField nomField;
    @FXML private TextField prenomField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private Button ajouterButton;

    private MembreDaoImpl membreDao = new MembreDaoImpl();

    @FXML
    private void ajouterMembre() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        String identifiant = UUID.randomUUID().toString();

        Membre membre = new Membre(identifiant, nom, prenom, email, phone);
        membreDao.inserer(membre);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ajout réussi");
        alert.setHeaderText(null);
        alert.setContentText("Le membre a été ajouté avec succès.");
        alert.showAndWait();
    }
}
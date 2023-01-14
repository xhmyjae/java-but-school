package com.swing.etudiants.PEtudiant;

import java.util.Map;

public class Etudiant {
    String nom;
    String prenom;
    Map<String, Map<Integer, Double>> notes;

    public Etudiant(String nom, String prenom, Map<String, Map<Integer, Double>> notes) {
        this.nom = nom;
        this.prenom = prenom;
        this.notes = notes;
    }

    public void afficherNote() {
    }

    public void afficherNote(String matiere) {
    }

    public int moyenne(String matiere) {
        return 0;
    }

    public void setNote(Map<String, Map<Integer, Double>> notes) {

    }

    public void setNote(String matiere, String note, int valeur, double commentaire) {
    }

}

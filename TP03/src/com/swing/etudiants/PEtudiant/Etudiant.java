package com.swing.etudiants.PEtudiant;

import java.util.Map;

public class Etudiant {
    String nom;
    String prenom;
    Map<String, Integer> notes;

    public Etudiant(String nom, String prenom, Map<String, Integer> notes) {
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

    public void setNote(String matiere, String note, double valeur) {
    }

    public void setNote(String matiere, String note, int valeur, double commentaire) {
    }

}

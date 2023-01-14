package com.swing.etudiants.PClasse;

import com.swing.etudiants.PEtudiant.Etudiant;

import java.util.Map;

public class Classe extends Etudiant {

    public Classe(String nom, String prenom, Map<String, Map<Integer, Double>> notes) {
        super(nom, prenom, notes);
    }

    public void afficher() {
    }

    public Etudiant getEtudiant(int i) {
        return null;
    }

    public float moyenneClasse(String matiere) {
        return 0;
    }

    public void setEtudiant(Etudiant etudiant) {
    }

}

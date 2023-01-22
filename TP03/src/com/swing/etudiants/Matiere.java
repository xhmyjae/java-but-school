package com.swing.etudiants;

public class Matiere {
    String nom;
    Note[] notes;

    public Matiere(String nom, Note[] notes) {
        this.nom = nom;
        this.notes = notes;
    }

    public String getNom() {
        return nom;
    }

    public Note[] getNotes() {
        return notes;
    }

    public Double getMoyenne() {
        Double moyenne = 0.0;
        for (Note note : notes) {
            moyenne += note.getValeur();
        }
        // get coef sum
        Integer coefSum = 0;
        for (Note note : notes) {
            coefSum += note.getCoef();
        }
        return moyenne / coefSum;
    }
}

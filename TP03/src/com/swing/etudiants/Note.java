package com.swing.etudiants;

public class Note {
    Double note;
    Integer coef;

    public Note(Double note, Integer coef) {
        this.note = note;
        this.coef = coef;
    }

    public Integer getCoef() {
        return coef;
    }

    public Double getNote() {
        return note;
    }

    public Double getValeur() {
        return note * coef;
    }
}

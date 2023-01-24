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

    /**
     * Il renvoie la valeur de la note multipliée par le coefficient
     *
     * @return La valeur de la note multipliée par le coefficient.
     */
    public Double getValeur() {
        return note * coef;
    }
}

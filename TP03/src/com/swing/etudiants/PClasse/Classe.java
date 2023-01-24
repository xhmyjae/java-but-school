package com.swing.etudiants.PClasse;

import com.swing.etudiants.Matiere;
import com.swing.etudiants.PEtudiant.Etudiant;
import com.swing.yugioh.EnumAttributsMonstre;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Classe {
    ArrayList<Etudiant> etudiants;

    public Classe(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public void addEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        etudiant.saveStudent();
    }

    public float moyenneClasse(Double[] moyennes) {
        float moyenne = 0;
        for (Double moyenneEtudiant : moyennes) {
            moyenne += moyenneEtudiant;
        }
        return moyenne / moyennes.length;
    }

    public void setEtudiant(Etudiant etudiant) {
    }

    public Etudiant[] getEtudiants() {
        return etudiants.toArray(new Etudiant[0]);
    }

}

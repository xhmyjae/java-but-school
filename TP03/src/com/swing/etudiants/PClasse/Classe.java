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

    /**
     * Ajouter un étudiant à la liste des étudiants et enregistrer l'étudiant.
     *
     * @param etudiant l'étudiant à ajouter à la base de données
     */
    public void addEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        etudiant.saveStudent();
    }

    /**
     * Il prend un tableau de doubles et renvoie la moyenne des valeurs du tableau
     *
     * @param moyennes un tableau de doubles qui contient la moyenne de chaque élève
     * @return La moyenne du tableau des doubles.
     */
    public float moyenneClasse(Double[] moyennes) {
        float moyenne = 0;
        for (Double moyenneEtudiant : moyennes) {
            moyenne += moyenneEtudiant;
        }
        return moyenne / moyennes.length;
    }

    public void setEtudiant(Etudiant etudiant) {
    }

    /**
     * Cette fonction renvoie un tableau d'objets Etudiant, qui est une copie de la ArrayList etudiants.
     *
     * @return Un tableau d'objets Etudiant.
     */
    public Etudiant[] getEtudiants() {
        return etudiants.toArray(new Etudiant[0]);
    }

}

package com.swing.etudiants.PEtudiant;

import com.swing.etudiants.Matiere;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Etudiant {
    String nom;
    String prenom;
    Matiere[] matiere;

    public Etudiant(String nom, String prenom, Matiere[] matiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.matiere = matiere;
    }

    /**
     * Il renvoie la moyenne de la moyenne des notes de toutes les matières
     *
     * @return La moyenne des notes de l'élève.
     */
    public Double moyenne() {
        Double moyenne = 0.0;
        for (Matiere matiere : matiere) {
            moyenne += matiere.getMoyenne();
        }
        return moyenne / matiere.length;
    }

    /**
     * Il écrit le nom, le prénom et la moyenne de l'élève dans un fichier
     */
    public void saveStudent() {
        File file = new File("src/com/swing/etudiants/listeClasse");
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(this.nom + ";" + this.prenom + ";" + this.moyenne() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Il lit le fichier, divise les lignes, divise les données, crée un tableau de matières et ajoute l'étudiant à la
     * liste
     *
     * @return Une liste d'étudiants
     */
    public static ArrayList<Etudiant> getEtudiants() {
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        File file = new File("src/com/swing/etudiants/listeClasse");
        if (file.exists() && file.length() > 0) {
            try {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine();
                String[] data = line.split("\n");
                for (String datum : data) {
                    String[] dataEtudiant = datum.split(";");
                    String nom = dataEtudiant[0];
                    String prenom = dataEtudiant[1];
                    String[] dataMatiere = dataEtudiant[2].split(",");
                    Matiere[] matieres = new Matiere[dataMatiere.length];
                    etudiants.add(new Etudiant(nom, prenom, matieres));
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return etudiants;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Matiere[] getMatiere() {
        return matiere;
    }
}

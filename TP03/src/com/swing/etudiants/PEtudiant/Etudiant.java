package com.swing.etudiants.PEtudiant;

import com.swing.etudiants.Matiere;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public void afficherNote() {
    }

    public void afficherNote(String matiere) {
    }

    public Double moyenne() {
        Double moyenne = 0.0;
        for (Matiere matiere : matiere) {
            moyenne += matiere.getMoyenne();
        }
        return moyenne / matiere.length;
    }

    public void saveStudent() {
        // save student in a file
        File file = new File("src/com/swing/etudiants/PEtudiant/listeClasse");
        try {
            if (file.createNewFile()) {
                try {
                    FileWriter writer = new FileWriter(file, true);
                    writer.write(this.nom + ";" + this.prenom + ";" + this.moyenne() + ";\n");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                throw new FileNotFoundException("Le fichier existe déjà");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

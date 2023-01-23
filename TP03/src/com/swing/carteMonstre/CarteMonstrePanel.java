package com.swing.carteMonstre;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

import com.swing.yugioh.*;
import utils.utils;

public class CarteMonstrePanel extends JPanel {

    public CarteMonstrePanel() {
        initialize();
    }

    public void initialize() {
        setLayout(null);
        setBackground(Color.decode("#272640"));
        setPreferredSize(new Dimension(1024, 720));

        Monstre monstre = new Monstre("Invocateur Dragon Bleu", "YS14-FR017", "Si cette carte est envoyée depuis le Terrain au Cimetière : vous pouvez ajouter 1 Monstre Normal de Type Dragon/ Guerrier/Magicien depuis votre Deck à votre main.", 4, EnumAttributsMonstre.attribut.VENT, "Magicien/Effet", 1500, 600);
//        MagiePiege magie = new MagiePiege("Typhon d’Espace Mystique", "Ciblez 1 Carte Magie/Piège sur le Terrain ; détruisez la cible.", "YS14-FR024", EnumTypeMagiePiege.type.MAGIE, EnumIcones.icone.JeuRapide);
//        MagiePiege piege = new MagiePiege("Sortilège de l’ombre", "Activez cette carte en ciblant 1 monstre face recto contrôlé par votre adversaire ; il perd 700 ATK, et aussi, il ne peut ni attaquer ni changer sa position de combat.\n" +
//                "Lorsqu’il quitte le Terrain, détruisez cette carte.", "YS14-FR035", EnumTypeMagiePiege.type.PIEGE, EnumIcones.icone.Continu);

        JLabel nom = new JLabel(monstre.getNom());
        nom.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        nom.setForeground(Color.decode("#7F9AB3"));
        nom.setBounds(10, 10, 200, 20);
        add(nom);
        JLabel numero = new JLabel(monstre.getNumero());
        numero.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        numero.setForeground(Color.decode("#7F9AB3"));
        numero.setBounds(10, 30, 200, 20);
        add(numero);
        JLabel description = new JLabel(monstre.getDescription());
        description.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        description.setForeground(Color.decode("#7F9AB3"));
        description.setBounds(10, 50, 1000, 20);
        add(description);
        JLabel niveau = new JLabel("Niveau : " + monstre.getNiveau());
        niveau.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        niveau.setForeground(Color.decode("#7F9AB3"));
        niveau.setBounds(10, 70, 200, 20);
        add(niveau);
        JLabel attribut = new JLabel("Attribut : " + monstre.getAttribut());
        attribut.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        attribut.setForeground(Color.decode("#7F9AB3"));
        attribut.setBounds(10, 90, 200, 20);
        add(attribut);
        JLabel type = new JLabel("Type : " + monstre.getType());
        type.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        type.setForeground(Color.decode("#7F9AB3"));
        type.setBounds(10, 110, 200, 20);
        add(type);
        JLabel atk = new JLabel("ATK : " + monstre.getAtk());
        atk.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        atk.setForeground(Color.decode("#7F9AB3"));
        atk.setBounds(10, 130, 200, 20);
        add(atk);
        JLabel def = new JLabel("DEF : " + monstre.getDef());
        def.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        def.setForeground(Color.decode("#7F9AB3"));
        def.setBounds(10, 150, 200, 20);
        add(def);

        JButton sauvegarder = new JButton("Sauvegarder");
        sauvegarder.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
        sauvegarder.setForeground(Color.decode("#7F9AB3"));
        sauvegarder.setBackground(Color.decode("#272640"));
        sauvegarder.setBounds(10, 170, 200, 20);
        sauvegarder.addActionListener(e -> {
            try {
                monstre.saveCarte(monstre.getNumero(), new File("src/com/swing/yugioh/savedCartes/monstres/" + monstre.getNumero() + ".txt"));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        try {
            File file = new File("src/com/swing/yugioh/savedCartes/monstres/", monstre.getNumero() + ".txt");
            monstre.saveCarte(monstre.getNumero(), file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // foreach file in savedCartes
        // loadCarte(file)
        JComboBox<String> comboBox = new JComboBox<>();
        for (File file : new File("src/com/swing/yugioh/savedCartes/monstres/").listFiles()) {
            comboBox.addItem(file.getName().replace(".txt", ""));
            comboBox.setBounds(50, 350, 300, 50);
            add(comboBox);
            String x = String.valueOf(comboBox.getSelectedItem());
        }
        // on selection change -> loadCarte(selectedItem)
/*        comboBox.addActionListener(e -> {
            try {
                Monstre monstre1 = Monstre.loadCarte(comboBox.getSelectedItem().toString());
                nom.setText(monstre1.getNom());
                numero.setText(monstre1.getNumero());
                description.setText(monstre1.getDescription());
                niveau.setText("Niveau : " + monstre1.getNiveau());
                attribut.setText("Attribut : " + monstre1.getAttribut());
                type.setText("Type : " + monstre1.getType());
                atk.setText("ATK : " + monstre1.getAtk());
                def.setText("DEF : " + monstre1.getDef());
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });*/
    }
}

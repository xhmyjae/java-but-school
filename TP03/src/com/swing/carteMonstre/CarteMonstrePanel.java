package com.swing.carteMonstre;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

import com.swing.yugioh.*;

public class CarteMonstrePanel extends JPanel {

    public CarteMonstrePanel() {
        initialize();
    }

    public void initialize() {
        setLayout(null);
        setBackground(Color.decode("#272640"));
        setPreferredSize(new Dimension(1024, 720));

        Monstre monstre = new Monstre("Invocateur Dragon Bleu", "YS14-FR017","Si cette carte est envoyée depuis le Terrain au Cimetière : vous pouvez ajouter 1 Monstre Normal de Type Dragon/ Guerrier/Magicien depuis votre Deck à votre main.", 4, EnumAttributsMonstre.attribut.VENT, "Magicien/Effet", 1500, 600);
        MagiePiege magie = new MagiePiege("Typhon d’Espace Mystique","Ciblez 1 Carte Magie/Piège sur le Terrain ; détruisez la cible.", "YS14-FR024",EnumTypeMagiePiege.type.MAGIE, EnumIcones.icone.JeuRapide);
        MagiePiege piege = new MagiePiege("Sortilège de l’ombre","Activez cette carte en ciblant 1 monstre face recto contrôlé par votre adversaire ; il perd 700 ATK, et aussi, il ne peut ni attaquer ni changer sa position de combat.\n" +
                "Lorsqu’il quitte le Terrain, détruisez cette carte.", "YS14-FR035", EnumTypeMagiePiege.type.PIEGE, EnumIcones.icone.Continu);

        JLabel nomMonstre = new JLabel(monstre.getNom());
        nomMonstre.setBounds(50, 50, 300, 50);
        add(nomMonstre);
        JLabel nomMagie = new JLabel(magie.getNom());
        nomMagie.setBounds(50, 150, 300, 50);
        add(nomMagie);
        JLabel nomPiege = new JLabel(piege.getNom());
        nomPiege.setBounds(50, 250, 300, 50);
        add(nomPiege);

        try {
            File file = new File("src/com/swing/yugioh/savedCartes",monstre.getNumero() + ".txt");
            monstre.saveCarte(monstre.getNumero(), file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

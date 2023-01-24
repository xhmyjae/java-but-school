package com.swing.yugioh;

public class Deck {
    private Carte[] deck;
    private int nbCartes;

    public Deck(Carte[] deck, int nbCartes) {
        this.deck = deck;
        this.nbCartes = nbCartes;
    }

    public Carte[] getDeck() {
        return deck;
    }

    public int getNbCartes() {
        return nbCartes;
    }

    public void setDeck(Carte[] deck) {
        this.deck = deck;
    }

    public void setNbCartes(int nbCartes) {
        this.nbCartes = nbCartes;
    }

    public void addCarte(Carte carte) {
        if (nbCartes < 60) {
            deck[nbCartes] = carte;
            nbCartes++;
        }
    }

    public void removeCarte(Carte carte) {
        if (nbCartes > 40) {
            for (int i = 0; i < nbCartes; i++) {
                if (deck[i].getNumero().equals(carte.getNumero())) {
                    deck[i] = null;
                    nbCartes--;
                }
            }
        }
    }

    public boolean isCardInDeck(Carte carte) {
        int nbCopies = 0;
        for (int i = 0; i < nbCartes; i++) {
            if (deck[i].getNumero().equals(carte.getNumero())) {
                nbCopies++;
            }
        }
        return nbCopies < 3;
    }

    public void shuffleDeck() {
        for (int i = 0; i < nbCartes; i++) {
            int random = (int) (Math.random() * nbCartes);
            Carte temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
    }

    // generate deck where 50 % are monsters and 50 % are spells
    public void generateDeck() {
        for (int i = 0; i < 30; i++) {
            Monstre monstre = Monstre.generateRandomMonsterCard();
            deck[i] = monstre;
        }
//        for (int i = 30; i < 60; i++) {
//            MagiePiege magiePiege = new MagiePiege();
//            deck[i] = magiePiege;
//        }
    }

}

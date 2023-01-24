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

    /**
     * > Cette fonction ajoute une carte au jeu s'il y a de la place dans le jeu
     *
     * @param carte la carte à ajouter au jeu
     */
    public void addCarte(Carte carte) {
        if (nbCartes < 60) {
            deck[nbCartes] = carte;
            nbCartes++;
        }
    }

    /**
     * Il retire une carte du jeu
     *
     * @param carte la carte à retirer
     */
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

    /**
     * Il vérifie si une carte est dans le jeu
     *
     * @param carte la carte à vérifier
     * @return Le nombre de copies de la carte dans le jeu.
     */
    public boolean isCardInDeck(Carte carte) {
        int nbCopies = 0;
        for (int i = 0; i < nbCartes; i++) {
            if (deck[i].getNumero().equals(carte.getNumero())) {
                nbCopies++;
            }
        }
        return nbCopies < 3;
    }

    /**
     * Nous parcourons le jeu et échangeons chaque carte avec une carte aléatoire dans le jeu
     */
    public void shuffleDeck() {
        for (int i = 0; i < nbCartes; i++) {
            int random = (int) (Math.random() * nbCartes);
            Carte temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
    }

    /**
     * Il génère un jeu de 60 cartes, 30 monstres et 30 cartes magie/piège
     */
    public void generateDeck() {
        for (int i = 0; i < 30; i++) {
            Monstre monstre = Monstre.generateRandomMonsterCard();
            deck[i] = monstre;
        }
        for (int i = 30; i < 60; i++) {
            MagiePiege magiePiege = MagiePiege.generateRandomMagiePiegeCard();
            deck[i] = magiePiege;
        }
    }

}

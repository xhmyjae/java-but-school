package com.swing.yugioh;

import java.util.Map;

public class Tapis {
    private Map<Monstre, Integer> zoneMonstres;
    private Map<MagiePiege, Boolean> zoneMagiePiege;
    private Carte[] cimetiere;
    private Deck deck;
    private Carte[] terrain;
    private Carte[] zoneExtraDeck;
    private Carte[] zonePendule;

    public Tapis(Map<Monstre, Integer> zoneMonstres, Map<MagiePiege, Boolean> zoneMagiePiege, Carte[] cimetiere, Deck deck, Carte[] terrain, Carte[] zoneExtraDeck, Carte[] zonePendule) {
        this.zoneMonstres = zoneMonstres;
        this.zoneMagiePiege = zoneMagiePiege;
        this.cimetiere = cimetiere;
        this.deck = deck;
        this.terrain = terrain;
        this.zoneExtraDeck = zoneExtraDeck;
        this.zonePendule = zonePendule;
    }

    public Map<Monstre, Integer> getZoneMonstres() {
        return zoneMonstres;
    }

    public Map<MagiePiege, Boolean> getZoneMagiePiege() {
        return zoneMagiePiege;
    }

    public Carte[] getCimetiere() {
        return cimetiere;
    }

    public Deck getDeck() {
        return deck;
    }

    public Carte[] getTerrain() {
        return terrain;
    }

    public Carte[] getZoneExtraDeck() {
        return zoneExtraDeck;
    }

    public Carte[] getZonePendule() {
        return zonePendule;
    }
}

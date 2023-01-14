package com.swing.yugioh;

public class Monstre extends Carte {
    private Integer niveau;
    private EnumAttributsMonstre.attribut attribut;
    private String type;
    private Integer atk;
    private Integer def;

    public Monstre(String nom, String description, String numero, Integer niveau, EnumAttributsMonstre.attribut attribut, String type, Integer atk, Integer def) {
        super(nom, description, numero);
        this.niveau = niveau;
        this.attribut = attribut;
        this.type = type;
        this.atk = atk;
        this.def = def;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public EnumAttributsMonstre.attribut getAttribut() {
        return attribut;
    }

    public String getType() {
        return type;
    }

    public Integer getAtk() {
        return atk;
    }

    public Integer getDef() {
        return def;
    }
}

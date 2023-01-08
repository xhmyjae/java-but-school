package com.swing.afficherCartes;

public class Card {
    private String name;
    private String value;
    private String color;
    private String image;

    public Card(String name, String value, String color, String image) {
        this.name = name;
        this.value = value;
        this.color = color;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public String getImage() {
        return image;
    }
}

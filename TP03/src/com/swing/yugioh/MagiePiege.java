package com.swing.yugioh;

public class MagiePiege extends Carte {
    private EnumTypeMagiePiege.type type;
    private EnumIcones.icone icone;

    public MagiePiege(String nom, String description, String numero, EnumTypeMagiePiege.type type, EnumIcones.icone icone) {
        super(nom, description, numero);
        this.type = type;
        this.icone = icone;
    }

    public EnumTypeMagiePiege.type getType() {
        return type;
    }

    public EnumIcones.icone getIcone() {
        return icone;
    }
}

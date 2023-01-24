package com.swing.yugioh;

import java.io.File;
import java.io.FileNotFoundException;

public interface ICarteYuGiOh {
    
    public String getNom();
    public String getNumero();
    public String getDescription();
    public String getCardType();

    public void saveCarte(String numero) throws FileNotFoundException;
    public void loadCarte(String numero) throws FileNotFoundException;
}

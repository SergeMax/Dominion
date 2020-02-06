package models;

import models.cartes.Carte;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Carte> cartes;
    private int indiceDansLeDeck;

    public Deck(){

    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public int getIndiceDansLeDeck() {
        return indiceDansLeDeck;
    }
}

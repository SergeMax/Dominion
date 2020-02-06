package models;

import models.cartes.Carte;

import java.util.ArrayList;
import java.util.Collections;

public class Joueur {
    private String nom;
    private int pV;
    private ArrayList<Carte> deck;
    private int indiceDansLeDeck;
    private byte monnaie;
    private byte action;
    private byte achat;
    private boolean entrainDeJouer;
    private boolean doitDefausser;

    public Joueur(){
        indiceDansLeDeck=0;
    }

    public void poserUneCarte(Carte carte){

    }

    public void defausseUneCarte(Carte carte) {

    }

    public void ecarteUneCarte(Carte carte){

    }

    public void melangeSesCartes(){
        Collections.shuffle(deck);
    }

    public String getNom() {
        return nom;
    }

    public int getpV() {
        return pV;
    }

    public ArrayList<Carte> getDeck() {
        return deck;
    }

    public int getIndiceDansLeDeck() {
        return indiceDansLeDeck;
    }

    public byte getMonnaie() {
        return monnaie;
    }

    public byte getAction() {
        return action;
    }

    public byte getAchat() {
        return achat;
    }

    public boolean isEntrainDeJouer() {
        return entrainDeJouer;
    }

    public boolean isDoitDefausser() {
        return doitDefausser;
    }
}

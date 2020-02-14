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

    public void piocheDesCarte(int nbDeCarte){

    }

    public void poserUneCarte(Carte carte){

    }

    public void defausseUneCarte(Carte carte) {

    }

    public void ecarteUneCarte(Carte carte){

    }

    public void recevoirUneCarteDeValeur(int valeur){

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

    public void setpV(int pV) {
        this.pV = pV;
    }

    public void setMonnaie(byte monnaie) {
        this.monnaie = monnaie;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public void setAchat(byte achat) {
        this.achat = achat;
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

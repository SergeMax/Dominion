package models;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;

import java.util.ArrayList;
import java.util.Collections;

public class Joueur {
    private String nom;
    private int pV;
    private Deck deck;
    private int indiceDansLeDeck;
    private byte monnaie;
    private byte action;
    private byte achat;
    private boolean entrainDeJouer;
    private boolean doitDefausser;

    public Joueur(String nom){
        this.nom = nom;
        pV = 3;
        monnaie = 0;
        action = 1;
        achat = 1;
        indiceDansLeDeck=0;
        deck = new Deck();
    }

    public Carte clicqueSurUneCarte(String className){
        Carte selectedCarte = null;
        for(Carte carte: deck.getCartes()){
            if(carte.getClass().getSimpleName().contains(className) && carte.getLocalisation().equals(LocalisationDesCartes.mainJoueur)){
                return  carte;
            }
        }
        return selectedCarte;
    }

    public void piocheDesCarte(int nbDeCarte){

    }

    public void poserUneCarte(Carte carte){
        carte.setLocalisation(LocalisationDesCartes.terrain);
    }

    public void defausseUneCarte(Carte carte) {

    }

    public void ecarteUneCarte(Carte carte){

    }

    public void recevoirUneCarteDeValeur(int valeur){

    }

    public void placerUnCarteSurLeDessusDuDeck(){

    }

    public ArrayList<Pile> getAgregationDeCarteEnPile(){
        return Pile.aggregationDeCarteEnPile(deck.getCartes());
    }

    public String getNom() {
        return nom;
    }

    public int getpV() {
        return pV;
    }

    public Deck getDeck() {
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

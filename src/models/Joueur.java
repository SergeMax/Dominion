package models;

import models.cartes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Filter;
import java.util.stream.Collectors;

public class Joueur {
    private String nom;
    private int pV;
    private Deck deck;
    public ArrayList<Pile> piles;
    private int indiceDansLeDeck;
    public byte monnaie;
    public byte action;
    public byte achat;
    private boolean entrainDeJouer;
    private boolean doitDefausser;

    public Joueur(String nom){
        this.nom = nom;
        pV = 3;
        indiceDansLeDeck=0;
        deck = new Deck();
    }

    /* On initialise le début du tour */
    public void startTurn(){
        this.monnaie = 0;
        this.achat = 1;
        this.action = 1;
        setEntrainDeJouer(true);
        for (int i = 0; i < 5 ; i++) {
            if(indiceDansLeDeck >= deck.getCartes().size()){
                break;
            }
            deck.getCartes().get(indiceDansLeDeck).setLocalisation(LocalisationDesCartes.mainJoueur);
            indiceDansLeDeck++;
        }
        piles = Pile.aggregationDeCarteEnPile(deck.getCartes());
    }

    public Carte selectCardInHande(Carte carte){
        return deck.getCartes().stream().filter(item -> item.getLocalisation().equals(LocalisationDesCartes.mainJoueur) && item.getName().equals(carte.getName())).collect(Collectors.toCollection(ArrayList::new)).get(0);
    }

    public void acheteCarte(Carte carte){
        deck.getCartes().add(DistributeurDeCarte.distribueOneCarte(IdCarte.valueOf(carte.getName().toUpperCase())));
    };

    public void piocheDesCarte(int nbDeCarte){

    }

    public void poserUneCarte(Carte carte){
        Carte corespondedcarte = selectCardInHande(carte);
        corespondedcarte.setLocalisation(LocalisationDesCartes.terrain);
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setIndiceDansLeDeck(int indiceDansLeDeck) {
        this.indiceDansLeDeck = indiceDansLeDeck;
    }

    public void setEntrainDeJouer(boolean entrainDeJouer) {
        this.entrainDeJouer = entrainDeJouer;
    }

    public void setDoitDefausser(boolean doitDefausser) {
        this.doitDefausser = doitDefausser;
    }


}

package models;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.DistributeurDeCarte;
import models.cartes.TypeDeCarte;
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
    private boolean estFinis;
    private int auTourDuJoueur = 0;
    private int numeroDeLaPhase = 1;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Pile> pilesReserveAction;
    private ArrayList<Pile> pilesReserveTresorVictoireMalediction;

    public Joueur(String nomJoueur){
        this.nom = nom;
        pV = 3;
        indiceDansLeDeck=0;
        deck = new Deck();
    }

    public static void main(String[] args) {
    }

    /* On initialise le début du tour */
    public void startTurn(){
        this.monnaie = 0;
        this.achat = 1;
        this.action = 1;
    }

    /* On termine le tour */
    public void endTurn(){
        setEntrainDeJouer(false);
        if(numeroDeLaPhase==3){
            /* défausser la main au deck, on vérifie si la valeur du deck est égal ou supérieur à 5, si non, on mélange la défausse
        avec le deck avant de piocher */
            //if deck < 5
            //deck.melangeSesCartes();
            // J'aurais besoin de comprendre comment la classe Pile fonctionne, on dirait qu'on pourrait l'utiliser pour la défausse,
            // mélange et pioche
            auTourDuJoueur++;
            if(auTourDuJoueur<joueurs.size()){
                auTourDuJoueur=0;
            }
        }
    }

    public void joueurTour(Carte carte){
        /* Initialisation des phases du joueurs */
        startTurn();
        /* Phase Action */
        /* On commence par la première phase, qui est la phase Action */
        if(numeroDeLaPhase == 1){
            /* On vérifie si le joueur peut faire des actions */
            if(action > 0){
                /* On recherche la carte du joueur dans sa main */
                carte.getLocalisation().equals(LocalisationDesCartes.mainJoueur);
                joueurs.get(auTourDuJoueur).poserUneCarte(carte);
                /* Activation de l'effet de la carte */
                carte.effet(joueurs);
            }else{
                /* On fait avancer la phase du joueur à la phase Achat */
                numeroDeLaPhase++;
            }
        }
        /* Phase Achat */
        /* Si le joueur clique sur une carte Achat alors qu'il est en phase 1, sa phase passera à la deuxième phase */
        if (carte.getType().equals(TypeDeCarte.tresor) && numeroDeLaPhase == 1){
            numeroDeLaPhase++;
        }
        if (numeroDeLaPhase == 2 ){
            if(carte.getType().equals(TypeDeCarte.tresor)){
                /* joueur reçoit une carte de la pile si monnaie >= coût et reste dans le tour si il peut encore acheter */
            }
        }

        endTurn();
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

    public void decrementeAction(int nb){
        action -= nb;
    }

    public void incrementeAction(int nb){
        action += nb;
    }

    public void decrementeAchat(int nb){
        achat -= nb;
    }

    public void incrementeAchat(int nb){
        achat += nb;
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

    public boolean isEstFinis() {
        return estFinis;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public ArrayList<Pile> getPilesReserveAction() {
        return pilesReserveAction;
    }

    public ArrayList<Pile> getPilesReserveTresorVictoireMalediction() {
        return pilesReserveTresorVictoireMalediction;
    }

    public void setEstFinis(boolean estFinis) {
        this.estFinis = estFinis;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void setPilesReserveAction(ArrayList<Pile> pilesReserveAction) {
        this.pilesReserveAction = pilesReserveAction;
    }

    public void setPilesReserveTresorVictoireMalediction(ArrayList<Pile> pilesReserveTresorVictoireMalediction) {
        this.pilesReserveTresorVictoireMalediction = pilesReserveTresorVictoireMalediction;
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

    public void setAuTourDuJoueur(int auTourDuJoueur) {
        this.auTourDuJoueur = auTourDuJoueur;
    }

    public void setNumeroDeLaPhase(int numeroDeLaPhase) {
        this.numeroDeLaPhase = numeroDeLaPhase;
    }
}

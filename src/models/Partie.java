package models;

import models.cartes.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Partie {
    private boolean estFinis;
    private int auTourDuJoueur = 0;
    private int numeroDeLaPhase = 1;
    private Carte hasSpecialEffect = null;
    private int effectTurnAction = 0;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Pile> pilesReserveAction;
    private ArrayList<Pile> pilesReserveTresorVictoireMalediction;

    public Partie(int nombreDeJoueur){
        estFinis= false;
        joueurs = new ArrayList<Joueur>();
        for(int i = 0; i < nombreDeJoueur; i++ ){
            Joueur joueur = new Joueur("Joueur " + (i+1));
            joueur.prepareTurn();
            joueurs.add(joueur);
        }
        joueurs.get(auTourDuJoueur).setEntrainDeJouer(true);
        pilesReserveAction = DistributeurDeCarte.radomPileAction();
        pilesReserveTresorVictoireMalediction = DistributeurDeCarte.distribuePileTresorVictoireMalediction();
    }

    public Pile cliqueSurUneCarte(String hashcode){
        for(Pile pile: joueurs.get(auTourDuJoueur).piles){
            if(String.valueOf(pile.hashCode()).equals(hashcode)){
                return pile;
            }
        }
        for(Pile pile: pilesReserveAction){
            if(String.valueOf(pile.hashCode()).equals(hashcode)){
                return pile;
            }
        }
        for(Pile pile: pilesReserveTresorVictoireMalediction){
            if(String.valueOf(pile.hashCode()).equals(hashcode)){
                return pile;
            }
        }
        return null;
    }

    public void tour(Pile pile){
        Carte carte = pile.getCarte();

    if(!checkEndGame()) {
        /* SI ON EST DANS UNE PHASE SPECIAL */
        if(hasSpecialEffect != null){
            processEffect(pile);
        }
        /* PHASE ACTION */
        if(numeroDeLaPhase == 1) {
            /* SI LE JOUEUR CLIQUE UNE CARTE ACTION DANS LA MAIN */
            if (joueurs.get(auTourDuJoueur).getDeck().getCartes().stream().filter(item -> (item.getType().equals(TypeDeCarte.actions) || item.getType().equals(TypeDeCarte.attaque_action)) && item.getLocalisation().equals(LocalisationDesCartes.mainJoueur)).collect(Collectors.toCollection(ArrayList::new)).size() != 0) {
                joueurs.get(auTourDuJoueur).poserUneCarte(carte);
                carte.effet(this);
                joueurs.get(auTourDuJoueur).action--;
                if (joueurs.get(auTourDuJoueur).getAction() == 0) {
                    numeroDeLaPhase++;
                }
            } else {
                numeroDeLaPhase++;
            }
        }

        /* PHASE ACHAT*/
        if (numeroDeLaPhase == 2) {
            /* SI LE JOUEUR CLIQUE UNE CARTE DE SA MAIN ET QUE C'EST UNE CARTE TRESOR */
            if (carte.getLocalisation().equals(LocalisationDesCartes.mainJoueur) && (carte.getName().equals("Cuivre") || carte.getName().equals("Or") || carte.getName().equals("Argent"))) {
                joueurs.get(auTourDuJoueur).poserUneCarte(carte);
                carte.effet(this);
                /* SI LE JOUEUR CLIQUE SUR UNE CARTE DE LA RESERVE ET A ASSEZ DE THUNE ET D'ACHAT*/
            } else if (carte.getLocalisation().equals(LocalisationDesCartes.reserve) && joueurs.get(auTourDuJoueur).getMonnaie() >= carte.getCout()) {
                joueurs.get(auTourDuJoueur).acheteCarte(carte);
                pile.nombre--;
                joueurs.get(auTourDuJoueur).monnaie -= carte.getCout();
                joueurs.get(auTourDuJoueur).achat--;
                if (carte.getType().equals(TypeDeCarte.victoire)){
                    carte.effet(this);
                }
            }
            if (joueurs.get(auTourDuJoueur).getAchat() == 0) {
                numeroDeLaPhase++;
            }
        }
        /* FIN DE TOUR */
        if (numeroDeLaPhase == 3) {
            numeroDeLaPhase = 1;
            endTurn();
        }
        joueurs.get(auTourDuJoueur).piles = Pile.aggregationDeCarteEnPile(joueurs.get(auTourDuJoueur).getDeck().getCartes());
        System.out.println(numeroDeLaPhase);
    }
        if(hasSpecialEffect != null && effectTurnAction != 0){
            switchPlayer();
            processEffect(pile);
        }
    }

    public void switchPlayer() {
            auTourDuJoueur++;
            if (auTourDuJoueur >= joueurs.size()) {
                auTourDuJoueur = 0;
            }
    }

    public void processEffect(Pile pile){
        if(hasSpecialEffect.getName().toUpperCase().equals(IdCarte.MILLICE.toString())) {
            if(pile.getCarte().getLocalisation().equals(LocalisationDesCartes.mainJoueur)){
                joueurs.get(auTourDuJoueur).defausseUneCarte(pile.getCarte());
                effectTurnAction--;
            }

        } else if(hasSpecialEffect.getName().toUpperCase().equals(IdCarte.SORCIERE.toString())) {

        }

        if(effectTurnAction == 0){
            switchPlayer();
            hasSpecialEffect = null;
        }
    }

    public void endTurn(){
        joueurs.get(auTourDuJoueur).setEntrainDeJouer(false);
        for(Carte carteADefausse : joueurs.get(auTourDuJoueur).getDeck().getCartes().stream().filter(item -> item.getLocalisation().equals(LocalisationDesCartes.mainJoueur) || item.getLocalisation().equals(LocalisationDesCartes.terrain)).collect(Collectors.toCollection(ArrayList::new))){
            carteADefausse.setLocalisation(LocalisationDesCartes.defausse);
        }
        if(joueurs.get(auTourDuJoueur).getDeck().getCartes().stream().filter(item -> item.getLocalisation().equals(LocalisationDesCartes.deck)).collect(Collectors.toCollection(ArrayList::new)).size() < 5){
            System.out.println("Je melange Le deck");
            joueurs.get(auTourDuJoueur).getDeck().melangeSesCartes();
            joueurs.get(auTourDuJoueur).setIndiceDansLeDeck(-1);
        }
        joueurs.get(auTourDuJoueur).prepareTurn();
        auTourDuJoueur++;
        if(auTourDuJoueur>=joueurs.size()){
            auTourDuJoueur=0;
        }
        joueurs.get(auTourDuJoueur).setEntrainDeJouer(true);
    }

    public boolean checkEndGame(){
        int tasVide = 0;
        for(Pile pile: pilesReserveTresorVictoireMalediction){
            if(pile.getCarte().getName().toUpperCase().equals(IdCarte.DOMAINE.name()) && pile.getNombre() <= 0){
                return true;
            }
            if(pile.getNombre() == 0){
                tasVide++;
            }
        }
        for(Pile pile: pilesReserveAction){
            if(pile.getNombre() == 0){
                tasVide++;
            }
        }
        if(tasVide >= 3){
            return true;
        }

        return false;
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

    public int getAuTourDuJoueur() {
        return auTourDuJoueur;
    }

    public int getNumeroDeLaPhase() {
        return numeroDeLaPhase;
    }

    public void setHasSpecialEffect(Carte hasSpecialEffect) {
        this.hasSpecialEffect = hasSpecialEffect;
    }

    public int getJoueurAdverse(){
        for(int i = 0; i < joueurs.size(); i++){
            if(!joueurs.get(i).isEntrainDeJouer()){
                return i;
            }
        }
        return 0;
    }
}

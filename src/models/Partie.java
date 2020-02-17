package models;

import models.cartes.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Partie {
    private boolean estFinis;
    private int auTourDuJoueur = 0;
    private int numeroDeLaPhase = 1;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Pile> pilesReserveAction;
    private ArrayList<Pile> pilesReserveTresorVictoireMalediction;

    public Partie(int nombreDeJoueur){
        estFinis= false;
       joueurs = new ArrayList<Joueur>();
        for(int i = 0; i < nombreDeJoueur; i++ ){
            joueurs.add(new Joueur("Joueur " + (i+1)));
        }
        pilesReserveAction = DistributeurDeCarte.radomPileAction();
        pilesReserveTresorVictoireMalediction = DistributeurDeCarte.distribuePileTresorVictoireMalediction();
        joueurs.get(0).startTurn();
    }

    public static void main(String[] args) {
        Partie partie = new Partie(2);
        Carte carte = DistributeurDeCarte.distribueOneCarte(IdCarte.PROVINCE);
        System.out.println(carte.hashCode());
    }

    public void skipTurn(){
        endTurn();
        joueurs.get(auTourDuJoueur).startTurn();
    }

    public Carte cliqueSurUneCarte(String hashcode){
        for(Pile pile: joueurs.get(auTourDuJoueur).piles){
            if(String.valueOf(pile.hashCode()).equals(hashcode)){
                return pile.getCarte();
            }
        }
        for(Pile pile: pilesReserveAction){
            if(String.valueOf(pile.hashCode()).equals(hashcode)){
                return pile.getCarte();
            }
        }
        for(Pile pile: pilesReserveAction){
            if(String.valueOf(pile.hashCode()).equals(hashcode)){
                return pile.getCarte();
            }
        }
        return null;
    }

    public void tour(Carte carte){

        /* PHASE ACTION */
        if(numeroDeLaPhase==1){
            /* SI LE JOUEUR CLIQUE UNE CARTE ACTION DANS LA MAIN */
            if(joueurs.get(auTourDuJoueur).getDeck().getCartes().stream().filter(item -> (item.getType().equals(TypeDeCarte.actions) || item.getType().equals(TypeDeCarte.attaque_action)) && item.getLocalisation().equals(LocalisationDesCartes.mainJoueur)).collect(Collectors.toCollection(ArrayList::new)).size() != 0){
                joueurs.get(auTourDuJoueur).poserUneCarte(carte);
                joueurs.get(auTourDuJoueur).action--;
                if(joueurs.get(auTourDuJoueur).getAction() == 0){
                    numeroDeLaPhase++;
                }
            } else {
                numeroDeLaPhase++;
            }
        }

        /* PHASE ACHAT*/
        if (numeroDeLaPhase==2){
            /* SI LE JOUEUR CLIQUE UNE CARTE DE SA MAIN ET QUE C'EST UNE CARTE TRESOR */
            if(carte.getLocalisation().equals(LocalisationDesCartes.mainJoueur) && (carte.getName().equals("Cuivre") || carte.getName().equals("Or") || carte.getName().equals("Argent"))){
                    joueurs.get(auTourDuJoueur).poserUneCarte(carte);
                /* SI LE JOUEUR CLIQUE SUR UNE CARTE DE LA RESERVE ET A ASSEZ DE THUNE ET D'ACHAT*/
            } else if(carte.getLocalisation().equals(LocalisationDesCartes.reserve) && joueurs.get(auTourDuJoueur).getAchat() != 0 && joueurs.get(auTourDuJoueur).getMonnaie() >= carte.getCout()){
                    joueurs.get(auTourDuJoueur).acheteCarte(carte);
                    joueurs.get(auTourDuJoueur).achat--;
            }
            if(joueurs.get(auTourDuJoueur).getAchat() == 0) {
                numeroDeLaPhase++;
            }
        }
        /* FIN DE TOUR */
        if(numeroDeLaPhase==3){
            endTurn();
        }
        joueurs.get(auTourDuJoueur).piles = Pile.aggregationDeCarteEnPile(joueurs.get(auTourDuJoueur).getDeck().getCartes());
        System.out.println(numeroDeLaPhase);
    }

    public void endTurn(){
        joueurs.get(auTourDuJoueur).setEntrainDeJouer(false);
        auTourDuJoueur++;
        if(auTourDuJoueur<=joueurs.size()){
            auTourDuJoueur=0;
        }
        for(Carte carteADefausse : joueurs.get(auTourDuJoueur).getDeck().getCartes().stream().filter(item -> item.getLocalisation().equals(LocalisationDesCartes.mainJoueur) && item.getLocalisation().equals(LocalisationDesCartes.terrain)).collect(Collectors.toCollection(ArrayList::new))){
            carteADefausse.setLocalisation(LocalisationDesCartes.defausse);
        }
        if(joueurs.get(auTourDuJoueur).getDeck().getCartes().stream().filter(item -> item.getLocalisation().equals(LocalisationDesCartes.deck)).collect(Collectors.toCollection(ArrayList::new)).size() < 5){
            joueurs.get(auTourDuJoueur).getDeck().melangeSesCartes();
        }
        joueurs.get(auTourDuJoueur).piles = Pile.aggregationDeCarteEnPile(joueurs.get(auTourDuJoueur).getDeck().getCartes());
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
}

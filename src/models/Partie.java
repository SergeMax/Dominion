package models;

import models.cartes.Carte;
import models.cartes.DistributeurDeCarte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Partie {
    private boolean estFinis;
    private int auTourDuJoueur = 0;
    private int numeroDeLaPhase = 1;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Pile> pilesReserveAction;
    private ArrayList<Pile> pilesReserveTresorVictoireMalediction;

    public Partie(int nombreDeJoueur){
    //    estFinis= false;
    //    joueurs = new ArrayList<Joueur>();
    //    for(int i = 0; i < nombreDeJoueur; i++ ){
    //        joueurs.add(new Joueur("Joueur " + (i+1)));
    //    }
    //    pilesReserveAction = DistributeurDeCarte.radomPileAction();
    //    pilesReserveTresorVictoireMalediction = DistributeurDeCarte.distribuePileTresorVictoireMalediction();
    }

    public static void main(String[] args) {
        Partie partie = new Partie(2);
    }

    public void tour(Carte carte){
        /* PHASE ACTION */
        if(numeroDeLaPhase==1 && carte.getLocalisation().equals(LocalisationDesCartes.mainJoueur) && joueurs.get(auTourDuJoueur).getAction() != 0 ){
            System.out.println("Le joueur peut jouer cette carte");
            joueurs.get(auTourDuJoueur).poserUneCarte(carte);
            carte.effet(joueurs);
            if(joueurs.get(auTourDuJoueur).getAction() != 0){

            }else{
                numeroDeLaPhase++;
            }
        } else {
            System.out.println("Le joueur peut pas jouer cette carte");
        }
        /* PHASE ACHAT */
        if(numeroDeLaPhase==2 && carte.getLocalisation().equals(LocalisationDesCartes.reserve) ){
            if(carte.getType().equals(TypeDeCarte.tresor)){

            }

        }
        /* FIN DE TOUR */
        if(numeroDeLaPhase==3){
            auTourDuJoueur++;
            if(auTourDuJoueur<joueurs.size()){
                auTourDuJoueur=0;
            }
        }
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
}

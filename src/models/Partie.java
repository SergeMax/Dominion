package models;

import models.cartes.Carte;

import java.util.ArrayList;

public class Partie {
    private boolean estFinis;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Pile> pilesReserveAction;
    private ArrayList<Pile> pilesReserveTresorVictoireMalediction;

    public Partie(int nombreDeJoueur){
        estFinis= false;
        joueurs = new ArrayList<Joueur>();
        for(int i = 0; i < nombreDeJoueur; i++ ){
            joueurs.add(new Joueur());
        }
        //pilesReserveAction.add()
    }

    public static void main(String[] args) {
        Partie partie = new Partie(2);
        for(Carte carte : partie.joueurs.get(0).getDeck().getCartes()){
            System.out.println(carte.getUrlImgCarte());
        }
    }
}

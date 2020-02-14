package models;

import java.util.ArrayList;

public class Partie {
    private boolean estFinis;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Pile> piles;

    public Partie(int nombreDeJoueur){
        estFinis= false;
        joueurs = new ArrayList<Joueur>();
        for(int i = 0; i < nombreDeJoueur; i++ ){
            //newJoueur = new
            //joueurs.add(new Joueur());
        }
    }
}

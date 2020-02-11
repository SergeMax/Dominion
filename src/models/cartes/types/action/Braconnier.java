package models.cartes.types.action;

import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Braconnier extends Carte {
    /*
        Donne 1 Carte, 1 Action et 1 pièce
        Effet: Défausser une carte pour chaque pile vide de la réserve.
        Coût: 4 pièces
        Action
     */

    public Braconnier() {
        setCout(4);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(ArrayList<Joueur> joueurs) {
        for(Joueur joueur: joueurs){
            if (joueur.isEntrainDeJouer()){
                joueur.piocheDesCarte(1);
                joueur.getAction();
                
            }
        }
    }

    /*
        Besoin de connaitre le nombre de pile vide sur le terrain, ajouter une action en plus et un achat
     */
}

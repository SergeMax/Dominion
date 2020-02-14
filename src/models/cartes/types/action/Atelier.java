package models.cartes.types.action;
import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Atelier extends Carte {
    /*
        Effet: Recevez une carte coûtant jusqu'à 4 pièces.
        Coût: 3 pièces
        Action
     */

    public Atelier() {
        setCout(3);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    public void effet(ArrayList<Joueur> joueurs) {
        for(Joueur joueur: joueurs){
            if (joueur.isEntrainDeJouer()){
                joueur.recevoirUneCarteDeValeur(4);
            }
        }
    }

    /*
        Le joueur peut choisir une carte sur le terrain ayant une valeur égal ou inférieur à 4
     */
}

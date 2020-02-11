package models.cartes.types.action;

import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Sorciere extends Carte {
    /*
        Donne 2 Cartes
        Effet: Tous vos adversaires reçoivent une malédiction.
        Coût: 5 pièces
        Action - Attaque
     */

    public Sorciere() {
        setCout(5);
        setType(TypeDeCarte.attaque_action);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(ArrayList<Joueur> joueurs) {
        for(Joueur joueur: joueurs){
            if (joueur.isEntrainDeJouer()){
                joueur.piocheDesCarte(2);
            }
        }
    }
}

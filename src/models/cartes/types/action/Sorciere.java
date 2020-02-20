package models.cartes.types.action;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;


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
    public void effet(Partie partie) {
        for(Joueur joueur: partie.getJoueurs()){
            if (joueur.isEntrainDeJouer()){
                joueur.piocheDesCarte(2);
            }
        }
    }
}

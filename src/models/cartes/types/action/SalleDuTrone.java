package models.cartes.types.action;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;


public class SalleDuTrone extends Carte {
    /*
        Effet: Vous pouvez jouer une carte Action de votre main deux fois.
        Coût: 4 pièces
        Action
     */

    public SalleDuTrone() {
        setCout(4);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for (Joueur joueur : partie.getJoueurs()){
            if(joueur.isEntrainDeJouer()){

            }
        }
    }
}

package models.cartes.types.action;

import models.Joueur;
import models.Partie;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;


public class Festival extends Carte {
    /*
        Donne 2 Actions, 1 Achat et 2 pièces
        Coût: 5 pièces
        Action
     */

    public Festival() {
        setCout(5);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    @Override
    public void effet(Partie partie) {
        for (Joueur joueur : partie.getJoueurs()){
            if(joueur.isEntrainDeJouer()){
                joueur.action +=2;
                joueur.achat +=1;
                joueur.monnaie +=2;
            }
        }
    }
}

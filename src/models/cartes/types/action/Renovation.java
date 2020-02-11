package models.cartes.types.action;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Renovation extends Carte {
    /*
        Effet: Écartez une carte de votre main. Recevez une carte coûtant jusqu'à 2 pièces de plus que la carte écartée.
        Coût: 4 pièces
        Action
     */

    public Renovation() {
        setCout(4);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

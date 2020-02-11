package models.cartes.types.action;

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
}

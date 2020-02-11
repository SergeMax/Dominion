package models.cartes.types.action;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Vassal extends Carte {
    /*
        Effet: Défaussez la carte du haut de votre pioche. Si c'est une carte Action, vous pouvez la jouer.
        Coût: 3 pièces
        Action
     */

    public Vassal() {
        setCout(3);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

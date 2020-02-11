package models.cartes.types.victoire;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Province extends Carte {
    /*
        Donne 6 points de victoire
        Coût: 8 pièces
     */

    public Province() {
        setCout(8);
        setType(TypeDeCarte.tresor);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

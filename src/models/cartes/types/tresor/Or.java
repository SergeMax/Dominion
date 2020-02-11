package models.cartes.types.tresor;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Or extends Carte {
    /*
        Donne 3 pièces
        Coût: 6 pièces
     */

    public Or() {
        setCout(6);
        setType(TypeDeCarte.tresor);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

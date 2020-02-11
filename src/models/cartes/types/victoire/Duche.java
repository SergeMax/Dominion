package models.cartes.types.victoire;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Duche extends Carte {
    /*
        Donne 3 points de victoire
        Coût: 5 pièces
     */

    public Duche() {
        setCout(5);
        setType(TypeDeCarte.tresor);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

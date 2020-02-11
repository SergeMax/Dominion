package models.cartes.types.victoire;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Domaine extends Carte {
    /*
        Donne 1 point de victoire
        Coût: 2 pièces
     */

    public Domaine() {
        setCout(2);
        setType(TypeDeCarte.tresor);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

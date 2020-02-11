package models.cartes.types.victoire;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Malediction extends Carte {
    /*
        Enlève 1 point de victoire
        Coût: 0 pièce
     */

    public Malediction() {
        setCout(0);
        setType(TypeDeCarte.tresor);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

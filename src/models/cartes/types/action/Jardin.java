package models.cartes.types.action;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Jardin extends Carte {
    /*
        Effet: Vaut 1 point de victoire pour chaque 10 cartes que vous avez (arrondi à l'unité inférieure).
        Coût: 4 pièces
        Action - Victoire
     */

    public Jardin() {
        setCout(4);
        setType(TypeDeCarte.victoire_action);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

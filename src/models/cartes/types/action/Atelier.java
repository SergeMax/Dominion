package models.cartes.types.action;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Atelier extends Carte {
    /*
        Effet: Recevez une carte coûtant jusqu'à 4 pièces.
        Coût: 3 pièces
        Action
     */

    public Atelier() {
        setCout(3);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    /*
        Le joueur peut choisir une carte sur le terrain ayant une valeur égal ou inférieur à 4
     */
}

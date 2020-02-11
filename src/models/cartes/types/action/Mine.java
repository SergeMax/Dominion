package models.cartes.types.action;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Mine extends Carte {
    /*
        Effet: Vous pouvez écarter une Carte Trésor de votre main. Recevez une Carte Trésor coûtant jusqu'à 3 pièces de plus.
        Coût: 5 pièces
        Action
     */

    public Mine() {
        setCout(5);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

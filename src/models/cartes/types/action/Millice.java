package models.cartes.types.action;
import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Millice extends Carte {
    /*
        Donne 1 pièce
        Effet: Tous vos adversaires défaussent jusqu'à avoir 3 cartes en main.
        Coût: 4 pièces
        Action - Attaque
     */

    public Millice() {
        setCout(4);
        setType(TypeDeCarte.attaque_action);
        setLocalisation(LocalisationDesCartes.reserve);
    }


}

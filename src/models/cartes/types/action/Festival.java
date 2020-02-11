package models.cartes.types.action;

import models.Joueur;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Festival extends Carte {
    /*
        Donne 2 Actions, 1 Achat et 2 pièces
        Coût: 5 pièces
        Action
     */

    public Festival() {
        setCout(5);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

package models.cartes.types.action;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

import java.util.ArrayList;

public class Forgeron extends Carte {
    /*
        Donne 3 Cartes
        Coût: 4 pièces
        Action
     */

    public Forgeron() {
        setCout(4);
        getType().add(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

package models.cartes.types.action;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Cave extends Carte {
    /*
        Donne 1 Action
        Effet: Défaussez autant de cartes que vous voulez, puis piochez-en le même nombre.
        Coût: 2 pièces
        Action
     */

    public Cave() {
        setCout(2);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    /*
        Joueur choisit autant de carte qu'il veut défausser et doit piocher le même nombre
     */
}

package models.cartes.types.action;

import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Bureaucrate extends Carte {
    /*
        Effet: Recevez un Argent sur votre pioche.
               Tous vos adversaires dévoilent une carte Victoire de leur main et la placent sur leur pioche (ou dévoilent une main sans carte Victoire).
        Coût: 4 pièces
        Action - Attaque
     */

    public Bureaucrate() {
        setCout(4);
        setType(TypeDeCarte.attaque_action);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    /*
        Recevoir une carte Argent, les joueurs qui ne jouent pas montre une carte victoire si ils en ont une et doit être déposé sur le
        dessus du deck
     */
}

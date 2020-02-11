package models.cartes.types.tresor;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Cuivre extends Carte {
    /*
        Donne 1 pièce
        Coût: 0 pièce
     */

    public Cuivre() {
        setCout(0);
        setType(TypeDeCarte.tresor);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

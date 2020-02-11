package models.cartes.types.tresor;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Argent extends Carte {
    /*
        Donne 2 pièces
        Coût: 3 pièces
     */

    public Argent() {
        setCout(3);
        setType(TypeDeCarte.tresor);
        setLocalisation(LocalisationDesCartes.reserve);
    }
}

package models.cartes.types.action;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class PreteurSurGage extends Carte {
    /*
        Effet: Vous pouvez écarter un Cuivre de votre main pour avoir +3 pièces.
        Coût: 4 pièces
        Action
     */

    public PreteurSurGage() {
        setCout(4);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

}

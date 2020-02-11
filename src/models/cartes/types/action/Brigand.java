package models.cartes.types.action;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Brigand extends Carte {
    /*
        Effet: Recevez un or.
               Tous vos adversaires dévoilent les 2 premières cartes de leur pioche, écartent une carte Trésor dévoilée autre qu'un Cuivre, et défaussent le reste.
        Coût: 5 pièces
        Action - Attaque
     */

    public Brigand() {
        setCout(5);
        setType(TypeDeCarte.attaque_action);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    /*
        Ajouter une pièce, afficher les deux cartes du dessus deck du/des joueurs qui ne sont pas entrain de jouer
     */
}

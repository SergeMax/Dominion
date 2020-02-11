package models.cartes.types.action;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Artisan extends Carte {
    /*
        Effet: Recevez en main une carte coûtant jusqu'à 5 pièces. Placez une carte de votre main sur votre pioche.
        Coût: 6 pièces
        Action
     */

    public Artisan() {
        setCout(6);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }
    /*
        Pour l'effet, il faudrait un algo qui permet au joueur de choisir une carte sur le terrain ayant un coût égal ou inférieur à 5,
        puis qu'une carte qu'il choisit dans sa main aille sur le top de son deck
     */
}

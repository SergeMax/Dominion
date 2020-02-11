package models.cartes.types.action;
import models.cartes.Carte;
import models.cartes.LocalisationDesCartes;
import models.cartes.TypeDeCarte;

public class Bibliotheque extends Carte {
    /*
        Effet: Piochez jusqu'à ce que vous ayez 7 cartes en main.
               Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
        Coût: 5 pièces
        Action
     */

    public Bibliotheque() {
        setCout(5);
        setType(TypeDeCarte.actions);
        setLocalisation(LocalisationDesCartes.reserve);
    }

    /*
        Besoin de la valeur du nombre de carte en main du joueur, que ça atteint 7. Si il y a une carte action, le joueur a le choix entre
        garder la carte en main ou la défausser.
     */
}
